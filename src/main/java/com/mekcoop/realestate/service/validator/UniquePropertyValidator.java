package com.mekcoop.realestate.service.validator;

import com.mekcoop.realestate.exception.ConflictException;
import com.mekcoop.realestate.payload.message.ErrorMessage;
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
}
