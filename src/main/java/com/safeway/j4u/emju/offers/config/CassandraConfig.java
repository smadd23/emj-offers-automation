package com.safeway.j4u.emju.offers.config;

import static java.util.Objects.nonNull;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PlainTextAuthProvider;
import com.datastax.driver.core.QueryLogger;
import com.datastax.driver.core.Session;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import uk.sky.cqlmigrate.CassandraClusterFactory;
import uk.sky.cqlmigrate.CassandraLockConfig;
import uk.sky.cqlmigrate.CqlMigrator;
import uk.sky.cqlmigrate.CqlMigratorFactory;

@Configuration
@EnableReactiveCassandraRepositories(basePackages="com.safeway.j4u.emju.offers")
@Slf4j
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {
	
	@Value("${spring.data.cassandra.contact-points}")
	private String cassandraHost;
	
	@Value("${spring.data.cassandra.port}")
	private String cassandraPort;
	
	@Value("${spring.data.cassandra.username}")
	private String cassandraUserName;
	
	@Value("${spring.data.cassandra.password}")
	private String cassandraPassword;
	
	@Value("${spring.data.cassandra.keyspace-name}")
	private String cassandraKeyspace;

	@PostConstruct
	public void migrateDbChanges() throws URISyntaxException, IOException {
		debugQueryLog();
		URI uri = getClass().getResource("/cql").toURI();
		Path cqlScriptsFolder;
		if (uri.getScheme().equals("jar")) {
			FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
			cqlScriptsFolder = fileSystem.getPath("BOOT-INF/classes/cql");
		} else {
			cqlScriptsFolder = Paths.get(uri);
		}
		List<Path> cqlScriptsFoldersList = new ArrayList<Path>();
		cqlScriptsFoldersList.add(cqlScriptsFolder);
		cqlMigratePrerequisite();
		CassandraLockConfig lockConfig = CassandraLockConfig.builder().withTimeout(Duration.ofSeconds(10))
				.withPollingInterval(Duration.ofMillis(500)).build();
		CqlMigrator migrator = CqlMigratorFactory.create(lockConfig);

		migrator.migrate(this.cassandraHost.split(","), Integer.parseInt(this.cassandraPort), this.cassandraUserName,
				this.cassandraPassword, this.cassandraKeyspace, cqlScriptsFoldersList);
	}

	@Override
	protected String getKeyspaceName() {
		return this.cassandraKeyspace;
	}	
	
	@Override
	protected String getContactPoints() {
		return this.cassandraHost;
	}
	
	@Override
	protected int getPort() {
		return new Integer(this.cassandraPort);
	}
	
	@Override
	protected AuthProvider getAuthProvider() {
		return new PlainTextAuthProvider(cassandraUserName, cassandraPassword);
	}
	

	@ReadingConverter
	private enum DateToZonedDateTime implements Converter<Date, ZonedDateTime> {
		INSTANCE;

		@Override
		public ZonedDateTime convert(@NotNull Date source) {
			return ZonedDateTime.ofInstant(source.toInstant(), ZoneOffset.UTC);
		}
	}

	@ReadingConverter
	private enum TimestampToZonedDateTime implements Converter<Timestamp, ZonedDateTime> {
		INSTANCE;

		@Override
		public ZonedDateTime convert(@NotNull Timestamp source) {
			return ZonedDateTime.ofInstant(source.toInstant(), ZoneOffset.UTC);
		}
	}

	@WritingConverter
	@ReadingConverter
	private enum ZonedDateTimeToTimestamp implements Converter<ZonedDateTime, Timestamp> {
		INSTANCE;

		@Override
		public Timestamp convert(@NotNull ZonedDateTime source) {
			return new Timestamp(source.withZoneSameInstant(ZoneId.of("UTC")).toInstant().toEpochMilli());
		}
	}

	@Override
	public CustomConversions customConversions() {
		return new CassandraCustomConversions(
				Arrays.asList(
						TimestampToZonedDateTime.INSTANCE,
						ZonedDateTimeToTimestamp.INSTANCE,
						DateToZonedDateTime.INSTANCE));
	}

	private void debugQueryLog() {
		if(log.isDebugEnabled()) {
			try (Cluster cluster = CassandraClusterFactory
					.createCluster(this.cassandraHost.split(","), Integer.parseInt(this.cassandraPort),
							this.cassandraUserName,
							this.cassandraPassword)) {
				QueryLogger queryLogger = QueryLogger.builder()
						.withConstantThreshold(500)
						.build();
				cluster.register(queryLogger);
			}
		}
	}

	private void cqlMigratePrerequisite() {
		Session session = null;
		try {
			Cluster cluster = CassandraClusterFactory.createCluster(this.cassandraHost.split(","), Integer.parseInt(this.cassandraPort), this.cassandraUserName,
					this.cassandraPassword);
			session = cluster.connect();
			session.execute("CREATE KEYSPACE IF NOT EXISTS cqlmigrate WITH replication = { 'class': 'SimpleStrategy', 'replication_factor': '1' }");
			session.execute("CREATE TABLE IF NOT EXISTS cqlmigrate.locks (name text PRIMARY KEY, client text)");
			session.execute("CREATE KEYSPACE IF NOT EXISTS offers WITH replication = { 'class':'SimpleStrategy', 'replication_factor': '1' }");
		}
		catch(Exception e) {
			log.info("Truncate lock failed");
		}
		finally {
			if (nonNull(session))
				session.close();
		}
	}
}
