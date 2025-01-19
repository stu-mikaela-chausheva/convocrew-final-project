package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.ResourceTransactionManager;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }
}
