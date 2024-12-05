package com.dmx.administrative.project.application.addCard;

import com.dmx.administrative.card.domain.Card;
import com.dmx.administrative.project.domain.ProjectCommandRepository;
import com.dmx.administrative.project.domain.ProjectFuncionalitiesContainer;
import com.dmx.administrative.project.domain.ProjectNotFound;
import com.dmx.administrative.project.domain.ProjectQueryRepository;
import com.dmx.shared.domain.ProjectId;

import java.util.Optional;

public final class CardCreator {
    private final ProjectCommandRepository commandRepository;
    private final ProjectQueryRepository queryRepository;

    public CardCreator(ProjectCommandRepository commandRepository, ProjectQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public void execute(ProjectId projectId, Card card) {
        Optional<ProjectFuncionalitiesContainer> response = this.queryRepository.findProjectFuncionalitiesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("El proyecto no fue encontrado");

        ProjectFuncionalitiesContainer project = response.get();
        project.addCard(card);
        this.commandRepository.saveProjectFuncionalitiesContainer(project);
    }
}
