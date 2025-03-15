package com.microservice.administrative.project.application.createFuncionalityProject;

import com.microservice.administrative.project.ProjectUnitTestCase;
import com.microservice.administrative.project.application.createFuncionalitiesProject.CreateProjectCommand;
import com.microservice.administrative.project.application.createFuncionalitiesProject.CreateProjectCommandHandler;
import com.microservice.administrative.project.application.createFuncionalitiesProject.ProjectCreator;
import com.microservice.administrative.project.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class CreateProjectCommandHandlerTest extends ProjectUnitTestCase {

    CreateProjectCommandHandler handler;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        handler = new CreateProjectCommandHandler(new ProjectCreator(commandRepository, rootRepository));
    }

    @Test
    void it_should_create_a_new_project(){
        CreateProjectCommand command = CreateProjectCommandTest.random();

        ProjectFuncionalitiesContainer project = ProjectFuncionalitiesContainerTest.fromRequest(command);

        shouldAnswerEmptyProject(ProjectIdTest.create(command.getId()));

        handler.handle(command);

        shouldVerifySaveFuncionalitiesProject(project);
    }

    @Test
    void it_should_throw_an_exception_when_project_already_exist(){
        ProjectRoot project = ProjectRootTest.random();

        CreateProjectCommand command = CreateProjectCommandTest.create(project.getId().value(),project.getName().value());

        shouldAnswerAnyProject(project);

        assertThrows(ProjectAlreadyExists.class, ()-> handler.handle(command));
    }
}
