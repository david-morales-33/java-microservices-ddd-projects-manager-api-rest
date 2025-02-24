package com.dmx.administrative.project.domain;


import java.util.Optional;

import com.dmx.administrative.shared.domain.ProjectId;

public interface ProjectQueryRepository {
    Optional<ProjectFuncionalitiesContainer> findProjectFuncionalitiesContainer(ProjectId projectId);
    Optional<ProjectModulesContainer> findProjectModulesContainer(ProjectId projectId);
}
