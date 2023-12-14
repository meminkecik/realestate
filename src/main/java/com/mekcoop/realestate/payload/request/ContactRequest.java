package com.mekcoop.realestate.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ContactRequest {

    @NotNull(message = "Please enter your name")
    @Size(min = 2,max = 16,message = "Your first name should be at least 2 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+",message = "Your first name must consist of the character .")
    private String name;

    @Email(message = "Please enter valid email")
    @NotNull(message = "Please enter email")
    private String email;

    @NotNull(message = "Please enter subject")
    @Size(min = 2,max = 24,message = "Your subject should be at least 2 chars")
    private String subject;

    @NotNull(message = "Please enter message")
    @Size(min = 2,max = 600, message = "Your message should be at least 2 chars")
    private String message;
}
