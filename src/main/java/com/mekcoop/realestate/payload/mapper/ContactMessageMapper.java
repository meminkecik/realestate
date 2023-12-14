package com.mekcoop.realestate.payload.mapper;

import com.mekcoop.realestate.entity.business.ContactMessage;
import com.mekcoop.realestate.entity.user.concretes.User;
import com.mekcoop.realestate.payload.request.ContactRequest;
import com.mekcoop.realestate.payload.request.UserRequest;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContactMessageMapper {
    public ContactMessage mapContactRequestToContactMessage(ContactRequest contactRequest){
        return ContactMessage.builder()
                .name(contactRequest.getName())
                .email(contactRequest.getEmail())
                .subject(contactRequest.getSubject())
                .message(contactRequest.getMessage())
                .build();
    }
}
