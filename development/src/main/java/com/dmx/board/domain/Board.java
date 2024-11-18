package com.dmx.board.domain;

import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.BoardId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board extends AggregateRoot {
    private final BoardId id;
    private final BoardName name;
    private final BoardCreateBy createBy;
    private final BoardCreationDate creationDate;
    private final BoardState state;
    private final BoardProjectsId[] projectsId;

    public Board(
            BoardId id,
            BoardName name,
            BoardCreateBy createBy,
            BoardCreationDate creationDate,
            BoardState state,
            BoardProjectsId[] projectsIds
    ) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.creationDate = creationDate;
        this.state = state;
        this.projectsId = projectsIds;
    }

    public static Board create(
            BoardId id,
            BoardName name,
            BoardCreateBy createBy,
            BoardCreationDate creationDate,
            BoardState state,
            BoardProjectsId[] projectsIds
    ) {
        return new Board(id, name, createBy, creationDate, state, projectsIds);
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

    public BoardProjectsId[] getProjectsId() {
        return this.projectsId;
    }

    public static Board fromPrimitives(
            String id,
            String name,
            String createBy,
            String creationDate,
            boolean state,
            String[] projectsIds
    ) {
        BoardProjectsId[] projectsIdList = new BoardProjectsId[]{};
        return new Board(
                new BoardId(id),
                new BoardName(name),
                new BoardCreateBy(createBy),
                new BoardCreationDate(creationDate),
                new BoardState(state),
                projectsIdList
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name,
                this.createBy,
                this.creationDate,
                this.state,
                this.projectsId
        );
    }
}
