package com.dmx.project.domain;

import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.ProjectId;

public abstract class Project extends AggregateRoot {
    private ProjectId id;
    private ProjectName name;
}
