package com.convo_crew_project.convocrewproject.repositories;

import com.convo_crew_project.convocrewproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();


    Optional<Object> findByUsername(String username);
    
}
