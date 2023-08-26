package com.mekcoop.realestate.payload.mapper;

import com.mekcoop.realestate.entity.user.concretes.User;
import com.mekcoop.realestate.payload.request.UserRequest;
import com.mekcoop.realestate.payload.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapUserRequestToUser(UserRequest userRequest){
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .ssn(userRequest.getSsn())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .homePhone(userRequest.getHomePhone())
                .password(userRequest.getPassword())
                .build();
    }

    public UserResponse mapUserToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .homePhone(user.getHomePhone())
                .build();
    }

    public User mapUserRequestToUpdatedUser(UserRequest userRequest,Long id){
        User user = mapUserRequestToUser(userRequest);
        user.setId(id);
        return user;
    }
}
