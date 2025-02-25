package com.microservice.administrative.project.application.addModule;

import com.microservice.administrative.funcionality.domain.FuncionalityDTO;
import com.microservice.administrative.module.domain.ModuleDTO;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.bus.command.CommandHandler;
import com.microservice.administrative.module.domain.Module;

import java.util.HashMap;

public class AddModuleCommandHandler implements CommandHandler<AddModuleCommand> {
    private final ModuleCreator creator;

    public AddModuleCommandHandler(ModuleCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddModuleCommand command) {
        HashMap<String, FuncionalityDTO> funcionalityList = new HashMap<>();

        ProjectId projectId = new ProjectId(command.getProjectId());
        Module module = Module.fromPrimitives(new ModuleDTO(
                command.getModuleId(),
                command.getName(),
                command.getCreationDate(),
                0,
                funcionalityList
        ));
        this.creator.execute(projectId, module);
    }
}
