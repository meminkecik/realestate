package com.mekcoop.realestate.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotNull(message = "Email must not be empty")
    @Email(message = "Please enter valid email")
    private String email;

    @NotNull(message = "password must not be empty")
    private String password;
}
