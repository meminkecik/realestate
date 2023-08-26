package com.mekcoop.realestate.service;

import com.mekcoop.realestate.entity.enums.RoleType;
import com.mekcoop.realestate.entity.user.RealEstate;
import com.mekcoop.realestate.exception.ResourceNotFoundException;
import com.mekcoop.realestate.payload.mapper.RealEstateMapper;
import com.mekcoop.realestate.payload.message.ErrorMessage;
import com.mekcoop.realestate.payload.message.SuccessMessage;
import com.mekcoop.realestate.payload.request.RealEstateRequest;
import com.mekcoop.realestate.payload.response.RealEstateResponse;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.repository.RealEstateRepository;
import com.mekcoop.realestate.service.validator.UniquePropertyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RealEstateService {

    private final RealEstateRepository realEstateRepository;
    private final UniquePropertyValidator uniquePropertyValidator;
    private final RealEstateMapper realEstateMapper;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public ResponseMessage<RealEstateResponse> saveRealEstate(RealEstateRequest realEstateRequest) {
        uniquePropertyValidator.checkDuplicate(realEstateRequest.getTaxNumber(), realEstateRequest.getEmail(), realEstateRequest.getPhoneNumber());
        RealEstate realEstate = realEstateMapper.mapRealEstateRequestToRealEstate(realEstateRequest);
        realEstate.setPassword(passwordEncoder.encode(realEstateRequest.getPassword()));
        realEstate.setUserRole(userRoleService.getUserRole(RoleType.REAL_ESTATE));
        RealEstate savedRealEstate = realEstateRepository.save(realEstate);
        return ResponseMessage.<RealEstateResponse>builder()
                .message(SuccessMessage.REAL_ESTATE_SAVE)
                .httpStatus(HttpStatus.CREATED)
                .object(realEstateMapper.mapRealEstateResponseToRealEstate(savedRealEstate))
                .build();
    }

    //Post servicede kullanilmak icin yazildi
    public RealEstate findRealEstateByEmail(String email){
        RealEstate realEstate = realEstateRepository.findByEmail(email).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.NOT_FOUND_REAL_ESTATE_EMAIL_MESSAGE,email))
        );
        return realEstate;
    }
}
