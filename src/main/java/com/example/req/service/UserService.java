package com.example.req.service;

import com.example.req.domain.User;
import com.example.req.repository.UserRepository;
import com.example.req.service.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;
/*import org.springframework.security.core.userdetails.UserDetailsService;*/

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }*/
    public User addNewUser (UserDTO userDTO){
        User user = new User (userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
        userRepository.save(user);
        return user;
    }
}
