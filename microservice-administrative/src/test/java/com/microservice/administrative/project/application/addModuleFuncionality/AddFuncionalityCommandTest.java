package com.microservice.administrative.project.application.addModuleFuncionality;

import com.microservice.administrative.funcionality.domain.FuncionalityDescriptionTest;
import com.microservice.administrative.funcionality.domain.FuncionalityIdTest;
import com.microservice.administrative.funcionality.domain.FuncionalityNameTest;
import com.microservice.administrative.module.domain.ModuleIdTest;
import com.microservice.administrative.project.domain.ProjectIdTest;
import com.microservice.administrative.team.domain.TeamIdTest;

public final class AddFuncionalityCommandTest {
    public static AddFuncionalityCommand create(
            String projectId,
            String teamId,
            int funcionalityId,
            int moduleId,
            String name,
            String description
    ){
        return new AddFuncionalityCommand(projectId, teamId, funcionalityId, moduleId, name, description);
    }
    public static AddFuncionalityCommand random(){
        return create(
                ProjectIdTest.random().value(),
                TeamIdTest.random().value(),
                FuncionalityIdTest.random().value(),
                ModuleIdTest.random().value(),
                FuncionalityNameTest.random().value(),
                FuncionalityDescriptionTest.random().value()
        );
    }
}
