package com.example.req;

import com.example.req.domain.User;
import com.example.req.service.DTO.UserDTO;
import com.example.req.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private UserService userService;

    @GetMapping("/api/greeting")
    public String greeting() {
        return "[{}]";
    }

    @PostMapping("/api/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registration(@RequestBody UserDTO userdto) {
        return userService.addNewUser(userdto);
    }

}