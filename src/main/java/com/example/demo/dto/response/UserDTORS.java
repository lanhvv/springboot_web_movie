package com.example.demo.dto.response;

import java.util.List;

public class UserDTORS {
    private String name;
    private List<RoleDTORS> roles;
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoleDTORS> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTORS> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
