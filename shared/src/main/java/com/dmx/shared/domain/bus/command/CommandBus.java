package com.dmx.shared.domain.bus.command;

public interface CommandBus {
    void dispatch(Command command);
}
