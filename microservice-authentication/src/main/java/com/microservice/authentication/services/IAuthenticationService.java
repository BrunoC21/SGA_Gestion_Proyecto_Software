package com.microservice.authentication.services;

public interface IAuthenticationService {
    String login(String username, String password);
    void register(String username, String password);
}