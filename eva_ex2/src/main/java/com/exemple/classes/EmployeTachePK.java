package com.exemple.classes;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeTachePK implements Serializable {

    private Integer employeId;
    private Integer tacheId;

    public EmployeTachePK() {
    }

    public EmployeTachePK(Integer employeId, Integer tacheId) {
        this.employeId = employeId;
        this.tacheId = tacheId;
    }

    public Integer getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Integer employeId) {
        this.employeId = employeId;
    }

    public Integer getTacheId() {
        return tacheId;
    }

    public void setTacheId(Integer tacheId) {
        this.tacheId = tacheId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeTachePK)) return false;
        EmployeTachePK that = (EmployeTachePK) o;
        return Objects.equals(employeId, that.employeId) &&
                Objects.equals(tacheId, that.tacheId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeId, tacheId);
    }
}
