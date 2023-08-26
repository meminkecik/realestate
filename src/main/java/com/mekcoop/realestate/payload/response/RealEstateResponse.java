package com.mekcoop.realestate.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RealEstateResponse {
    private Long id;
    private String companyName;
    private String email;
    private String authorizedName;
    private String authorizedSurname;
    private String phoneNumber;
    private String faxNumber;
    private String address;
    private String taxNumber;
}
