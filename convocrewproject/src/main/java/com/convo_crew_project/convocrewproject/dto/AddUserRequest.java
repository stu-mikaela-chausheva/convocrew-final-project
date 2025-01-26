package com.convo_crew_project.convocrewproject.dto;

import com.convo_crew_project.convocrewproject.enums.Role;

public class AddUserRequest {
    private Long userId;
    private Role role;

    public int getUserId() {
        return Math.toIntExact(userId);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
