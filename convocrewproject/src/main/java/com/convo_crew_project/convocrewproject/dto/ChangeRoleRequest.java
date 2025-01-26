package com.convo_crew_project.convocrewproject.dto;

import com.convo_crew_project.convocrewproject.enums.Role;

public class ChangeRoleRequest {
    private Long userId;
    private Role newRole;

    public int getUserId() {
        return Math.toIntExact(userId);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Role getNewRole() {
        return newRole;
    }

    public void setNewRole(Role newRole) {
        this.newRole = newRole;
    }
}
