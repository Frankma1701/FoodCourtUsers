package org.pragma.foodcourtusers.infrastructure.input.rest;


import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.request.AuthenticationRequest;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.JwtResponse;
import org.pragma.foodcourtusers.application.handler.IUserHandler;
import org.pragma.foodcourtusers.infrastructure.security.AuthenticationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRestController{

    private final IUserHandler iUserHandler;
    private final EncryptHandler encryptHandler;
    private  final AuthenticationService authenticationService;


    @PostMapping(path = "/register")
    public ResponseEntity<JwtResponse> save(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authenticationService.register(userRequest));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponse> signIn(@RequestBody AuthenticationRequest authenticationRequest) {

        return ResponseEntity.ok(authenticationService.signIn(authenticationRequest));

    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponse> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return null;
    }


    }

