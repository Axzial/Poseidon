package com.nnk.springboot.security.entity;

import com.nnk.springboot.security.utils.JwtUtils;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticationToken implements Authentication {

    private final String token;
    private boolean isAuthenticated;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtAuthenticationToken(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getDetails() {
        return JwtUtils.getClaims(token);
    }

    @Override
    public Object getPrincipal() {
        return JwtUtils.getSubjectFromToken(token);
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        isAuthenticated = b;
    }

    @Override
    public String getName() {
        return token;
    }
}
