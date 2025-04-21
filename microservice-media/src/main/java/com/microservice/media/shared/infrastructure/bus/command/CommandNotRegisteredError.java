package com.microservice.media.shared.infrastructure.bus.command;

import com.microservice.media.shared.domain.bus.command.Command;

public class CommandNotRegisteredError extends RuntimeException {
    public CommandNotRegisteredError(Class<? extends Command> command) {
        super(String.format("The command <%s> hasn't a command handler associated", command.toString()));
    }
}
