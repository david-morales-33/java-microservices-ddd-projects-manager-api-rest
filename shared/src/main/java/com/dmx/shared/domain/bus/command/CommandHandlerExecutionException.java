package com.dmx.shared.domain.bus.command;

public final class CommandHandlerExecutionException extends RuntimeException {
    public CommandHandlerExecutionException(Throwable message) {
        super(message);
    }
}
