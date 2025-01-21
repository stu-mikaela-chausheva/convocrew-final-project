package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.Message;
import com.convo_crew_project.convocrewproject.repositories.ChannelRepository;
import com.convo_crew_project.convocrewproject.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    public final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public boolean create(Message message) {
        messageRepository.save(message);
        return true;
    }

    public List<Message> getAllMessagesByChannel(Channel channel) {
        return messageRepository.findMessagesByChannel(channel);
    }
}
