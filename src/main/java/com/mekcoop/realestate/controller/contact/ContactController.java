package com.mekcoop.realestate.controller.contact;

import com.mekcoop.realestate.payload.request.ContactRequest;
import com.mekcoop.realestate.payload.request.PostRequest;
import com.mekcoop.realestate.payload.response.PostResponse;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.service.contact.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/contactMessages")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping("/save")
    public ResponseMessage<PostResponse> saveMessage(@RequestBody @Valid ContactRequest contactRequest){
        return contactService.saveMessage(contactRequest);
    }
}
