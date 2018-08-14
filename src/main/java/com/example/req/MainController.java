package com.example.req;

import com.example.req.domain.User;
import com.example.req.service.DTO.UserDTO;
import com.example.req.service.UserService;
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

    @PostMapping(value = "/api/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> registration(@RequestBody UserDTO usrDto) {
        return new ResponseEntity<UserDTO>(userService.addNewUser(usrDto), HttpStatus.OK);
    }

}