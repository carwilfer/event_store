package com.infnet.eventstore.aggregates;

import com.infnet.eventstore.commands.CreateUserCommand;
import com.infnet.eventstore.events.CreateUserEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class UserAggregate {

    @TargetAggregateIdentifier
    private String userId;
    private String userName;
    private String userEmail;

    protected UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {
        AggregateLifecycle.apply(new CreateUserEvent(
                command.getUserId(),
                command.getUserName(),
                command.getUserEmail()
        ));
    }

    @EventSourcingHandler
    public void on(CreateUserEvent event) {
        this.userId = event.getUserId();
        this.userName = event.getUserName();
        this.userEmail = event.getUserEmail();
    }
}
