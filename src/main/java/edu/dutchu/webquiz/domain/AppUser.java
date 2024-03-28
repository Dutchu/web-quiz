package edu.dutchu.webquiz.domain;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @Column(name = "password_hash", length = 60)
    private String hashedPwd;
    @JoinTable(
            name = "APP_USER_AUTHORITY",
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_name", referencedColumnName = "name")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    //TODO: Parametrize this value (BatchSize) to be included in Constants class or defined in app.properties
    @BatchSize(size = 20)
    private Set<Authority> authorities;
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Quiz> quizzes = new ArrayList<>();
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    public AppUser(){}
    public AppUser(
            String email,
            String hashedPwd,
            Set<Authority> authorities
    ) {
        this.email = email;
        this.hashedPwd = hashedPwd;
        this.authorities = authorities;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }

    public Long getId() {
        return this.id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    //Below methods are part of Spring Security Core functionality UserDetails interface
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    public String getPassword() {
        return this.hashedPwd;
    }

    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }
    //End of core interface functionality
}
