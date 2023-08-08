package org.pragma.foodcourtusers.infrastructure.input.rest;


import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.application.handler.EncryptHandler;
import org.pragma.foodcourtusers.application.handler.UserHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController{

    private final UserHandler userHandler;
    private final EncryptHandler encryptHandler;



    @PostMapping("/")
    public ResponseEntity<Void> saveUser(@RequestBody UserRequest userRequest){
        userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userHandler.getAllUsers());
    }

    @GetMapping("/{number}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(name="number") String documentId){
        return ResponseEntity.ok(userHandler.getUser(documentId));
    }

    @GetMapping("/saludar")
    public String getSaludo(){
        String message = "Hola mundo desde saludar";
        return message;
    }

        @PutMapping("/")
        public ResponseEntity<Void> updateUser (@RequestBody UserRequest userRequest){
            userHandler.updateUser(userRequest);
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("/{documentId}")
        public ResponseEntity<Void> deleteUser (String documentId){
            userHandler.deleteUser(documentId);
            return ResponseEntity.noContent().build();
        }

        @PostMapping("/create-owner")
        public ResponseEntity<Void> saveOwner (@RequestBody UserRequest userRequest){
            userRequest.setRoleId(2L);
            String hashPassword = encryptHandler.encryptPassword(userRequest.getPassword());
            userRequest.setPassword(hashPassword);
            userHandler.saveUser(userRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }


    }

