package com.mekcoop.realestate.service;

import com.mekcoop.realestate.entity.enums.RoleType;
import com.mekcoop.realestate.entity.user.UserRole;
import com.mekcoop.realestate.exception.ConflictException;
import com.mekcoop.realestate.payload.message.ErrorMessage;
import com.mekcoop.realestate.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRole getUserRole(RoleType roleType){
        return userRoleRepository.findByEnumRoleEquals(roleType).orElseThrow(()->
                new ConflictException(ErrorMessage.ROLE_NOT_FOUND)
        );
    }

    public List<UserRole> getAllUserRole(){
        return userRoleRepository.findAll();
    }

    public UserRole save(RoleType roleType){
        if (userRoleRepository.existsByEnumRoleEquals(roleType)){
            throw new ConflictException(ErrorMessage.ROLE_ALREADY_EXISTS);
        }
        UserRole userRole = UserRole.builder().roleType(roleType).build();
        return userRoleRepository.save(userRole);
    }
}
