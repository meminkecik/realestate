package com.mekcoop.realestate.controller;

import com.mekcoop.realestate.payload.request.UserRequest;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.payload.response.UserResponse;
import com.mekcoop.realestate.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseMessage<UserResponse> saveUser(@RequestBody @Valid UserRequest userRequest){
        return userService.saveUser(userRequest);
    }
}