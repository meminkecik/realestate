package com.mekcoop.realestate.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserRequest {
    @NotNull(message = "Please enter your first name")
    @Size(min = 2,max = 16,message = "Your first name should be at least 2 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+",message = "Your first name must consist of the character .")
    private String firstName;
    @NotNull(message = "Please enter your last name")
    @Size(min = 2,max = 16,message = "Your last name should be at least 2 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+",message = "Your last name must consist of the character .")
    private String lastName;
    @NotNull(message = "Please enter your ssn")
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$",
            message = "Please enter valid SSN number")
    private String ssn;
    @Email(message = "Please enter valid email")
    @NotNull(message = "Please enter email")
    private String email;
    @NotNull(message = "Please enter password")
    @Size(min = 8,max = 16,message = "Your password should be at least 8 chars")
    private String password;
    private String homePhone;
    @NotNull(message = "Please enter your phone number")
    @Size(min = 12,max = 12,message = "Your phone number should be 12 chars long")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+",message = "Your phone number must consist of the character .")
    private String phoneNumber;
}
