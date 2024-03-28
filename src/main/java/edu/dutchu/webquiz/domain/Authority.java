package edu.dutchu.webquiz.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
public class Authority implements GrantedAuthority {

    @Id
    @Enumerated(EnumType.STRING)
    private Authorities name;
    public Authority() {
    }
    public Authority(Authorities name) {
        this.name = name;
    }
    @Override
    public String getAuthority() {
        return this.name.toString();
    }

    public void setAuthority(Authorities name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return name == authority.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
