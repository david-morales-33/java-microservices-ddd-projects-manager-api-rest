package com.dmx.administrative.project.application.addTeam;

import com.dmx.administrative.project.domain.*;
import com.dmx.administrative.team.domain.Team;
import com.dmx.shared.domain.ProjectId;

import java.util.Optional;

public final class TeamCreator {
    private final ProjectCommandRepository commandRepository;
    private final ProjectQueryRepository queryRepository;

    public TeamCreator(ProjectCommandRepository commandRepository, ProjectQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public void execute(ProjectId projectId, Team team) {
        Optional<ProjectFuncionalitiesContainer> response = this.queryRepository.findProjectFuncionalitiesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("El proyecto solicitado no fue encontrado");

        ProjectFuncionalitiesContainer project = response.get();
        project.addTeam(team);
        this.commandRepository.saveProjectFuncionalitiesContainer(project);
    }
}
