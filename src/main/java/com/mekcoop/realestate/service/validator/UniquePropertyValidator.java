package com.mekcoop.realestate.service.validator;

import com.mekcoop.realestate.entity.user.concretes.RealEstate;
import com.mekcoop.realestate.entity.user.concretes.User;
import com.mekcoop.realestate.exception.ConflictException;
import com.mekcoop.realestate.payload.message.ErrorMessage;
import com.mekcoop.realestate.payload.request.RealEstateRequest;
import com.mekcoop.realestate.payload.request.UserRequest;
import com.mekcoop.realestate.repository.RealEstateRepository;
import com.mekcoop.realestate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniquePropertyValidator {

    private final UserRepository userRepository;
    private final RealEstateRepository realEstateRepository;

    public void checkDuplicate(String ssnOrTaxNumber, String email, String phoneNumber){
        if (
                userRepository.existsBySsn(ssnOrTaxNumber) ||
                realEstateRepository.existsByTaxNumber(ssnOrTaxNumber)
        ){
            throw new ConflictException(String.format(ErrorMessage.ALREADY_REGISTER_MESSAGE_SSN,ssnOrTaxNumber));
        } else if (
                userRepository.existsByEmail(email) ||
                        realEstateRepository.existsByEmail(email)
        ) {
            throw new ConflictException(String.format(ErrorMessage.ALREADY_REGISTER_MESSAGE_EMAIL,email));

        } else if (
                userRepository.existsByPhoneNumber(phoneNumber) ||
                        realEstateRepository.existsByPhoneNumber(phoneNumber)
        ) {
            throw new ConflictException(String.format(ErrorMessage.ALREADY_REGISTER_MESSAGE_PHONE_NUMBER,phoneNumber));
        }
    }
    public void checkUniquePropertiesForRealEstate(RealEstate realEstate, RealEstateRequest realEstateRequest){
        String phoneNumber = "";
        String taxNumber = "";
        String email = "";
        boolean isChanged = false;
        if (!realEstate.getPhoneNumber().equalsIgnoreCase(realEstateRequest.getPhoneNumber())){
            phoneNumber = realEstateRequest.getPhoneNumber();
            isChanged = true;
        }
        if (!realEstate.getTaxNumber().equalsIgnoreCase(realEstateRequest.getTaxNumber())){
            taxNumber = realEstateRequest.getTaxNumber();
            isChanged = true;
        }
        if (!realEstate.getEmail().equalsIgnoreCase(realEstate.getEmail())){
            email = realEstateRequest.getEmail();
            isChanged = true;
        }
        if (isChanged){
            checkDuplicate(taxNumber,email,phoneNumber);
        }
    }
    public void checkUniquePropertiesForUser(User user, UserRequest userRequest){
        String phoneNumber = "";
        String ssn = "";
        String email = "";
        boolean isChanged = false;
        if (!user.getPhoneNumber().equalsIgnoreCase(userRequest.getPhoneNumber())){
            phoneNumber = userRequest.getPhoneNumber();
            isChanged = true;
        }
        if (!user.getSsn().equalsIgnoreCase(userRequest.getSsn())){
            ssn = userRequest.getSsn();
            isChanged = true;
        }
        if (!user.getEmail().equalsIgnoreCase(userRequest.getEmail())){
            email = userRequest.getEmail();
            isChanged = true;
        }
        if (isChanged){
            checkDuplicate(ssn,email,phoneNumber);
        }
    }
}
