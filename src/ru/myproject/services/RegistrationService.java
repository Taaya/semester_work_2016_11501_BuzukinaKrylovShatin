package ru.myproject.services;

/**
 * Created by taa on 07.11.16.
 */
public interface RegistrationService {
    boolean registrateUser(String username, String password, String email, String phone);
}
