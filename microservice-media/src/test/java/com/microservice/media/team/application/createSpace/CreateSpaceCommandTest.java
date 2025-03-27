package com.microservice.media.team.application.createSpace;

import com.microservice.media.post.domain.PostCreationDateTest;
import com.microservice.media.space.domain.SpaceCreateByTest;
import com.microservice.media.space.domain.SpaceIdTest;
import com.microservice.media.space.domain.SpaceNameTest;
import com.microservice.media.team.domain.TeamIdTest;

public final class CreateSpaceCommandTest {
    public static CreateSpaceCommand create(String teamId, String id, String name, String createBy) {
        return new CreateSpaceCommand(teamId, id, name, createBy);
    }

    public static CreateSpaceCommand random(String teamId) {
        return create(
                teamId,
                SpaceIdTest.random().value(),
                SpaceNameTest.random().value(),
                SpaceCreateByTest.random().value()
        );
    }
}
