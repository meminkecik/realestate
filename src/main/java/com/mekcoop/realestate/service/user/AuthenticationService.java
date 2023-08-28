package com.mekcoop.realestate.service.user;

import com.mekcoop.realestate.payload.request.LoginRequest;
import com.mekcoop.realestate.payload.response.AuthResponse;
import com.mekcoop.realestate.security.jwt.JwtUtils;
import com.mekcoop.realestate.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    public ResponseEntity<AuthResponse> authenticateUser(LoginRequest loginRequest) {
        //request uzerinden username ve password aldim
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        //AuthenticationManager uzerinden kullaniciyi valide ettim
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));

        //valide edilen kullaniciyi contexte gonderdim
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //jwt token olusturdum
        String token = "Bearer " + jwtUtils.generateJwtToken(authentication);

        //response icindeki fieldleri doldurdum
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        Optional<String> role = roles.stream().findFirst();

        //response nesnesi olusturdum
        AuthResponse.AuthResponseBuilder authResponse = AuthResponse.builder();
        authResponse.email(userDetails.getUsername());
        authResponse.token(token.substring(7));
        authResponse.name(userDetails.getName());

        //role bilgisini setledim
        if (role.isPresent()){
            authResponse.role(role.get());
        }
        return ResponseEntity.ok(authResponse.build());
    }
}
