package com.example.req;

import com.example.req.domain.User;
import com.example.req.service.DTO.UserDTO;
import com.example.req.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/greeting")
    public String greeting() {
        return "[{}]";
    }

    @PostMapping(value="/api/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User registration(@RequestBody UserDTO userdto) {
        return userService.addNewUser(userdto);
    }

}