package com.dmx.administrative.project.domain;

import com.dmx.shared.domain.ProjectId;

import java.util.Optional;

public interface ProjectQueryRepository {
    Optional<ProjectFuncionalitiesContainer> findProjectFuncionalitiesContainer(ProjectId projectId);
    Optional<ProjectModulesContainer> findProjectModulesContainer(ProjectId projectId);
}
