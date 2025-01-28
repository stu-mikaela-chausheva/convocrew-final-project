package com.convo_crew_project.convocrewproject.services;

import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.entities.UserChannelRole;
import com.convo_crew_project.convocrewproject.enums.Role;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.repositories.ChannelRepository;
import com.convo_crew_project.convocrewproject.repositories.UserChannelRoleRepository;
import com.convo_crew_project.convocrewproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class UserChannelRoleService {

    private final UserChannelRoleRepository userChannelRoleRepository;
    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;

    public UserChannelRoleService(UserChannelRoleRepository userChannelRoleRepository,
                                  UserRepository userRepository,
                                  ChannelRepository channelRepository,
                                  UserService userService,
                                  ChannelService channelService) {
        this.userChannelRoleRepository = userChannelRoleRepository;
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;

    }



    // Add a user to a channel with a specific role
    // modify for check if record with user_id and channel-id exists
    public UserChannelRole addUserToChannel(User user, Channel channel, Role role) {

//        Optional<UserChannelRole> userChannelRoleOpt = userChannelRoleRepository.findByUserAndChannel(user, channel);


        UserChannelRole userChannelRole = new UserChannelRole();
        userChannelRole.setUser(user);
        userChannelRole.setChannel(channel);
        userChannelRole.setRole(role);
        return userChannelRoleRepository.save(userChannelRole);
    }

    // works
//    public UserChannelRole addUserToChannel(User user, Channel channel, Role role) {
//        // Check if there is no record with the same user_id and channel_id
//        // otherwise occurs error when updating record
//
//        UserChannelRole userChannelRole = new UserChannelRole();
//        userChannelRole.setUser(user);
//        userChannelRole.setChannel(channel);
//        userChannelRole.setRole(role);
//        return userChannelRoleRepository.save(userChannelRole);
//    }




    // Change the role of a user in a channel
    public boolean changeUserRole(User user, Channel channel, Role newRole) {

        if (newRole == null) {
            throw new IllegalArgumentException("Role cannot be null.");
        }

        Optional<UserChannelRole> userChannelRoleOpt = userChannelRoleRepository.findByUserAndChannel(user, channel);

        if (userChannelRoleOpt.isPresent()) {
            UserChannelRole userChannelRole = userChannelRoleOpt.get();
            userChannelRole.setRole(newRole);
            userChannelRoleRepository.save(userChannelRole);
            return true;
        }

        return false;
    }

    // Get all members of a channel
    public List<UserChannelRole> getAllUsersByChannel(Channel channel) {
        return userChannelRoleRepository.findByChannel(channel);
    }
//

}

