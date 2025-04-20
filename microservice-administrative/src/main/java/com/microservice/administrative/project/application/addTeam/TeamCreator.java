package com.microservice.administrative.project.application.addTeam;

import java.util.Optional;

import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.project.domain.ProjectRoot;
import com.microservice.administrative.project.domain.ProjectRootRepository;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.Service;
import com.microservice.administrative.team.domain.Team;

@Service
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
