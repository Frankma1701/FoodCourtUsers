package org.pragma.foodcourtusers.infrastructure.security;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.request.AuthenticationRequest;
import org.pragma.foodcourtusers.application.dto.request.OwnerRequest;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.JwtResponse;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.UserEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IRoleRepository;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationHandler{

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final IRoleRepository iRoleRepository;
    private final IUserRepository iUserRepository;
    private final AuthenticationManager authenticationManager;

    public JwtResponse register(UserRequest userRequest) {
        var user = UserEntity.builder()
                .name(userRequest.getName())
                .lastName(userRequest.getLastName())
                .documentId(userRequest.getDocumentId())
                .cellPhoneNumber(userRequest.getCellPhoneNumber())
                .birthDate(userRequest.getBirthDate())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roleEntity(iRoleRepository.getReferenceById(userRequest.getRoleId()))
                .build();
        iUserRepository.save(user);
        String jwtToken = jwtService.generateToken(user , user.getId());
        return JwtResponse.builder()
                .token(jwtToken)
                .build();
    }

    public JwtResponse registerUser(OwnerRequest ownerRequest , Long roleId) {
        var user = UserEntity.builder()
                .name(ownerRequest.getName())
                .lastName(ownerRequest.getLastName())
                .documentId(ownerRequest.getDocumentId())
                .cellPhoneNumber(ownerRequest.getCellPhoneNumber())
                .birthDate(ownerRequest.getBirthDate())
                .email(ownerRequest.getEmail())
                .password(passwordEncoder.encode(ownerRequest.getPassword()))
                .roleEntity(iRoleRepository.getReferenceById(roleId))
                .build();
        iUserRepository.save(user);
        String jwtToken = jwtService.generateToken(user, user.getId());
        return JwtResponse.builder()
                .token(jwtToken)
                .build();
    }

    public JwtResponse signIn (AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = iUserRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user, user.getId());
        return JwtResponse.builder().token(jwtToken).build();
    }

}
