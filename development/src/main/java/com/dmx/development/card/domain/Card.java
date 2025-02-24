package com.dmx.development.card.domain;

import com.dmx.development.shared.domain.CardId;
import com.dmx.development.task.domain.Task;
import com.dmx.development.task.domain.TaskDTO;

import java.util.HashMap;

public final class Card {
    private final CardId id;
    private final CardName name;
    private final CardTaskCounter taskCounter;
    private final HashMap<String, Task> taskList;

    public Card(CardId id, CardName name, CardTaskCounter taskCounter, HashMap<String, Task> taskList) {
        this.id = id;
        this.name = name;
        this.taskCounter = taskCounter;
        this.taskList = taskList;
    }

    public static Card fromPrimitives(CardDTO data) {
        HashMap<String, Task> taskList = new HashMap<>();
        data.taskList().forEach((key, value) -> {
            taskList.put(key, Task.fromPrimitives(value));
        });
        return new Card(
                new CardId(data.id()),
                new CardName(data.name()),
                new CardTaskCounter(data.taskCounter()),
                taskList
        );
    }

    public CardDTO toPrimitives() {
        HashMap<String, TaskDTO> taskList = new HashMap<>();
        this.taskList.forEach((key, value) -> {
            taskList.put(key, value.toPrimitives());
        });
        return new CardDTO(
                this.id.value(),
                this.name.value(),
                this.taskCounter.value(),
                taskList
        );
    }

    public CardId getId() {
        return this.id;
    }

    public CardName getName() {
        return this.name;
    }

    public CardTaskCounter getTaskCounter() {
        return this.taskCounter;
    }

    public HashMap<String,Task> getTaskList() {
        return this.taskList;
    }
}
