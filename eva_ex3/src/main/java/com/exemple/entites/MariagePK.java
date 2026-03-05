package com.exemple.entites;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MariagePK implements Serializable {
    private Integer homme;
    private Integer femme;

    public MariagePK() {
    }

    public MariagePK(Integer homme, Integer femme) {
        this.homme = homme;
        this.femme = femme;
    }

    public Integer getHomme() {
        return homme;
    }

    public void setHomme(Integer homme) {
        this.homme = homme;
    }

    public Integer getFemme() {
        return femme;
    }

    public void setFemme(Integer femme) {
        this.femme = femme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MariagePK)) return false;
        MariagePK that = (MariagePK) o;
        return Objects.equals(homme, that.homme) &&
                Objects.equals(femme, that.femme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homme, femme);
    }
}
