package com.microservice.development.card.domain;

import com.microservice.development.task.domain.TaskDTO;
import java.util.HashMap;

public record CardDTO(String id, String name, int taskCounter, HashMap<String, TaskDTO> taskList) {
}
