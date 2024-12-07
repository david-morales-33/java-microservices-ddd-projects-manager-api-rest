package com.dmx.administrative.project.application.findFuncionalityProject;


import com.dmx.administrative.project.domain.ProjectNotFound;
import com.dmx.shared.domain.ProjectId;
import com.dmx.shared.domain.bus.query.QueryHandler;

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
