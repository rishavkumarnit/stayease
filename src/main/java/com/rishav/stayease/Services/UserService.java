package com.rishav.stayease.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.rishav.stayease.Exceptions.*;
import com.rishav.stayease.Controllers.*;
import com.rishav.stayease.Entities.*;
import com.rishav.stayease.Repositories.*;
import java.util.*;



@Service
public class UserService {

    @Autowired
    JWTService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    UserRepository userRepository;


    @Autowired
    AuthenticationManager authenticationManager;


    public User register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistsException("User already exists");
        }
        if (request.getRole() == null) {
            request.setRole(Role.CUSTOMER);
        }
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        return userRepository.save(user);

    }

    
    public String login(AuthRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()));
        return jwtService.generateToken(existingUser.get().getUsername());
    }

}
