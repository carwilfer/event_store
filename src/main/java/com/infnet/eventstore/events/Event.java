package com.infnet.eventstore.events;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public abstract class Event {

    private final String id;
    private final String eventType;
    private final LocalDateTime timestamp;
    private final String data;

    protected Event(String eventType, String data) {
        this.id = UUID.randomUUID().toString();
        this.eventType = eventType;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }

    public abstract String getEventDetails();
}