package com.example.req.service;

import com.example.req.domain.User;
import com.example.req.repository.UserRepository;
import com.example.req.service.DTO.JsonException;
import com.example.req.service.DTO.LoginUserDTO;
import com.example.req.service.DTO.RegistrationUserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Objects;

/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
/*import org.springframework.security.core.userdetails.UserDetailsService;*/

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }*/
    public User addNewUser (RegistrationUserDTO userDTO){
        User user = new User (userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
        userRepository.save(user);
        return user;
    }

    public String loginUser (LoginUserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new JsonException("User not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new JsonException("Invalid login. Please check your name and password.");
        }

        return Jwts.builder()
                .setSubject(username)
                .claim("username", username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
                .compact();// add .claim("role", user.getRole())
    }
}
