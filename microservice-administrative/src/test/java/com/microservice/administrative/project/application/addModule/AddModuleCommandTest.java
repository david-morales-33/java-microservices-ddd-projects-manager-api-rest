package com.microservice.administrative.project.application.addModule;

import com.microservice.administrative.module.domain.ModuleCreationDateTest;
import com.microservice.administrative.module.domain.ModuleIdTest;
import com.microservice.administrative.module.domain.ModuleNameTest;
import com.microservice.administrative.project.domain.ProjectIdTest;

public final class AddModuleCommandTest {
    public static AddModuleCommand create(String projectId, int moduleId, String name, String creationDate) {
        return new AddModuleCommand(projectId, moduleId, name, creationDate);
    }

    public static AddModuleCommand random() {
        return create(ProjectIdTest.random().value(), ModuleIdTest.random().value(), ModuleNameTest.random().value(), ModuleCreationDateTest.random().value());
    }
}
