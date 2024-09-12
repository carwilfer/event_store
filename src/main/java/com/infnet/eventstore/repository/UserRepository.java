package com.infnet.eventstore.repository;

import com.infnet.eventstore.aggregates.UserAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAggregate, String> {
}
