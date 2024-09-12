package com.infnet.eventstore.events;

import lombok.Getter;

@Getter
public class CreateUserEvent extends Event {

    private final String userId;
    private final String userName;
    private final String userEmail;

    public CreateUserEvent(String userId, String userName, String userEmail) {
        super("CreateUser", String.format("UserId: %s, UserName: %s, UserEmail: %s", userId, userName, userEmail));
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    @Override
    public String getEventDetails() {
        return String.format("User created with ID: %s", userId);
    }
}
