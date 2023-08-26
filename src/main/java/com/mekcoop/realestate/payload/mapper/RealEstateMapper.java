package com.mekcoop.realestate.payload.mapper;

import com.mekcoop.realestate.entity.user.concretes.RealEstate;
import com.mekcoop.realestate.payload.request.RealEstateRequest;
import com.mekcoop.realestate.payload.response.RealEstateResponse;
import org.springframework.stereotype.Component;

@Component
public class RealEstateMapper {

    public RealEstate mapRealEstateRequestToRealEstate(RealEstateRequest realEstateRequest){
        return RealEstate.builder()
                .email(realEstateRequest.getEmail())
                .authorizedName(realEstateRequest.getAuthorizedName())
                .authorizedSurname(realEstateRequest.getAuthorizedSurname())
                .companyName(realEstateRequest.getCompanyName())
                .address(realEstateRequest.getAddress())
                .password(realEstateRequest.getPassword())
                .faxNumber(realEstateRequest.getFaxNumber())
                .taxNumber(realEstateRequest.getTaxNumber())
                .phoneNumber(realEstateRequest.getPhoneNumber())
                .build();
    }

    public RealEstateResponse mapRealEstateToRealEstateResponse(RealEstate realEstate){
        return RealEstateResponse.builder()
                .id(realEstate.getId())
                .email(realEstate.getEmail())
                .authorizedName(realEstate.getAuthorizedName())
                .authorizedSurname(realEstate.getAuthorizedSurname())
                .companyName(realEstate.getCompanyName())
                .address(realEstate.getAddress())
                .faxNumber(realEstate.getFaxNumber())
                .taxNumber(realEstate.getTaxNumber())
                .phoneNumber(realEstate.getPhoneNumber())
                .build();
    }

    public RealEstate mapRealEstateRequestToUpdatedRealEstate(RealEstateRequest realEstateRequest,Long id){
        RealEstate realEstate = mapRealEstateRequestToRealEstate(realEstateRequest);
        realEstate.setId(id);
        return realEstate;
    }
}
