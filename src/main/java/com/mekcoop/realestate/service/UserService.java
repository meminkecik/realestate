package com.mekcoop.realestate.service;

import com.mekcoop.realestate.entity.enums.RoleType;
import com.mekcoop.realestate.entity.user.User;
import com.mekcoop.realestate.exception.ResourceNotFoundException;
import com.mekcoop.realestate.payload.mapper.UserMapper;
import com.mekcoop.realestate.payload.message.ErrorMessage;
import com.mekcoop.realestate.payload.message.SuccessMessage;
import com.mekcoop.realestate.payload.request.UserRequest;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.payload.response.UserResponse;
import com.mekcoop.realestate.repository.UserRepository;
import com.mekcoop.realestate.service.validator.UniquePropertyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UniquePropertyValidator uniquePropertyValidator;
    private final UserMapper userMapper;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public ResponseMessage<UserResponse> saveUser(UserRequest userRequest) {
        uniquePropertyValidator.checkDuplicate(userRequest.getSsn(),userRequest.getEmail(),userRequest.getPhoneNumber());
        User user = userMapper.mapUserRequestToUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setUserRole(userRoleService.getUserRole(RoleType.USER));
        User savedUser = userRepository.save(user);
        return ResponseMessage.<UserResponse>builder()
                .message(SuccessMessage.USER_SAVE)
                .httpStatus(HttpStatus.CREATED)
                .object(userMapper.mapUserToUserResponse(savedUser))
                .build();
    }
    //PostService classinda kullanildi.
    public User getUserBySsn(String ssn){
        User user = userRepository.findBySsn(ssn).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.NOT_FOUND_USER_SSN_MESSAGE,ssn))
                );
        return user;
    }

    public long countAllUser() {
        return userRepository.count();
    }
}
