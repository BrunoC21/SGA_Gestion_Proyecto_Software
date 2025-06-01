package com.microservice.authentication.controller;

import com.microservice.authentication.dto.LoginRequest;
import com.microservice.authentication.dto.LoginResponse;
import com.microservice.authentication.dto.RegisterRequest;
import com.microservice.authentication.services.IAuthenticationService;
import com.microservice.authentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getUsername(), request.getPassword());
        return new LoginResponse(token);
    }

    @PutMapping("/edit-profile")
    public String editProfile(@RequestBody RegisterRequest request, Principal principal) {
        userService.updateUserDataByUsername(principal.getName(), request);
        return "Profile updated";
    }

    @PutMapping("/admin/update-role/{userId}")
    public String updateRole(@PathVariable Long userId, @RequestParam String role) {
        userService.updateUserRole(userId, role);
        return "Role updated";
    }

    @DeleteMapping("/admin/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "User deleted";
    }

    @PutMapping("/admin/update-user/{userId}")
    public String updateUserData(@PathVariable Long userId, @RequestBody RegisterRequest updatedData) {
        userService.updateUserData(userId, updatedData);
        return "User data updated";
    }

    @GetMapping("/auth/whoami")
    public String whoami() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return "User: " + auth.getName() + ", Roles: " + auth.getAuthorities();
    }

}