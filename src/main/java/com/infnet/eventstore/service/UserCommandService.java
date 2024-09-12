package com.infnet.eventstore.service;

import com.infnet.eventstore.commands.CreateUserCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandService {

    private final CommandGateway commandGateway;

    @Autowired
    public UserCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void createUser(String userId, String userName, String userEmail) {
        CreateUserCommand command = new CreateUserCommand(userId, userName, userEmail);
        commandGateway.send(command);
    }
}
