package com.microservice.media.team.application.createPost;

import com.microservice.media.post.domain.Post;
import com.microservice.media.post.domain.PostContent;
import com.microservice.media.post.domain.PostCreationDate;
import com.microservice.media.post.domain.PostId;
import com.microservice.media.post.domain.PostTitle;
import com.microservice.media.shared.domain.Service;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamCommandRepository;
import com.microservice.media.team.domain.TeamNotFoundException;
import com.microservice.media.team.domain.TeamQueryRepository;
import com.microservice.media.user.domain.User;

import java.util.Optional;

@Service
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
