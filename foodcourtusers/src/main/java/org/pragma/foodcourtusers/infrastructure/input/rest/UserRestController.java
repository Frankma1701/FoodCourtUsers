package org.pragma.foodcourtusers.infrastructure.input.rest;


import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.application.handler.UserHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController{

    private final UserHandler userHandler;

    @GetMapping("/{documentId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(name="documentId") String documentId){
        return ResponseEntity.ok(userHandler.getUser(documentId));
    }
}
