package com.microservice.development.card.domain;

import com.microservice.development.shared.domain.CardId;
import com.microservice.development.task.domain.Task;
import com.microservice.development.task.domain.TaskDTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Card {
    private final CardId id;
    private final CardName name;
    private CardTaskCounter taskCounter;
    private Set<Task> taskList;

    public Card(CardId id, CardName name, Set<Task> taskList) {
        this.id = id;
        this.name = name;
        this.taskCounter = new CardTaskCounter(taskList.size());
        this.taskList = taskList;
    }

    private Card() {
        this.id = null;
        this.name = null;
        this.taskCounter = null;
        this.taskList = new HashSet<>();
    }

    public static Card fromPrimitives(CardDTO data) {
        HashSet<Task> taskList = new HashSet<>();
        data.taskList().forEach((value) -> {
            taskList.add(Task.fromPrimitives(value));
        });
        return new Card(
                new CardId(data.id()),
                new CardName(data.name()),
                taskList
        );
    }

    public CardDTO toPrimitives() {
        HashSet<TaskDTO> taskList = new HashSet<>();
        this.taskList.forEach((value) -> {
            taskList.add(value.toPrimitives());
        });
        return new CardDTO(
                this.id.value(),
                this.name.value(),
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

    public Set<Task> getTaskList() {
        return this.taskList;
    }

    private void setTaskList(Set<Task> taskList) {
        this.taskList = taskList;
        this.taskCounter = new CardTaskCounter(taskList.size());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(name, card.name) && Objects.equals(taskCounter, card.taskCounter) && Objects.equals(taskList, card.taskList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, taskCounter, taskList);
    }
}
