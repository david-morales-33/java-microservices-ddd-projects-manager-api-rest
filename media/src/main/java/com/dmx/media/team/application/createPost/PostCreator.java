package com.dmx.media.team.application.createPost;

import com.dmx.media.post.domain.*;
import com.dmx.media.shared.domain.SpaceId;
import com.dmx.media.shared.domain.TeamId;
import com.dmx.media.shared.domain.UserId;
import com.dmx.media.team.domain.Team;
import com.dmx.media.team.domain.TeamCommandRepository;
import com.dmx.media.team.domain.TeamNotFoundException;
import com.dmx.media.team.domain.TeamQueryRepository;
import com.dmx.media.user.domain.User;


import java.util.Optional;

public final class PostCreator {
    private final TeamCommandRepository commandRepository;
    private final TeamQueryRepository queryRepository;

    public PostCreator(TeamCommandRepository commandRepository, TeamQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public void execute(
            TeamId teamId,
            PostId posId,
            PostTitle title,
            PostContent content,
            PostCreationDate creationDate,
            SpaceId spaceId,
            UserId userId
    ) throws TeamNotFoundException {
        Optional<Team> response = this.queryRepository.find(teamId);
        if (response.isEmpty()) throw new TeamNotFoundException();

        Team team = response.get();

        User user = team.getMemberList().get(userId.value());
        Post post = Post.create(posId, title, content, creationDate, spaceId, user);
        team.addPost(post);
        this.commandRepository.save(team);
    }
}
