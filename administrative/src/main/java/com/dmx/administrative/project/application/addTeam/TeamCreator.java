package com.dmx.administrative.project.application.addTeam;

import com.dmx.administrative.project.domain.*;
import com.dmx.administrative.team.domain.Team;
import com.dmx.shared.domain.ProjectId;

import java.util.Optional;

public final class TeamCreator {
    private final ProjectRootRepository repository;

    public TeamCreator(ProjectRootRepository repository) {
        this.repository = repository;
    }

    public void execute(ProjectId projectId, Team team) {
        Optional<ProjectRoot> response = this.repository.find(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("El proyecto solicitado no fue encontrado");

        ProjectRoot project = response.get();
        project.addTeam(team);
        this.repository.save(project);
    }
}
