package org.pragma.foodcourtusers.infrastructure.security;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.request.AuthenticationRequest;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.JwtResponse;
import org.pragma.foodcourtusers.application.mapper.request.UserRequestMapper;
import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.RoleEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.UserEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IRoleRepository;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService{

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
        System.out.println("Las getAutorities de User son : ");
        user.getAuthorities().forEach(System.out::println);
        String jwtToken = jwtService.generateToken(user);
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
        String jwtToken = jwtService.generateToken(user);
        System.out.println("Las getAutorities de User son : ");
        user.getAuthorities().forEach(grantedAuthority -> System.out.println(grantedAuthority.toString()));
        return JwtResponse.builder().token(jwtToken).build();
    }

}
