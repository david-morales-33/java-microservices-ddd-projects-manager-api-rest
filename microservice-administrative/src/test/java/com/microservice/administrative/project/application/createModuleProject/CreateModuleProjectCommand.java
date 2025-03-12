package com.microservice.administrative.project.application.createModuleProject;

import com.microservice.administrative.project.domain.ProjectIdTest;
import com.microservice.administrative.project.domain.ProjectNameTest;

public final class CreateModuleProjectCommand {
    public static CreateProjectCommand create(String id, String name) {
        return new CreateProjectCommand(id, name);
    }

    public static CreateProjectCommand random() {
        return create(ProjectIdTest.random().value(), ProjectNameTest.random().value());
    }
}
