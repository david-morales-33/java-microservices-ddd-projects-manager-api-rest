package com.dmx.development.task.domain;

import com.dmx.shared.domain.TaskId;
import com.dmx.shared.domain.UserId;

public final class Task {
    private final TaskId id;
    private final TaskName name;
    private final TaskDescription description;
    private final TaskCreationDate creationDate;
    private final TaskState state;
    private final UserId createBy;

    public Task(
            TaskId id,
            TaskName name,
            TaskDescription description,
            TaskCreationDate creationDate,
            TaskState state,
            UserId createBy
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.state = state;
        this.createBy = createBy;
    }

    public static Task fromPrimitives(TaskDTO data) {
        return new Task(
                new TaskId(data.id()),
                new TaskName(data.name()),
                new TaskDescription(data.description()),
                new TaskCreationDate(data.creationDate()),
                new TaskState(data.state()),
                new UserId(data.createBy())
        );
    }

    public TaskDTO toPrimitives() {
        return new TaskDTO(
                this.id.value(),
                this.name.value(),
                this.description.value(),
                this.creationDate.value(),
                this.state.value(),
                this.createBy.value()
        );
    }

    public TaskId getId() {
        return this.id;
    }

    public TaskName getName() {
        return this.name;
    }

    public TaskDescription getDescription() {
        return this.description;
    }

    public TaskCreationDate getCreationDate() {
        return this.creationDate;
    }

    public TaskState getState() {
        return this.state;
    }

    public UserId getCreateBy() {
        return this.createBy;
    }
}
