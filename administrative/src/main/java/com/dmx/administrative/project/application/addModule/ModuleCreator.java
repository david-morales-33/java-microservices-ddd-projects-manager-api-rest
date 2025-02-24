package com.dmx.administrative.project.application.addModule;

import com.dmx.administrative.module.domain.Module;
import com.dmx.administrative.project.domain.*;
import com.dmx.administrative.shared.domain.ProjectId;

import java.util.Optional;

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
