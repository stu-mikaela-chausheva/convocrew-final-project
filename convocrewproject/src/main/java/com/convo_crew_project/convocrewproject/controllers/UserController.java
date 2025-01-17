package com.convo_crew_project.convocrewproject.controllers;

import com.convo_crew_project.convocrewproject.entities.User;
import com.convo_crew_project.convocrewproject.http.HttpResponse;
import com.convo_crew_project.convocrewproject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // ResponseEntity - ResponseEntity is the class in the Spring Framework that represents the entire HTTP response,
    // including the status code, headers, and body.
    // It is a part of the org. springframework.
    // http package and is a powerful tool for controlling the output of the RESTful services.
    @PostMapping("/user")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        // A HashMap however, store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String).
        // A HashMap organizes data in the form of key and a value pair where each key is mapped to it's corresponding value
//        HashMap<String, Object> response = new HashMap<>();

        if(this.userService.createUser(user)) {
            // success if all data is provided correct
            return HttpResponse.success()
                    .withMessage("User created successfully")
                    .build();
        }
        // error if smth went wrong
        return HttpResponse.error()
                .withMessage("User not created")
                .build();

    }

    @GetMapping("/users")
    public ResponseEntity fetchAllUsers() {
        ArrayList<User> collection = (ArrayList<User>) this.userService.getAllUsers();

        return HttpResponse.success()
                .withData(collection)
                .build();
    }
}
