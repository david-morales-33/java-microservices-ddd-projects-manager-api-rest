package com.dmx.board.domain;

import com.dmx.project.domain.Project;
import com.dmx.project.domain.ProjectDTO;
import com.dmx.project.domain.ProjectItemIdList;
import com.dmx.project.domain.ProjectName;
import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.BoardId;
import com.dmx.shared.domain.ProjectId;

import java.util.Arrays;
import java.util.Objects;

public final class Board extends AggregateRoot {
    private final BoardId id;
    private final BoardName name;
    private final BoardCreateBy createBy;
    private final BoardCreationDate creationDate;
    private final BoardState state;
    private final Project[] projectList;

    public Board(
            BoardId id,
            BoardName name,
            BoardCreateBy createBy,
            BoardCreationDate creationDate,
            BoardState state,
            Project[] projectList
    ) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.creationDate = creationDate;
        this.state = state;
        this.projectList = projectList;
    }

    public static Board create(
            BoardId id,
            BoardName name,
            BoardCreateBy createBy,
            BoardCreationDate creationDate,
            BoardState state,
            Project[] projectList
    ) {
        return new Board(id, name, createBy, creationDate, state, projectList);
    }

    public BoardId getId() {
        return this.id;
    }

    public BoardName getName() {
        return this.name;
    }

    public BoardCreateBy getCreateBy() {
        return this.createBy;
    }

    public BoardCreationDate getCreationDate() {
        return this.creationDate;
    }

    public BoardState getState() {
        return this.state;
    }

    public Project[] getProjectList() {
        return this.projectList;
    }

    public static Board fromPrimitives(
            String id,
            String name,
            String createBy,
            String creationDate,
            boolean state,
            ProjectDTO[] projectList
    ) {
        int projectListLength = projectList.length;
        Project[] newProyectList = new Project[projectListLength];

        for (int project = 0; project < projectListLength; project++) {
            ProjectDTO currentProject = projectList[project];
            ProjectItemIdList[] newProjectItemIdList = new ProjectItemIdList[currentProject.itemList().length];
            for (int item = 0; item < currentProject.itemList().length; item++) {
                newProjectItemIdList[item] = new ProjectItemIdList(currentProject.itemList()[item]);
            }
            newProyectList[project] = new Project(
                    new ProjectId(currentProject.id()),
                    new ProjectName(currentProject.name()),
                    newProjectItemIdList
            );
        }

        return new Board(
                new BoardId(id),
                new BoardName(name),
                new BoardCreateBy(createBy),
                new BoardCreationDate(creationDate),
                new BoardState(state),
                newProyectList
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name,
                this.createBy,
                this.creationDate,
                this.state
        );
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name=" + name +
                ", createBy=" + createBy +
                ", creationDate=" + creationDate +
                ", state=" + state +
                ", projectList=" + Arrays.toString(projectList) +
                '}';
    }
}
