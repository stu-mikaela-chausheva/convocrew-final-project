package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.UserChannelRole;
import com.convo_crew_project.convocrewproject.enums.Role;
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
//        Channel savedChannel = channelRepository.save(channel); // Persist the channel in the database
        channelRepository.save(channel);
        // Assign creator as OWNER
//        UserChannelRole ownerRole = new UserChannelRole();
//        ownerRole.setUser(creator);
//        ownerRole.setChannel(savedChannel);
//        ownerRole.setRole(Role.OWNER);
//
//        userChannelRoleRepository.save(ownerRole);

        return true;
    }

    public List<Channel> getAllChannels() {
        return channelRepository.findAllByIsPrivateFalse();
    }

    public Channel getChannelById(Long id) {
        return channelRepository.findById(id).orElse(null);
    }

}
