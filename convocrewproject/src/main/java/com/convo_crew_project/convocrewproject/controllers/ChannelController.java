package com.convo_crew_project.convocrewproject.controllers;

import com.convo_crew_project.convocrewproject.entites.Channel;
import com.convo_crew_project.convocrewproject.entites.User;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.services.ChannelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Controller
public class ChannelController {

    private ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping("/channel")
    public ResponseEntity<?> createNewChannel(@RequestBody Channel channel) {
        HashMap<String, Object> response = new HashMap<>();

        if(this.channelService.createChannel(channel)) {
            // success if all data is provided correct
//            return HttpResponse.success()
//                    .withMessage("Channel created successfully")
//                    .build();

            response.put("message", "Channel created");
            return new ResponseEntity<Object>(response, HttpStatus.valueOf(200));
        }
        // error if smth went wrong
//        return HttpResponse.error()
//                .withMessage("Channel not created. Try again!")
//                .build();

        response.put("message", "Channel not created");
        return new ResponseEntity<Object>(response, HttpStatus.valueOf(400 ));
    }
}
