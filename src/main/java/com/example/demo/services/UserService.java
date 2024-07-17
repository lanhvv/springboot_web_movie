package com.example.demo.services;

import com.example.demo.dto.request.LoginDTORQ;
import com.example.demo.dto.request.RegisterDTORQ;
import com.example.demo.dto.response.UserDTORS;


public interface UserService {
    void register(RegisterDTORQ userDTORQ);
    UserDTORS login(LoginDTORQ loginDTORQ);
}
