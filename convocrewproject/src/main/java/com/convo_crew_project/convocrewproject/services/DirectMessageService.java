package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entities.DirectMessage;
import com.convo_crew_project.convocrewproject.entities.Message;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.repositories.DirectMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectMessageService {
    public final DirectMessageRepository directMessageRepository;

    public DirectMessageService(DirectMessageRepository directMessageRepository) {
        this.directMessageRepository = directMessageRepository;
    }

    public boolean create(DirectMessage directMessage) {
        directMessageRepository.save(directMessage);
        return true;
    }

    public List<DirectMessage> getAllMessagesBySenderAndReceiver(User sender, User receiver) {
        return directMessageRepository.findAllBySenderAndReceiver(sender,receiver);
    }


}
