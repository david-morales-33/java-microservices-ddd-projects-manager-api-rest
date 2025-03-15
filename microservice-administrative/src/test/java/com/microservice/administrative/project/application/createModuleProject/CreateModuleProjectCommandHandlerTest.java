package com.microservice.administrative.project.application.createModuleProject;

import com.microservice.administrative.project.ProjectUnitTestCase;
import com.microservice.administrative.project.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class CreateModuleProjectCommandHandlerTest extends ProjectUnitTestCase {

    CreateProjectCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreateProjectCommandHandler(new ProjectCreator(commandRepository, rootRepository));
    }

    @Test
    void it_should_create_a_new_module_project() {
        CreateProjectCommand command = CreateModuleProjectCommandTest.random();

        ProjectModulesContainer project = ProjectModulesContainerTest.fromRequest(command);

        shouldAnswerEmptyProject(ProjectIdTest.create(command.getId()));

        handler.handle(command);

        shouldVerifySaveModuleProject(project);
    }

    @Test
    void it_should_throw_an_exception_when_project_already_exists() {
        ProjectRoot project = ProjectRootTest.random();

        CreateProjectCommand command = CreateModuleProjectCommandTest.create(project.getId().value(),project.getName().value());

        shouldAnswerAnyProject(project);

        assertThrows(ProjectAlreadyExists.class, () -> handler.handle(command));
    }
}
