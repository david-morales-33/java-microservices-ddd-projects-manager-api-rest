package com.microservice.administrative.project.application.addModule;

import com.microservice.administrative.module.domain.*;
import com.microservice.administrative.module.domain.Module;
import com.microservice.administrative.project.ProjectUnitTestCase;
import com.microservice.administrative.project.domain.*;
import com.microservice.administrative.shared.domain.ModuleId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public final class AddModuleCommandHandlerTest extends ProjectUnitTestCase {

    AddModuleCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new AddModuleCommandHandler(new ModuleCreator(queryRepository, commandRepository));
    }

    @Test
    void it_should_create_a_new_module() {
        ProjectModulesContainer project = ProjectModulesContainerTest.random();

        AddModuleCommand command = AddModuleCommandTest.create(project.getId().value(), ModuleIdTest.random().value(), ModuleNameTest.random().value(), ModuleCreationDateTest.random().value());

        shouldAnswerAnyModuleProject(project);

        handler.handle(command);

        shouldVerifySaveModuleProject(project);

    }

    @Test
    void it_should_throw_an_exception_when_project_does_not_exists() {
        ProjectModulesContainer project = ProjectModulesContainerTest.random();

        AddModuleCommand command = AddModuleCommandTest.create(project.getId().value(), ModuleIdTest.random().value(), ModuleNameTest.random().value(), ModuleCreationDateTest.random().value());

        shouldAnswerEmptyModuleProject(project);

        assertThrows(ProjectNotFound.class, () -> handler.handle(command));
    }

    @Test
    void it_should_throws_an_exception_when_project_already_exists() {
        AddModuleCommand command = AddModuleCommandTest.random();

        HashMap<Integer, Module> moduleList = new HashMap<>();
        moduleList.put(command.getModuleId(), ModuleTest.create(
                ModuleIdTest.create(command.getModuleId()),
                ModuleNameTest.create(command.getName()),
                ModuleCreationDateTest.create(command.getCreationDate()),
                new HashMap<>()
        ));

        ProjectModulesContainer project = ProjectModulesContainerTest.create(
                ProjectIdTest.create(command.getProjectId()),
                ProjectNameTest.random(),
                ProjectFuncionalitiesCounterTest.random(),
                new HashMap<>(),
                new HashMap<>(),
                moduleList
        );

        shouldAnswerAnyModuleProject(project);

        assertThrows(ProjectModuleAlreadyExistsException.class, ()-> handler.handle(command));
    }
}
