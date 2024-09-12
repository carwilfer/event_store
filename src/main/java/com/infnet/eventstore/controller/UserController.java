package com.infnet.eventstore.controller;

import com.infnet.eventstore.aggregates.UserAggregate;
import com.infnet.eventstore.commands.CreateUserCommand;
import com.infnet.eventstore.service.UserCommandService;
import com.infnet.eventstore.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @Autowired
    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody CreateUserCommand createUserCommand) {
        userCommandService.createUser(
                createUserCommand.getUserId(),
                createUserCommand.getUserName(),
                createUserCommand.getUserEmail()
        );
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping("/")
    public ResponseEntity<List<UserAggregate>> getAllUsers() {
        return ResponseEntity.ok(userQueryService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserAggregate> getUserById(@PathVariable String userId) {
        Optional<UserAggregate> user = userQueryService.getUserById(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
