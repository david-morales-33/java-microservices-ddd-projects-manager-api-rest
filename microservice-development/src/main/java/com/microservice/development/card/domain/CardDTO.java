package com.microservice.development.card.domain;

import com.microservice.development.task.domain.TaskDTO;
import java.util.HashMap;
import java.util.Set;

public record CardDTO(String id, String name, Set<TaskDTO> taskList) {
}
