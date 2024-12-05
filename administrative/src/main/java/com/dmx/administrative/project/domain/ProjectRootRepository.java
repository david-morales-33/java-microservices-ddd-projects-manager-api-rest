package com.dmx.administrative.project.domain;

import com.dmx.shared.domain.ProjectId;

import java.util.Optional;

public interface ProjectRootRepository {
    void save(ProjectRoot projectRoot);
    Optional<ProjectRoot> find(ProjectId projectId);
}
