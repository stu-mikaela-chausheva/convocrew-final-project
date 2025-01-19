package com.convo_crew_project.convocrewproject.controllers;

import com.convo_crew_project.convocrewproject.entities.Channel;
import com.convo_crew_project.convocrewproject.entities.DirectMessage;
import com.convo_crew_project.convocrewproject.entities.Message;
import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.services.DirectMessageService;
import com.convo_crew_project.convocrewproject.services.MessageService;
import com.convo_crew_project.convocrewproject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class DirectMessageController {

    private DirectMessageService directMessageService;
    private UserService userService;

    public DirectMessageController(DirectMessageService directMessageService, UserService userService) {
        this.directMessageService = directMessageService;
        this.userService = userService;
    }

    @PostMapping("/directmessage/post")
    public ResponseEntity<?> sendMessage(@RequestBody DirectMessage directMessage) {

        if (directMessage.getContent() == null || directMessage.getContent().isEmpty()) {
            return HttpResponse.error()
                    .withMessage("Text message cannot be null or empty")
                    .build();
        }

        // Verify sender and receiver exist in the database
//        User sender = userService.getUserById(directMessage.getSender().getId()).orElse(null);
//        User receiver = userService.getUserById(directMessage.getReceiver().getId()).orElse(null);
//
//        if (sender == null || receiver == null) {
//            return HttpResponse.error()
//                    .withMessage("Sender or receiver not found")
//                    .build();
//        }

        // Set verified sender and receiver
//        directMessage.setSender(sender);
//        directMessage.setReceiver(receiver);

        // Persist the direct message
        if (this.directMessageService.create(directMessage)) {
            return HttpResponse.success()
                    .withMessage("Message sent successfully")
                    .build();
        }

        // Handle unexpected errors
        return HttpResponse.error()
                .withMessage("Message could not be sent")
                .build();


    }

    @GetMapping("/directmessage/{sender_id}&{receiver_id}")
    public ResponseEntity fetchMessageBySenderAndReceiver( @PathVariable("sender_id") Long senderId,
                                                           @PathVariable("receiver_id") Long receiverId)
    {
        // Check if there are users with these ids
        Optional<User> sender = userService.getUserById(senderId);
        Optional<User> receiver = userService.getUserById(receiverId);

        if (sender == null || receiver == null) {
            return HttpResponse.error()
                    .withMessage("Sender or receiver not found")
                    .build();
        }

        // Check is there is a convo between sender and receipiengt
        List<DirectMessage> conversation = directMessageService.getAllMessagesBySenderAndReceiver(sender.get(), receiver.get());


        if (conversation.isEmpty()) {
            return HttpResponse.success()
                    .withMessage("No messages found between the users")
                    .withData(conversation)
                    .build();
        }

        return HttpResponse.success()
                .withMessage("Messages fetched successfully")
                .withData(conversation)
                .build();


    }

}
