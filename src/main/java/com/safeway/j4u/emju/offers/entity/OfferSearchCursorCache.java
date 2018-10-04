package com.safeway.j4u.emju.offers.entity;

import java.util.Map;
import java.util.UUID;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@Table("offer_search_cursor_cache")
public class OfferSearchCursorCache {

  @PrimaryKey("search_id")
  private UUID searchId;
  @Column("cursor_mark")
  private Map<Integer, String> cursorMark;
  @Column("search_query")
  private String searchQuery;

}
