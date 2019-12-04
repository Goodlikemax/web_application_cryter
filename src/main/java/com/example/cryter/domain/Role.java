package com.example.cryter.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * "Created by : goodlikemax"
 * "Date: "03.12.2019
 */
public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
