package com.techstore.estore.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

public class RegisterRequestModel {

    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "surname is mandatory")
    private String surname;

    @NotNull(message = "email address is mandatory")
    @Email(
            message = "Email is not valid",
            regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"
    )
    private String emailAddress;

    @NotNull(message = "mobile phone is mandatory")
    private String mobilePhone;

    @NotNull(message = "password is mandatory")
    @Size(min = 8, max = 50, message = "password length must be between 8 and 50 characters")
    private String password;

    public RegisterRequestModel(String name, String surname, String emailAddress, String mobilePhone, String password) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.mobilePhone = mobilePhone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getPassword() {
        return password;
    }
}
