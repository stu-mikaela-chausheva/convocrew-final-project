package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entites.Channel;
import com.convo_crew_project.convocrewproject.entites.User;
import com.convo_crew_project.convocrewproject.repositories.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public boolean createUser(User user) {
//        return this.userRepository.create(user);
        userRepository.save(user); // Persist the channel in the database
        return true;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
