package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.dto.CreateChannelRequest;
import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.entities.UserChannelRole;
import com.convo_crew_project.convocrewproject.enums.Role;
import com.convo_crew_project.convocrewproject.repositories.ChannelRepository;
import com.convo_crew_project.convocrewproject.repositories.UserChannelRoleRepository;
import com.convo_crew_project.convocrewproject.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
   public final ChannelRepository channelRepository;
   public final UserChannelRoleRepository userChannelRoleRepository;
   public final UserRepository userRepository;

    public ChannelService(ChannelRepository channelRepository,
                          UserChannelRoleRepository userChannelRoleRepository,
                          UserRepository userRepository) {

        this.channelRepository = channelRepository;
        this.userChannelRoleRepository = userChannelRoleRepository;
        this.userRepository = userRepository;

    }

    public boolean createChannel(CreateChannelRequest request)
    {
        // 1. Validate and fetch the user based on user_id from the request
        User owner = userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + request.getUser_id()));

        // 2. Create and save the channel
        Channel channel = new Channel();
        channel.setName(request.getName());
        channel = channelRepository.save(channel);

        // 3. Assign the user as the OWNER of the new channel
        UserChannelRole userChannelRole = new UserChannelRole();
        userChannelRole.setUser(owner); // Use the fetched User entity
        userChannelRole.setChannel(channel);
        userChannelRole.setRole(Role.owner);

        userChannelRoleRepository.save(userChannelRole);

        return true;
    }

    public List<Channel> getAllChannels() {
        return channelRepository.findAllByIsPrivateFalse();
    }

    public Channel getChannelById(Long id) {
        return channelRepository.findById(id).orElse(null);
    }

}
