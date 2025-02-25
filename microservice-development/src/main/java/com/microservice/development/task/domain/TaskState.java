package com.microservice.development.task.domain;

import com.microservice.development.shared.domain.BooleanValueObject;

public final class TaskState extends BooleanValueObject {
    public TaskState(boolean value) {
        super(value);
    }
}
