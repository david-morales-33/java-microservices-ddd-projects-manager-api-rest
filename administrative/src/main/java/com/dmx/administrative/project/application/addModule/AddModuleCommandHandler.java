package com.dmx.administrative.project.application.addModule;

import com.dmx.administrative.funcionality.domain.FuncionalityDTO;
import com.dmx.administrative.module.domain.Module;
import com.dmx.administrative.module.domain.ModuleDTO;
import com.dmx.shared.domain.ProjectId;
import com.dmx.shared.domain.bus.command.CommandHandler;

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
