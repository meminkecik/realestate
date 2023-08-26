package com.mekcoop.realestate.payload.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String homePhone;
    private String phoneNumber;
}
