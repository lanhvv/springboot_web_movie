package com.example.demo.utils;

public final class CommonDataUtils {
    public interface Role {
        String USER = "USER"; // người dùng
        String SYSTEM = "SYSTEM"; // cấp cao nhất
        String ADMIN = "ADMIN";// có quyền thao tác quản trị
    }

    public interface User {
        String ANONYMOUS = "ANONYMOUS";
    }
}
