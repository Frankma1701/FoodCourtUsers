package org.pragma.foodcourtusers.infrastructure.input.rest;


import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.request.AuthenticationRequest;
import org.pragma.foodcourtusers.application.dto.request.OwnerRequest;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.JwtResponse;
import org.pragma.foodcourtusers.application.dto.utils.Roles;
import org.pragma.foodcourtusers.application.handler.IUserHandler;
import org.pragma.foodcourtusers.application.handler.AuthenticationHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRestController{

    private final IUserHandler iUserHandler;
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

