package com.dmx.card.domain;

import com.dmx.task.domain.TaskDTO;

public record CardDTO(String id, String name, int taskCounter, TaskDTO[] taskList) {
}
