package com.convo_crew_project.convocrewproject.repositories;

import com.convo_crew_project.convocrewproject.entities.DirectMessage;
import com.convo_crew_project.convocrewproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectMessageRepository extends JpaRepository<DirectMessage, Long> {
    List<DirectMessage> findAllBySenderAndReceiver(User sender, User receiver);
}
