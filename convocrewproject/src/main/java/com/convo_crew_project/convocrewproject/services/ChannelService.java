package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entites.Channel;
import com.convo_crew_project.convocrewproject.repositories.ChannelRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

}
