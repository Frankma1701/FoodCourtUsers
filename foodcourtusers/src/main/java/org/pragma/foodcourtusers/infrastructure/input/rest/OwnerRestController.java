package org.pragma.foodcourtusers.infrastructure.input.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerRestController{



    @GetMapping("/")
    public String showOwner(){

        return "Hola mundo desde el Owner";
    }


    }

