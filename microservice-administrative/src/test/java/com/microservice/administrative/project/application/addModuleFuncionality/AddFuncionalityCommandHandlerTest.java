package com.microservice.administrative.project.application.addModuleFuncionality;

import com.microservice.administrative.funcionality.domain.FuncionalityDescriptionTest;
import com.microservice.administrative.funcionality.domain.FuncionalityNameTest;
import com.microservice.administrative.module.domain.Module;
import com.microservice.administrative.module.domain.ModuleIdTest;
import com.microservice.administrative.module.domain.ModuleNotFoundException;
import com.microservice.administrative.module.domain.ModuleTest;
import com.microservice.administrative.project.ProjectUnitTestCase;
import com.microservice.administrative.project.domain.*;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamIdTest;
import com.microservice.administrative.team.domain.TeamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public final class AddFuncionalityCommandHandlerTest extends ProjectUnitTestCase {

    AddFuncionalityCommandHandler handler;

    ProjectModulesContainer project;

    AddFuncionalityCommand command;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        handler = new AddFuncionalityCommandHandler(new FuncionalityCreator(commandRepository, queryRepository));

        this.command = AddFuncionalityCommandTest.random();

        HashMap<String, Team> teamList = new HashMap<>();
        teamList.put(command.getTeamId(), TeamTest.create(TeamIdTest.create(command.getTeamId())));
        HashMap<Integer, Module> moduleList = new HashMap<>();
        moduleList.put(command.getModuleId(), ModuleTest.create(ModuleIdTest.create(command.getModuleId())));

        this.project = ProjectModulesContainerTest.create(
                ProjectIdTest.create(command.getProjectId()),
                ProjectNameTest.random(),
                ProjectFuncionalitiesCounterTest.random(),
                teamList,
                new HashMap<>(),
                moduleList
        );
    }

    @Test
    void it_should_create_a_new_module_funcionality(){

        shouldAnswerAnyModuleProject(project);

        handler.handle(command);

        shouldVerifySaveModuleProject(project);
    }

    @Test
    void it_should_throw_an_exception_when_project_not_exists(){
        shouldAnswerEmptyModuleProject(project);

        assertThrows(ProjectNotFound.class, ()-> handler.handle(command));
    }

    @Test
    void it_should_throw_an_exception_when_module_not_exists_on_project() {
        ProjectModulesContainer project = ProjectModulesContainerTest.random();

        AddFuncionalityCommand command = AddFuncionalityCommandTest.create(
                project.getId().value(),
                TeamIdTest.random().value(),
                project.getFuncionalitiesCounter().value(),
                ModuleIdTest.random().value(),
                FuncionalityNameTest.random().value(),
                FuncionalityDescriptionTest.random().value()
        );

        shouldAnswerAnyModuleProject(project);

        assertThrows(ModuleNotFoundException.class,()->handler.handle(command));
    }
}
