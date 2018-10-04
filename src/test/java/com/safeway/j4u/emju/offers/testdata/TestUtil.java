package com.safeway.j4u.emju.offers.testdata;

import com.datastax.driver.core.querybuilder.Batch;
import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.Delete.Where;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraPersistentEntity;

public class TestUtil {


  private static Insert createInsert(CassandraConverter converter, String cassandraKeyspace, Object entity) {
    CassandraPersistentEntity<?> persistentEntity = converter.getMappingContext()
        .getRequiredPersistentEntity(entity.getClass());
    Map<String, Object> toInsert = Maps.newLinkedHashMap();
    converter.write(entity, toInsert, persistentEntity);
    Insert insert = QueryBuilder.insertInto(cassandraKeyspace, persistentEntity.getTableName().toCql());
    toInsert.forEach(insert::value);
    return insert;
  }

  public static boolean nonReactiveInserts(CassandraTemplate cassandraTemplate, String cassandraKeyspace, Object... entities) {
    List<Insert> statements = Arrays.stream(entities).map(entity -> createInsert(cassandraTemplate.getConverter(), cassandraKeyspace, entity))
        .collect(Collectors.toList());
    Batch batch = QueryBuilder.batch();
    statements.forEach(batch::add);
    return cassandraTemplate.getCqlOperations().execute(batch);
  }

  private static Delete createDelete(CassandraConverter converter, String cassandraKeyspace, Object entity) {

    CassandraPersistentEntity<?> persistentEntity = converter.getMappingContext()
        .getRequiredPersistentEntity(entity.getClass());

    Delete.Selection deleteSelection = QueryBuilder.delete();
    Delete delete = deleteSelection.from(cassandraKeyspace, persistentEntity.getTableName().toCql());
    Where where = delete.where();
    converter.write(entity, where);

    return delete;
  }

  public static boolean nonReactiveDeletes(CassandraTemplate cassandraTemplate,String cassandraKeyspace,  Object... entities) {
    List<Delete> statements = Arrays.stream(entities).map(entity -> createDelete(cassandraTemplate.getConverter(), cassandraKeyspace, entity))
        .collect(Collectors.toList());
    Batch batch = QueryBuilder.batch();
    statements.forEach(batch::add);
    return cassandraTemplate.getCqlOperations().execute(batch);
  }

}
