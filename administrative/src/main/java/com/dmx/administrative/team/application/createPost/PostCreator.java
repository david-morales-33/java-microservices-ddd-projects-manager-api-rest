package com.dmx.administrative.team.application.createPost;

import com.dmx.administrative.post.domain.Post;
import com.dmx.administrative.post.domain.PostContent;
import com.dmx.administrative.post.domain.PostCreationDate;
import com.dmx.administrative.post.domain.PostTitle;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamCommandRepository;
import com.dmx.administrative.team.domain.TeamNotFoundException;
import com.dmx.administrative.team.domain.TeamQueryRepository;
import com.dmx.administrative.user.domain.User;
import com.dmx.shared.domain.PostId;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.UserId;

import java.util.Optional;

public class PostCreator {
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
