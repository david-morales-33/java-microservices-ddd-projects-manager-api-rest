package com.microservice.administrative.project.application.findFuncionalityProject;

import com.microservice.administrative.shared.domain.bus.query.Query;

public final class FindProjectQuery implements Query {
    private final String projectId;

    public FindProjectQuery(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return this.projectId;
    }
}
