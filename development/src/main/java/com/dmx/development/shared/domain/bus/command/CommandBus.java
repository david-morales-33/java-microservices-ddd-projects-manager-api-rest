package com.dmx.development.shared.domain.bus.command;


public interface CommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionException;
}
