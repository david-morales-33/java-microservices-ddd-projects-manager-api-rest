package com.dmx.administrative.project.application.addCard;

import com.dmx.administrative.card.domain.Card;
import com.dmx.administrative.project.domain.*;
import com.dmx.administrative.shared.domain.ProjectId;

import java.util.Optional;

public final class CardCreator {
    private final ProjectRootRepository repository;

    public CardCreator(ProjectRootRepository repository) {
        this.repository = repository;
    }
    public void execute(ProjectId projectId, Card card) {
        Optional<ProjectRoot> response = this.repository.find(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("El proyecto no fue encontrado");

        ProjectRoot project = response.get();
        project.addCard(card);
        this.repository.save(project);
    }
}
