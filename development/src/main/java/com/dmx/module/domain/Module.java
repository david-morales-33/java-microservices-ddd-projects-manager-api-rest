package com.dmx.module.domain;

import com.dmx.shared.domain.ModuleId;

public class Module {
    private final ModuleId id;
    private final ModuleName name;
    private final ModuleTaskCounter taskCounter;
    private final ModuleTaskState taskState;

    public Module(ModuleId id, ModuleName name, ModuleTaskCounter taskCounter, ModuleTaskState taskState) {
        this.id = id;
        this.name = name;
        this.taskCounter = taskCounter;
        this.taskState = taskState;
    }

    static Module create(
            ModuleId id,
            ModuleName name,
            ModuleTaskCounter taskCounter,
            ModuleTaskState taskState
    ) {
        return new Module(id, name, taskCounter, taskState);
    }

    static Module fromPrimitives(ModuleDTO data){
        return new Module(
                new ModuleId(data.id()),
                new ModuleName(data.name()),
                new ModuleTaskCounter(data.taskCounter()),
                new ModuleTaskState(data.taskState())
        );
    }

    public ModuleId getId() {
        return this.id;
    }

    public ModuleName getName() {
        return this.name;
    }

    public ModuleTaskCounter getTaskCounter() {
        return this.taskCounter;
    }

    public ModuleTaskState getTaskState() {
        return this.taskState;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", name=" + name +
                ", taskCounter=" + taskCounter +
                ", taskState=" + taskState +
                '}';
    }
}
