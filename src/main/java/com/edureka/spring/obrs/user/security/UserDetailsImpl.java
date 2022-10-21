package com.edureka.spring.obrs.user.security;

import com.edureka.spring.obrs.common.utils.LogUtil;
import com.edureka.spring.obrs.role.entity.Role;
import com.edureka.spring.obrs.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final String CLASS_NAME = this.getClass().getName();

    private Collection<SimpleGrantedAuthority> authorities;
    private User user;
    private String username;
    private String password;
    private Boolean enabled = true;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        roles.stream().forEach(role -> {
            LogUtil.logDebug(LOG,CLASS_NAME,"getAuthorities","role.getRole() = " + role.getRole());
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
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
        return enabled;
    }
}
