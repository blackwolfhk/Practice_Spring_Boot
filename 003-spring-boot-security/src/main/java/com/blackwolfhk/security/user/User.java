package com.blackwolfhk.security.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    // The following methods are implemented from the UserDetails interface.
    // They provide information about the user that Spring Security needs for authentication and authorization.

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return a list of granted authorities for the user
        // In this case, the only authority is the user's role.
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        // Return the user's password for authentication
        return password;
    }

    @Override
    public String getUsername() {
        // Return the user's email as the username for authentication
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Return true if the user account is not expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return true if the user account is not locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return true if the user's credentials are not expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Return true if the user account is enabled
        return true;
    }
}
