package com.dmx.project.domain;

import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.ProjectId;

public final class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;
    private final ProjectItemIdList[] itemIdList;

    public Project(ProjectId id, ProjectName name, ProjectItemIdList[] itemIdList) {
        this.id = id;
        this.name = name;
        this.itemIdList = itemIdList;
    }

    public static Project create(ProjectId id, ProjectName name, ProjectItemIdList[] itemIdList) {
        return new Project(id, name, itemIdList);
    }

    public ProjectId getId() {
        return this.id;
    }

    public ProjectName getName() {
        return this.name;
    }

    public ProjectItemIdList[] getItemIdList() {
        return this.itemIdList;
    }

    public static Project fromPrimitives(ProjectDTO data) {
        int itemIdListLength = data.itemList().length;

        ProjectItemIdList[] newItemIdList = new ProjectItemIdList[itemIdListLength];

        for (int itemId = 0; itemId < itemIdListLength; itemId++) {
            String currentItemId = data.itemList()[itemId];
            newItemIdList[itemId] = new ProjectItemIdList(currentItemId);
        }
        return new Project(
                new ProjectId(data.id()),
                new ProjectName(data.name()),
                newItemIdList
        );
    }
}
