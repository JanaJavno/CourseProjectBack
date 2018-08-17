package com.example.req.service;

import com.example.req.domain.User;
import com.example.req.repository.UserRepository;
import com.example.req.service.DTO.JsonException;
import com.example.req.service.DTO.LoginResponseDTO;
import com.example.req.service.DTO.LoginUserDTO;
import com.example.req.service.DTO.RegistrationUserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginResponseDTO addNewUser (RegistrationUserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user != null){
            throw new JsonException("User with this name has already exist");
        }
        else user = new User (userDTO.getUsername(), bCryptPasswordEncoder.encode(userDTO.getPassword()), userDTO.getEmail());
        userRepository.save(user);
        return new LoginResponseDTO(generateToken(user.getUsername()));
    }

    public LoginResponseDTO loginUser (LoginUserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new JsonException("User not found.");
        }

        if (!bCryptPasswordEncoder.matches(password , user.getPassword())) {
            throw new JsonException("Invalid login. Please check your name and password.");
        }
        return new LoginResponseDTO(generateToken(username));// add .claim("role", user.getRole())
    }

    private String generateToken (String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("username", username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
                .compact();
    }
}
