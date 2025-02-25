package com.microservice.administrative.project.application.addCard;

import java.util.Optional;

import com.microservice.administrative.card.domain.Card;
import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.project.domain.ProjectRoot;
import com.microservice.administrative.project.domain.ProjectRootRepository;
import com.microservice.administrative.shared.domain.ProjectId;

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
