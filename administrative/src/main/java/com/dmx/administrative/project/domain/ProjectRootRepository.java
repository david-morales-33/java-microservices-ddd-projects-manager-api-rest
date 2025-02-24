package com.dmx.administrative.project.domain;


import java.util.Optional;

import com.dmx.administrative.shared.domain.ProjectId;

public interface ProjectRootRepository {
    void save(ProjectRoot projectRoot);
    Optional<ProjectRoot> find(ProjectId projectId);
}
