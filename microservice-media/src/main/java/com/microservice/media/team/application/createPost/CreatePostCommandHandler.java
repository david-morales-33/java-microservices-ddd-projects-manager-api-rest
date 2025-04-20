package com.microservice.media.team.application.createPost;

import com.microservice.media.post.domain.PostContent;
import com.microservice.media.post.domain.PostCreationDate;
import com.microservice.media.post.domain.PostId;
import com.microservice.media.post.domain.PostTitle;
import com.microservice.media.shared.domain.Service;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.shared.domain.bus.command.CommandHandler;
import com.microservice.media.team.domain.TeamNotFoundException;

import java.time.LocalDate;

@Service
public final class CreatePostCommandHandler implements CommandHandler<CreatePostCommand> {
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
