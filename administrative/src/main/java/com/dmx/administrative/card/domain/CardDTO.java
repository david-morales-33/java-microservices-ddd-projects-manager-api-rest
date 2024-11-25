package com.dmx.administrative.card.domain;

import com.dmx.administrative.task.domain.TaskDTO;

public record CardDTO(String id, String name, int taskCounter, TaskDTO[] taskList) {
}
