package com.dmx.administrative.card.domain;

import com.dmx.shared.domain.CardId;
import com.dmx.administrative.task.domain.Task;
import com.dmx.administrative.task.domain.TaskDTO;

public final class Card {
    private final CardId id;
    private final CardName name;
    private final CardTaskCounter taskCounter;
    private final Task[] taskList;

    public Card(CardId id, CardName name, CardTaskCounter taskCounter, Task[] taskList) {
        this.id = id;
        this.name = name;
        this.taskCounter = taskCounter;
        this.taskList = taskList;
    }

    public static Card fromPrimitives(CardDTO data) {
        Task[] taskList = new Task[data.taskCounter()];
        for (int taskCounter = 0; taskCounter < data.taskCounter(); taskCounter++) {
            TaskDTO currentTask = data.taskList()[taskCounter];
            taskList[taskCounter] = Task.fromPrimitives(currentTask);
        }
        return new Card(
                new CardId(data.id()),
                new CardName(data.name()),
                new CardTaskCounter(data.taskCounter()),
                taskList
        );
    }

    public CardDTO toPrimitives() {
        TaskDTO[] taskList = new TaskDTO[this.taskCounter.value()];
        for (int taskCounter = 0; taskCounter < this.taskCounter.value(); taskCounter++) {
            taskList[taskCounter] = this.taskList[taskCounter].toPrimitives();
        }
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

    public Task[] getTaskList() {
        return this.taskList;
    }
}
