package com.example.req;

import com.example.req.domain.Manual;
import com.example.req.domain.Role;
import com.example.req.domain.User;
import com.example.req.repository.ManualRepository;
import com.example.req.service.DTO.LoginResponseDTO;
import com.example.req.service.DTO.LoginUserDTO;
import com.example.req.service.DTO.RegistrationUserDTO;
import com.example.req.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserService userService;
    private final ManualRepository manualRepository;

    public MainController(UserService userService, ManualRepository manualRepository) {
        this.userService = userService;
        this.manualRepository = manualRepository;
    }

    @GetMapping("/getManuals")
    public List<Manual> greeting() {
        return manualRepository.findAll();
    }

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