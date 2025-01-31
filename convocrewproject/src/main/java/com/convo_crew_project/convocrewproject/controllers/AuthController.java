//package com.convo_crew_project.convocrewproject.controllers;
//
//import com.convo_crew_project.convocrewproject.dto.LoginRequest;
//import com.convo_crew_project.convocrewproject.entities.User;
//import com.convo_crew_project.convocrewproject.repositories.UserRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.Optional;
//
//@Controller
//public class AuthController {
//
//    private UserRepository userRepository;
//
//    public AuthController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//
//    }
//
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
//            return ResponseEntity.badRequest().body("Username already exists");
//        }
//        user.setPassword(user.getPassword()); // You should hash passwords before saving
//        user.setActive(true);
//        return ResponseEntity.ok(userRepository.save(user));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(LoginRequest request) {
//        Optional<Object> foundUser = userRepository.findByUsername(request.getUsername());
//
//        if (foundUser.isPresent() && user.getPassword().equals().get().getPassword()) {
//            return ResponseEntity.ok(foundUser.get());
//        } else {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//
//
//    }
//}
