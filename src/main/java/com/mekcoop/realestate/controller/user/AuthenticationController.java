package com.mekcoop.realestate.controller.user;

import com.mekcoop.realestate.payload.request.LoginRequest;
import com.mekcoop.realestate.payload.response.AuthResponse;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.payload.response.UserResponse;
import com.mekcoop.realestate.service.user.AuthenticationService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticationUser(@RequestBody @Valid LoginRequest loginRequest){
        return authenticationService.authenticateUser(loginRequest);
    }
    @GetMapping("/me")
    public UserDetails getMe(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
