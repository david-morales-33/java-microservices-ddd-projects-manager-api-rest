package com.dmx.media.team.application.createPost;

import com.dmx.shared.domain.bus.command.Command;

public final class CreatePostCommand implements Command {
    private final String teamId;
    private final String posId;
    private final String title;
    private final String content;
    private final String creationDate;
    private final String spaceId;
    private final String userId;

    public CreatePostCommand(String teamId, String posId, String title, String content, String creationDate, String spaceId, String userId) {
        this.teamId = teamId;
        this.posId = posId;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.spaceId = spaceId;
        this.userId = userId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getPosId() {
        return this.posId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public String getUserId() {
        return this.userId;
    }
}
