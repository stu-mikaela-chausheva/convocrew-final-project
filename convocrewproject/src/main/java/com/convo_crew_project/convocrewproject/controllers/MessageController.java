package com.convo_crew_project.convocrewproject.controllers;

import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.Message;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.services.ChannelService;
import com.convo_crew_project.convocrewproject.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {

    private MessageService messageService;
    private ChannelService channelService;

    public MessageController(MessageService messageService, ChannelService channelService) {
        this.messageService = messageService;
        this.channelService = channelService;
    }


    @PostMapping("/message/post")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {

        if (message.getTextMessage() == null || message.getTextMessage().isEmpty()) {
            return HttpResponse.error()
                    .withMessage("Text message cannot be null or empty")
                    .build();
        }

        if(this.messageService.addMessage(message)) {

            return HttpResponse.success()
                    .withMessage("Sent")
                    .build();
        }
        // error if smth went wrong
        return HttpResponse.error()
                .withMessage("Not sent")
                .build();

    }

    @GetMapping("/message/{channelid}")
    public ResponseEntity fetchMessageByChannelID(@PathVariable("channelid") Long channelId) {
        Channel channel = channelService.getChannelById(channelId);

        if (channel == null) {
            return HttpResponse.error()
                    .withMessage("Channel not found")
                    .build();
        }

        List<Message> messages = this.messageService.getAllMessagesByChannel(channel);

        if (!messages.isEmpty()) {
            return HttpResponse.success()
                    .withData(messages)
                    .build();
        }
        // Return a response indicating no messages were found
        return HttpResponse.error()
                .withMessage("No messages found for the specified channel")
                .build();
    }


}
