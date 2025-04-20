package com.microservice.administrative.project.application.findFuncionalityProject;

import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.Service;
import com.microservice.administrative.shared.domain.bus.query.QueryHandler;

@Service
public final class FindProjectQueryHandler implements QueryHandler<FindProjectQuery, ProjectResponse> {
    private final ProjectFinder finder;

    public FindProjectQueryHandler(ProjectFinder finder) {
        this.finder = finder;
    }

    @Override
    public ProjectResponse handle(FindProjectQuery query) throws ProjectNotFound {
        ProjectId projectId = new ProjectId(query.getProjectId());
        return new ProjectResponse(this.finder.execute(projectId).toPrimitives());
    }
}
