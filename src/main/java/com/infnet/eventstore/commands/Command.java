package com.infnet.eventstore.commands;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public abstract class Command {

    private final String id;
    private final String commandType;
    private final LocalDateTime timestamp;
    private final String data;

    protected Command(String commandType, String data) {
        this.id = UUID.randomUUID().toString();
        this.commandType = commandType;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }

    public abstract void execute();
}
