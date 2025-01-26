package com.convo_crew_project.convocrewproject.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    owner,
    member,
    admin;

    // The issues was with UserChannelRoleService.getAllUsersByChannel.
    // I did have error because in db enum roles are saved with lowercase.
    // added method to fix the error it was not successful
    // changes the enum vallues from UPPERCASE to LOWERCASE
    @JsonCreator
    public static Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + value);
    }

}
