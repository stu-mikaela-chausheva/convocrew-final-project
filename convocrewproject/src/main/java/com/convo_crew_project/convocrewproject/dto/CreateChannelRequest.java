package com.convo_crew_project.convocrewproject.dto;

import com.convo_crew_project.convocrewproject.enums.Role;

public class CreateChannelRequest {
    private String name;
    private Long user_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
