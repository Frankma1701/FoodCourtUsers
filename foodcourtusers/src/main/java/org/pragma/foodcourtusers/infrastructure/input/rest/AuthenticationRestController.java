package org.pragma.foodcourtusers.infrastructure.input.rest;


import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.request.AuthenticationRequest;
import org.pragma.foodcourtusers.application.dto.request.OwnerRequest;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.JwtResponse;
import org.pragma.foodcourtusers.infrastructure.security.AuthenticationHandler;
import org.pragma.foodcourtusers.infrastructure.util.Roles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRestController{

    private  final AuthenticationHandler authenticationService;


    @PostMapping(path = "/register-general")
    public ResponseEntity<JwtResponse> save(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authenticationService.register(userRequest));
    }

    @PostMapping(path = "/register-owner")
    public ResponseEntity<JwtResponse> saveOwner(@RequestBody OwnerRequest ownerRequest) {
        return ResponseEntity.ok(authenticationService.registerUser(ownerRequest , Roles.OWNER.getId()));
    }

    @PostMapping(path = "/register-customer")
    public ResponseEntity<JwtResponse> saveCustomer(@RequestBody OwnerRequest ownerRequest) {
        return ResponseEntity.ok(authenticationService.registerUser(ownerRequest, Roles.CUSTOMER.getId()));
    }

    @PostMapping(path = "/register-employee")
    public ResponseEntity<JwtResponse> saveEmployee(@RequestBody OwnerRequest ownerRequest) {
        return ResponseEntity.ok(authenticationService.registerUser(ownerRequest, Roles.EMPLOYEE.getId()));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponse> signIn(@RequestBody AuthenticationRequest authenticationRequest) {

        return ResponseEntity.ok(authenticationService.signIn(authenticationRequest));
    }

    }

