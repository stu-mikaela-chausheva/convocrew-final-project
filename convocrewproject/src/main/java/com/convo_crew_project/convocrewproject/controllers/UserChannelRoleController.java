package com.convo_crew_project.convocrewproject.controllers;

import com.convo_crew_project.convocrewproject.dto.AddUserRequest;
import com.convo_crew_project.convocrewproject.dto.ChangeRoleRequest;
import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.entities.UserChannelRole;
import com.convo_crew_project.convocrewproject.enums.Role;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.services.ChannelService;
import com.convo_crew_project.convocrewproject.services.UserChannelRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserChannelRoleController {
    public UserChannelRoleService userChannelRoleService;
    public ChannelService channelService;

    public UserChannelRoleController(UserChannelRoleService userChannelRoleService, ChannelService channelService) {
        this.userChannelRoleService = userChannelRoleService;
        this.channelService = channelService;
    }

    // Add a user to a channel
    @PostMapping("/{channelId}/addUser")
    public ResponseEntity<?> addUserToChannel(@RequestBody AddUserRequest request,
            @PathVariable int channelId) {

        User user = new User();  // Fetch user from DB (replace with real logic)
        user.setId((int) request.getUserId());

        Channel channel = new Channel();  // Fetch channel from DB (replace with real logic)
        channel.setId(channelId);


        UserChannelRole userChannelRole = userChannelRoleService.addUserToChannel(user, channel, request.getRole());
//        return ResponseEntity.ok(userChannelRole);
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
//            return ResponseEntity.ok("Role updated successfully");
            return HttpResponse.success()
                    .withMessage("Role updated successfully")
                    .build();
        }

//        return ResponseEntity.badRequest().body("Failed to update role");
        return HttpResponse.error()
                .withMessage("Failed to update role")
                .build();
    }

// change role of user
//@PutMapping("/{channelId}/changeRole")
//public ResponseEntity<?> changeUserRole(
//        @PathVariable int channelId,
//        @RequestBody ChangeRoleRequest request) {
//
//    try {
//        // Convert string to enum (will throw an IllegalArgumentException if invalid)
//        Role newRole = Role.fromValue(request.getNewRole());
//
//        User user = new User();  // Fetch user from DB (replace with real logic)
//        user.setId((int) request.getUserId());
//
//        Channel channel = new Channel();  // Fetch channel from DB (replace with real logic)
//        channel.setId(channelId);
//
//        // Call service to change the role
//        boolean success = userChannelRoleService.changeUserRole(user, channel, newRole);
//
//        if (success) {
//            return HttpResponse.success()
//                    .withMessage("Role updated successfully")
//                    .build();
//        }
//
//        return HttpResponse.error()
//                .withMessage("Failed to update role")
//                .build();
//
//    } catch (IllegalArgumentException e) {
//        // Handle invalid role value
//        return HttpResponse.error()
//                .withMessage("Invalid role: " + request.getNewRole())
//                .build();
//    }
//}


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
