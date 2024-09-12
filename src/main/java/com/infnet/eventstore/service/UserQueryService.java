package com.infnet.eventstore.service;

import com.infnet.eventstore.aggregates.UserAggregate;
import com.infnet.eventstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryService {

    private final UserRepository userRepository;

    @Autowired
    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserAggregate> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserAggregate> getUserById(String userId) {
        return userRepository.findById(userId);
    }
}
