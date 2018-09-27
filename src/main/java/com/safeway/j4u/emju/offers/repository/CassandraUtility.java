package com.safeway.j4u.emju.offers.repository;

import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.common.collect.Maps;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraPersistentEntity;
import org.springframework.stereotype.Component;

@Component
public class CassandraUtility {

	private Insert createInsert(CassandraConverter converter, Object entity, ZonedDateTime ttlDate, int additionalTtlDays) {
		CassandraPersistentEntity<?> persistentEntity = converter.getMappingContext()
				.getRequiredPersistentEntity(entity.getClass());
		Map<String, Object> toInsert = Maps.newLinkedHashMap();
		converter.write(entity, toInsert, persistentEntity);
		Insert insert = QueryBuilder.insertInto(persistentEntity.getTableName().toCql());
		insert.using(QueryBuilder.ttl((int)ttl(ttlDate,additionalTtlDays)));
		toInsert.forEach(insert::value);
		return insert;
	}

	public List<Insert> batchInserts(ReactiveCassandraTemplate reactiveCassandraTemplate, ZonedDateTime ttlDate, int additionalTtlDays,
			Object... entities) {
		return Arrays.stream(entities).map(entity -> createInsert(reactiveCassandraTemplate.getConverter(), entity, ttlDate, additionalTtlDays))
				.collect(Collectors.toList());
	}

	public long ttl(ZonedDateTime ttlFutureDateTime, int days) {
		ZonedDateTime now = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC"));
		return Math.abs(Duration.between(now, ttlFutureDateTime.withZoneSameInstant(ZoneId.of("UTC"))).plusDays(days).getSeconds());
	}
}
