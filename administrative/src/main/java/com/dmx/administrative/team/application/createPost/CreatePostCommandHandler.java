package com.dmx.administrative.team.application.createPost;

import com.dmx.administrative.post.domain.PostContent;
import com.dmx.administrative.post.domain.PostCreationDate;
import com.dmx.administrative.post.domain.PostTitle;
import com.dmx.administrative.team.domain.TeamNotFoundException;
import com.dmx.shared.domain.PostId;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.UserId;
import com.dmx.shared.domain.bus.command.CommandHandler;

import java.time.LocalDate;

public class CreatePostCommandHandler implements CommandHandler<CreatePostCommand> {
    private final PostCreator creator;

    public CreatePostCommandHandler(PostCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreatePostCommand command) throws TeamNotFoundException {
        TeamId teamId = new TeamId(command.getTeamId());
        PostId posId = new PostId(command.getPosId());
        PostTitle title = new PostTitle(command.getTitle());
        PostContent content = new PostContent(command.getContent());
        PostCreationDate creationDate = new PostCreationDate(LocalDate.now().toString());
        SpaceId spaceId = new SpaceId(command.getSpaceId());
        UserId userId = new UserId(command.getUserId());

        this.creator.execute(teamId, posId, title, content, creationDate, spaceId, userId);
    }
}
