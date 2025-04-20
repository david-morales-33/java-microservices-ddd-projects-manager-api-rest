package com.microservice.administrative.project.application.addModule;

import java.util.Optional;

import com.microservice.administrative.project.domain.ProjectCommandRepository;
import com.microservice.administrative.project.domain.ProjectModulesContainer;
import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.project.domain.ProjectQueryRepository;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.module.domain.Module;
import com.microservice.administrative.shared.domain.Service;

@Service
public final class ModuleCreator {
    private final ProjectQueryRepository queryRepository;
    private final ProjectCommandRepository commandRepository;

    public ModuleCreator(ProjectQueryRepository queryRepository, ProjectCommandRepository commandRepository) {
        this.queryRepository = queryRepository;
        this.commandRepository = commandRepository;
    }

    public void execute(ProjectId projectId, Module module) {
        Optional<ProjectModulesContainer> response = this.queryRepository.findProjectModulesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("El proyecto solicitado no fue encontrado");

        ProjectModulesContainer project = response.get();
        project.addModule(module);
        this.commandRepository.saveProjectModulesContainer(project);
    }
}
