package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of cookie.
 *
 * @author vbonk00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "comment",
  "commentUri",
  "httpOnly",
  "discard",
  "domain",
  "expired",
  "expires",
  "name",
  "path",
  "port",
  "secure",
  "timeStamp",
  "value",
  "version"
})
public class Cookie {

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("commentUri")
  private Object commentUri;

  @JsonProperty("httpOnly")
  private Boolean httpOnly;

  @JsonProperty("discard")
  private Boolean discard;

  @JsonProperty("domain")
  private String domain;

  @JsonProperty("expired")
  private Boolean expired;

  @JsonProperty("expires")
  private String expires;

  @JsonProperty("name")
  private String name;

  @JsonProperty("path")
  private String path;

  @JsonProperty("port")
  private String port;

  @JsonProperty("secure")
  private Boolean secure;

  @JsonProperty("timeStamp")
  private String timeStamp;

  @JsonProperty("value")
  private String value;

  @JsonProperty("version")
  private Integer version;

  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  @JsonProperty("comment")
  public void setComment(String comment) {
    this.comment = comment;
  }

  @JsonProperty("commentUri")
  public Object getCommentUri() {
    return commentUri;
  }

  @JsonProperty("commentUri")
  public void setCommentUri(Object commentUri) {
    this.commentUri = commentUri;
  }

  @JsonProperty("httpOnly")
  public Boolean getHttpOnly() {
    return httpOnly;
  }

  @JsonProperty("httpOnly")
  public void setHttpOnly(Boolean httpOnly) {
    this.httpOnly = httpOnly;
  }

  @JsonProperty("discard")
  public Boolean getDiscard() {
    return discard;
  }

  @JsonProperty("discard")
  public void setDiscard(Boolean discard) {
    this.discard = discard;
  }

  @JsonProperty("domain")
  public String getDomain() {
    return domain;
  }

  @JsonProperty("domain")
  public void setDomain(String domain) {
    this.domain = domain;
  }

  @JsonProperty("expired")
  public Boolean getExpired() {
    return expired;
  }

  @JsonProperty("expired")
  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  @JsonProperty("expires")
  public String getExpires() {
    return expires;
  }

  @JsonProperty("expires")
  public void setExpires(String expires) {
    this.expires = expires;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("path")
  public String getPath() {
    return path;
  }

  @JsonProperty("path")
  public void setPath(String path) {
    this.path = path;
  }

  @JsonProperty("port")
  public String getPort() {
    return port;
  }

  @JsonProperty("port")
  public void setPort(String port) {
    this.port = port;
  }

  @JsonProperty("secure")
  public Boolean getSecure() {
    return secure;
  }

  @JsonProperty("secure")
  public void setSecure(Boolean secure) {
    this.secure = secure;
  }

  @JsonProperty("timeStamp")
  public String getTimeStamp() {
    return timeStamp;
  }

  @JsonProperty("timeStamp")
  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  @JsonProperty("version")
  public Integer getVersion() {
    return version;
  }

  @JsonProperty("version")
  public void setVersion(Integer version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cookie cookie = (Cookie) o;
    return Objects.equal(comment, cookie.comment)
        && Objects.equal(commentUri, cookie.commentUri)
        && Objects.equal(httpOnly, cookie.httpOnly)
        && Objects.equal(discard, cookie.discard)
        && Objects.equal(domain, cookie.domain)
        && Objects.equal(expired, cookie.expired)
        && Objects.equal(expires, cookie.expires)
        && Objects.equal(name, cookie.name)
        && Objects.equal(path, cookie.path)
        && Objects.equal(port, cookie.port)
        && Objects.equal(secure, cookie.secure)
        && Objects.equal(timeStamp, cookie.timeStamp)
        && Objects.equal(value, cookie.value)
        && Objects.equal(version, cookie.version);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        comment,
        commentUri,
        httpOnly,
        discard,
        domain,
        expired,
        expires,
        name,
        path,
        port,
        secure,
        timeStamp,
        value,
        version);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("comment", comment)
        .add("commentUri", commentUri)
        .add("httpOnly", httpOnly)
        .add("discard", discard)
        .add("domain", domain)
        .add("expired", expired)
        .add("expires", expires)
        .add("name", name)
        .add("path", path)
        .add("port", port)
        .add("secure", secure)
        .add("timeStamp", timeStamp)
        .add("value", value)
        .add("version", version)
        .toString();
  }
}
