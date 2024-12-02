package com.dmx.development.card.domain;

import com.dmx.development.task.domain.TaskDTO;
import java.util.HashMap;

public record CardDTO(String id, String name, int taskCounter, HashMap<String, TaskDTO> taskList) {
}
