package com.techstore.estore.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
