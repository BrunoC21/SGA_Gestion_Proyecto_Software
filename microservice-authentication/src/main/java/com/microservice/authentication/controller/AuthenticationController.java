package com.microservice.authentication.controller;

import com.microservice.authentication.dto.LoginRequest;
import com.microservice.authentication.dto.LoginResponse;
import com.microservice.authentication.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authService;

    @PostMapping("/register")
    public String register(@RequestBody LoginRequest user) {
        authService.register(user.getUsername(), user.getPassword());
        return "User registered successfully";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getUsername(), request.getPassword());
        return new LoginResponse(token);
    }
}