package com.mekcoop.realestate.controller.user;

import com.mekcoop.realestate.payload.request.UserRequest;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.payload.response.UserResponse;
import com.mekcoop.realestate.service.user.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseMessage<UserResponse> saveUser(@RequestBody @Valid UserRequest userRequest){
        return userService.saveUser(userRequest);
    }
    @DeleteMapping("/delete/{userId}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseMessage deleteRealEstate(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }

    @PutMapping("/updateUser/{userId}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseMessage<UserResponse> updateUser(@RequestBody @Valid UserRequest userRequest, @PathVariable Long userId){
        return userService.updateUser(userRequest,userId);
    }
}
