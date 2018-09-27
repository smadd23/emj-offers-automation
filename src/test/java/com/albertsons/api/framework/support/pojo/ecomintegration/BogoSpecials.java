package com.albertsons.api.framework.support.pojo.ecomintegration;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This class contains the pojo representation of bogo specials object.
 *
 * @author vbonk00
*/

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ack",
        "departments"
})
public class BogoSpecials {

    @JsonProperty("ack")
    private Boolean ack;

    @JsonProperty("departments")
    private List<Department> departments = null;

    @JsonProperty("ack")
    public Boolean getAck() {
        return ack;
    }

    @JsonProperty("ack")
    public void setAck(Boolean ack) {
        this.ack = ack;
    }

    @JsonProperty("departments")
    public List<Department> getDepartments() {
        return departments;
    }

    @JsonProperty("departments")
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        BogoSpecials that = (BogoSpecials) o;
        return Objects.equal(ack, that.ack) &&
                Objects.equal(departments, that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ack, departments);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ack", ack)
                .add("departments", departments)
                .toString();
    }
}
