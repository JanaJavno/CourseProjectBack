package com.example.req.controllers;

import com.example.req.service.DTO.LoginResponseDTO;
import com.example.req.service.DTO.LoginUserDTO;
import com.example.req.service.DTO.RegistrationUserDTO;
import com.example.req.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    /*@GetMapping("/getManuals")
    public List<Manual> greeting() {
        return manualRepository.findAll();
    }*/

    @PostMapping(value="/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponseDTO registration(@RequestBody RegistrationUserDTO userdto) {
        return userService
                .addNewUser(userdto);
    }

    @PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponseDTO login(@RequestBody LoginUserDTO userdto) {
        return userService.loginUser(userdto);
    }

}