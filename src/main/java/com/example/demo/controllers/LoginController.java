package com.example.demo.controllers;

import com.example.demo.dto.request.LoginDTORQ;
import com.example.demo.dto.request.RegisterDTORQ;
import com.example.demo.dto.response.UserDTORS;
import com.example.demo.services.UserService;
import com.example.demo.utils.PathUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathUtils.ROOT)
public class LoginController {
    private final UserService userService;


    public LoginController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping(PathUtils.REGISTER)
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterDTORQ userDTORQ) {
        this.userService.register(userDTORQ);
        return  ResponseEntity.status(HttpStatus.OK).body(null); // method body có formal type :))
    }

    @PostMapping(PathUtils.LOGIN)
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDTORQ loginDTORQ) {
        UserDTORS user = this.userService.login(loginDTORQ);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
