package com.mekcoop.realestate.security.service;

import com.mekcoop.realestate.entity.user.concretes.RealEstate;
import com.mekcoop.realestate.entity.user.concretes.User;
import com.mekcoop.realestate.repository.RealEstateRepository;
import com.mekcoop.realestate.repository.UserRepository;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final RealEstateRepository realEstateRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailEquals(username);
        RealEstate realEstate = realEstateRepository.findByEmailEquals(username);

        if (user !=null){
            return new UserDetailsImpl(user.getId(),user.getEmail(),user.getFirstName(),user.getPassword(),user.getUserRole().getRoleType().name());
        } else if (realEstate!=null) {
            return new UserDetailsImpl(realEstate.getId(), realEstate.getEmail(),realEstate.getCompanyName(),realEstate.getPassword(),realEstate.getUserRole().getRoleType().name());
        }
        throw new UsernameNotFoundException("User " + username + " not found");
    }
}
