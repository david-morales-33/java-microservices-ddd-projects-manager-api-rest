package com.dmx.administrative.project.application.createFuncionalitiesProject;

import com.dmx.administrative.project.domain.*;
import com.dmx.shared.domain.ProjectId;

import java.util.HashMap;
import java.util.Optional;

public final class ProjectCreator {
    private final ProjectCommandRepository commandRepository;
    private final ProjectRootRepository projectRootRepository;

    public ProjectCreator(ProjectCommandRepository commandRepository, ProjectRootRepository projectRootRepository) {
        this.commandRepository = commandRepository;
        this.projectRootRepository = projectRootRepository;
    }

    public void execute(ProjectId projectId, ProjectName projectName) {

        Optional<ProjectRoot> response = this.projectRootRepository.find(projectId);
        if (response.isPresent()) throw new ProjectAlreadyExists("El projecto ya existe");

        ProjectFuncionalitiesContainer project = ProjectFuncionalitiesContainer.create(
                projectId,
                projectName,
                new ProjectFuncionalitiesCounter(0),
                new HashMap<>(),
                new HashMap<>(),
                new HashMap<>()
        );
        this.commandRepository.saveProjectFuncionalitiesContainer(project);
    }
}
