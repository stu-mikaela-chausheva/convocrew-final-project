package com.convo_crew_project.convocrewproject.controllers;

import com.convo_crew_project.convocrewproject.dto.CreateChannelRequest;
import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.services.ChannelService;
import com.convo_crew_project.convocrewproject.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ChannelController {

    private ChannelService channelService;
    private UserService userService;

    public ChannelController(ChannelService channelService, UserService userService) {
        this.channelService = channelService;
        this.userService = userService;
    }

    @PostMapping("/channel")
    public ResponseEntity<?> createNewChannel(@RequestBody CreateChannelRequest request
    ) {

        if(channelService.createChannel(request)) {
            // success if all data is provided correct
            return HttpResponse.success()
                    .withMessage("Channel created successfully")
                    .build();
        }
        // error if smth went wrong
        return HttpResponse.error()
                .withMessage("Channel not created. Try again!")
                .build();

    }

    @GetMapping("/channels")
    public ResponseEntity fetchAllChannels() {
        ArrayList<Channel> collection = (ArrayList<Channel>) this.channelService.getAllChannels();

        return HttpResponse.success()
                .withData(collection)
                .build();
    }
}
