package com.dmx.administrative.board.domain;

import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.BoardId;

import java.util.Objects;

public final class Board extends AggregateRoot {
    private final BoardId id;
    private final BoardName name;
    private final BoardCreateBy createBy;
    private final BoardCreationDate creationDate;

    public Board(
            BoardId id,
            BoardName name,
            BoardCreateBy createBy,
            BoardCreationDate creationDate
    ) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.creationDate = creationDate;
    }

    public static Board create(
            BoardId id,
            BoardName name,
            BoardCreateBy createBy,
            BoardCreationDate creationDate
    ) {
        return new Board(id, name, createBy, creationDate);
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

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name,
                this.createBy,
                this.creationDate
        );
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name=" + name +
                ", createBy=" + createBy +
                ", creationDate=" + creationDate +
                '}';
    }
}
