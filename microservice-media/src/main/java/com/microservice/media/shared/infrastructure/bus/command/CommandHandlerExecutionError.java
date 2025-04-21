package com.microservice.media.shared.infrastructure.bus.command;

public class CommandHandlerExecutionError extends RuntimeException {
    public CommandHandlerExecutionError(Throwable cause) {
        super(cause);
    }
}
