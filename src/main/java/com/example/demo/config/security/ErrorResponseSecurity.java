package com.example.demo.config.security;

public class ErrorResponseSecurity {
    private Integer status;

    public ErrorResponseSecurity() {
    }

    public ErrorResponseSecurity(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
