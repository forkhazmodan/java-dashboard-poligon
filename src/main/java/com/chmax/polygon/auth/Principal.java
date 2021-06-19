package com.chmax.polygon.auth;

import com.chmax.polygon.model.Privilege;
import com.chmax.polygon.model.Role;
import com.chmax.polygon.model.User;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.HashSet;
import java.util.Set;

@Data
public class Principal implements UserDetails {

    private User user;

    public Principal(User user) {
        this.user = user;
    }

    @Override
    public Set<Privilege> getAuthorities() {
        Set<Privilege> authorities = new HashSet<>();
        for (Role role : this.user.getRoles()) {
            authorities.addAll(role.getPrivileges());
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
