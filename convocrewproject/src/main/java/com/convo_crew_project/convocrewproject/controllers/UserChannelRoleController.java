package com.convo_crew_project.convocrewproject.controllers;

import com.convo_crew_project.convocrewproject.dto.AddUserRequest;
import com.convo_crew_project.convocrewproject.dto.ChangeRoleRequest;
import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.entities.UserChannelRole;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.services.ChannelService;
import com.convo_crew_project.convocrewproject.services.UserChannelRoleService;
import com.convo_crew_project.convocrewproject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserChannelRoleController {
    public UserChannelRoleService userChannelRoleService;
    public ChannelService channelService;
    public UserService userService;

    public UserChannelRoleController(UserChannelRoleService userChannelRoleService, ChannelService channelService, UserService userService) {
        this.userChannelRoleService = userChannelRoleService;
        this.channelService = channelService;
        this.userService = userService;
    }

        // Add a user to a channel
        @PostMapping("/{channelId}/addUser")
        public ResponseEntity<?> addUserToChannel(@RequestBody AddUserRequest request,
                @PathVariable int channelId) {

            // Fetch the User from the UserService
            User user = userService.getUserById((long) request.getUserId())
                    .orElse(null); // You can handle empty result by returning null or throwing an exception

            // Check if the User exists
            if (user == null) {
                return HttpResponse.error()
                        .withMessage("User does not exist with ID: " + request.getUserId())
                        .build();
            }

            // Fetch the Channel from the ChannelService
            Channel channel = channelService.getChannelById((long) channelId);

            // Check if the Channel exists
            if (channel == null) {
                return HttpResponse.error()
                        .withMessage("Channel does not exist with ID: " + channelId)
                        .build();
            }

            UserChannelRole userChannelRole = userChannelRoleService.addUserToChannel(user, channel, request.getRole());
            return HttpResponse.success()
                    .withMessage("Role Added successfully")
                    .withData(userChannelRole)
                    .build();
        }

    // Change role of a user 1
    @PutMapping("/{channelId}/changerole")
    public ResponseEntity<?> changeUserRole(
            @PathVariable int channelId,
            @RequestBody ChangeRoleRequest request) {

        User user = new User();  // Fetch user from DB (replace with real logic)
        user.setId((int) request.getUserId());

        Channel channel = new Channel();  // Fetch channel from DB (replace with real logic)
        channel.setId(channelId);

        boolean success = userChannelRoleService.changeUserRole(user, channel, request.getNewRole());
        if (success) {
            return HttpResponse.success()
                    .withMessage("Role updated successfully")
                    .build();
        }

        return HttpResponse.error()
                .withMessage("Failed to update role")
                .build();
    }

    @GetMapping("/{channelId}/users")
    public ResponseEntity<?> getUserChannelUsers(@PathVariable Long channelId) {
        Channel channel = channelService.getChannelById(channelId);

        List<UserChannelRole> users = userChannelRoleService.getAllUsersByChannel(channel);

        if (!users.isEmpty()) {
            return HttpResponse.success()
                    .withData(users)
                    .build();
        }

        return HttpResponse.error()
                .withMessage("No users in this channel")
                .build();


    }
}
