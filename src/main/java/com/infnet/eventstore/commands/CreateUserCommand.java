package com.infnet.eventstore.commands;

import lombok.Getter;

@Getter
public class CreateUserCommand extends Command {

    private final String userId;
    private final String userName;
    private final String userEmail;

    public CreateUserCommand(String userId, String userName, String userEmail) {
        super("CreateUser", String.format("UserId: %s, UserName: %s, UserEmail: %s", userId, userName, userEmail));
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    @Override
    public void execute() {
        // Lógica para executar o comando de criação do usuário
    }
}
