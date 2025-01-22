package com.convo_crew_project.convocrewproject.controllers;

import com.convo_crew_project.convocrewproject.entities.*;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.services.FriendService;
import com.convo_crew_project.convocrewproject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FriendController {
    private FriendService friendsService;
    private UserService userService;

    public FriendController(FriendService friendsService, UserService userService) {
        this.friendsService = friendsService;
        this.userService = userService;
    }

    @PostMapping("/addfriend")
    public ResponseEntity<?> addFriend(@RequestBody Friend friends) {

        // Retrieve users from the database
        User loggedUser = userService.getUserById((long) friends.getLoggedUser().getId()).orElseThrow(() -> new RuntimeException("Logged user not found"));;
        // does not get info about the friend debuggg
        User friend = userService.getUserById((long )friends.getFriendUser().getId()).orElseThrow(() -> new RuntimeException("Friend not found"));;

        // Validate input
        if (friends.getLoggedUser().getId() == 0 || friends.getFriendUser().getId() == 0) {
            return HttpResponse.error()
                    .withMessage("Both users must be specified")
                    .build();
        }

        // Ensure the two users are not the same
        if ((friends.getLoggedUser().getId()) == (friends.getFriendUser().getId())) {
            return HttpResponse.error()
                    .withMessage("A user cannot be friends with themselves")
                    .build();
        }


        if (loggedUser == null || friend == null) {
            return HttpResponse.error()
                    .withMessage("One or both users not found")
                    .build();
        }

        // Logic for adding a friend
        friends.setLoggedUser(loggedUser);
        friends.setFriendUser(friend);
        boolean result = friendsService.addFriend(friends);

        if (result) {
            return HttpResponse.success()
                    .withMessage("Friend added successfully")
                    .build();
        }

        return HttpResponse.error()
                .withMessage("Unable to add friend")
                .build();


    }


    @GetMapping("/friends/{user_id}")
    public ResponseEntity fetchFriendsByLoggedUser(@PathVariable("user_id") Long loggedUserId) {
        Optional<User> loggedUser = userService.getUserById(loggedUserId);

        if (loggedUser == null ) {
            return HttpResponse.error()
                    .withMessage("Logged User not found")
                    .build();
        }

        // Check is there is a convo between sender and receipiengt
        List<Friend> friends = friendsService.getAllFriendsByLoggedUser(loggedUser.get());


        if (friends.isEmpty()) {
            return HttpResponse.success()
                    .withMessage("You don't have friends yet")
                    .withData(friends)
                    .build();
        }

        return HttpResponse.success()
                .withMessage("There is your friendlist")
                .withData(friends)
                .build();

    }
}
