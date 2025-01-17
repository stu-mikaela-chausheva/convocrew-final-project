package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.repositories.ChannelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
   public final ChannelRepository channelRepository;

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public boolean createChannel(Channel channel) {
        channelRepository.save(channel); // Persist the channel in the database
        return true;
    }

    public List<Channel> getAllChannels() {
        return channelRepository.findAllByIsPrivateFalse();
    }

    public Channel getChannelById(Long id) {
        return channelRepository.findById(id).orElse(null);
    }

}
