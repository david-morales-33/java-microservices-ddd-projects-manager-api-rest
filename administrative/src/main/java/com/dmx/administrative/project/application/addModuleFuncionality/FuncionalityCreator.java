package com.dmx.administrative.project.application.addModuleFuncionality;

import com.dmx.administrative.funcionality.domain.Funcionality;
import com.dmx.administrative.project.domain.ProjectCommandRepository;
import com.dmx.administrative.project.domain.ProjectModulesContainer;
import com.dmx.administrative.project.domain.ProjectNotFound;
import com.dmx.administrative.project.domain.ProjectQueryRepository;
import com.dmx.shared.domain.ModuleId;
import com.dmx.shared.domain.ProjectId;

import java.util.Optional;

public final class FuncionalityCreator {
    private final ProjectCommandRepository commandRepository;
    private final ProjectQueryRepository queryRepository;

    public FuncionalityCreator(
            ProjectCommandRepository commandRepository,
            ProjectQueryRepository queryRepository
    ) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public void execute(ProjectId projectId, ModuleId moduleId, Funcionality funcionality) {
        Optional<ProjectModulesContainer> response = this.queryRepository.findProjectModulesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("No se encontró el proyecto solicitado");
        ProjectModulesContainer project = response.get();
        project.addFuncionality(moduleId, funcionality);
        this.commandRepository.saveProjectModulesContainer(project);
    }
}
