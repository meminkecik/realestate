package com.mekcoop.realestate.service.contact;

import com.mekcoop.realestate.entity.business.ContactMessage;
import com.mekcoop.realestate.entity.business.Post;
import com.mekcoop.realestate.entity.user.concretes.RealEstate;
import com.mekcoop.realestate.entity.user.concretes.User;
import com.mekcoop.realestate.payload.mapper.ContactMessageMapper;
import com.mekcoop.realestate.payload.message.SuccessMessage;
import com.mekcoop.realestate.payload.request.ContactRequest;
import com.mekcoop.realestate.payload.request.PostRequest;
import com.mekcoop.realestate.payload.response.PostResponse;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.repository.ContactRepository;
import com.mekcoop.realestate.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMessageMapper contactMessageMapper;

    public ResponseMessage saveMessage(ContactRequest contactRequest) {

        ContactMessage contactMessage = contactMessageMapper.mapContactRequestToContactMessage(contactRequest);
        contactRepository.save(contactMessage);

        return ResponseMessage.<PostResponse>builder()
                .httpStatus(HttpStatus.CREATED)
                .message(SuccessMessage.POST_SAVE)
                .build();
    }
}
