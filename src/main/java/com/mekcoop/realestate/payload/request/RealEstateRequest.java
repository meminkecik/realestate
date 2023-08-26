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
public class RealEstateRequest {
    @NotNull(message = "Please enter your company name")
    @Size(min = 2,max = 16,message = "Your company name should be at least 2 chars")
    private String companyName;

    @NotNull(message = "Please enter your authorized first name")
    @Size(min = 2,max = 16,message = "Your authorized first name should be at least 2 chars")
    private String authorizedName;

    @NotNull(message = "Please enter your authorized last name")
    @Size(min = 2,max = 16,message = "Your authorized last name should be at least 2 chars")
    private String authorizedSurname;

    @NotNull(message = "Please enter your password")
    @Size(min = 8,max = 16,message = "Your password should be at least 8 chars")
    private String password;

    @Email(message = "Please enter valid email")
    @NotNull(message = "Please enter email")
    private String email;

    @NotNull(message = "Please enter your phone number")
    private String phoneNumber;

    private String faxNumber;

    private String address;
    @NotNull(message = "Please enter your tax number")
    @Pattern(regexp = "^[0-9]{10}$",
            message = "Please enter valid tax number")
    private String taxNumber;
}
