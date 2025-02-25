package com.microservice.development.shared.domain.bus.command;


public interface CommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionException;
}
