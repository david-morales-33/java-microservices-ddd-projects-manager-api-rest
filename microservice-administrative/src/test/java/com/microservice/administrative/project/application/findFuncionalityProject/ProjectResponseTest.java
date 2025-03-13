package com.microservice.administrative.project.application.findFuncionalityProject;

import com.microservice.administrative.project.domain.*;

public final class ProjectResponseTest {
    public static ProjectResponse create(ProjectFuncionalitiesContainer project) {
        return new ProjectResponse(project.toPrimitives());
    }

    public static ProjectResponse random() {
        return create(ProjectFuncionalitiesContainerTest.random());
    }
}
