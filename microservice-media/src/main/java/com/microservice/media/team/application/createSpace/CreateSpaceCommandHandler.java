package com.microservice.media.team.application.createSpace;

import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.bus.command.CommandHandler;
import com.microservice.media.space.domain.SpaceCreateBy;
import com.microservice.media.space.domain.SpaceCreationDate;
import com.microservice.media.space.domain.SpaceName;

import java.time.LocalDate;

public final class CreateSpaceCommandHandler implements CommandHandler<CreateSpaceCommand> {

    private final SpaceCreator creator;

    public CreateSpaceCommandHandler(SpaceCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateSpaceCommand command) {

        TeamId teamId = new TeamId(command.getTeamId());
        SpaceId id = new SpaceId(command.getId());
        SpaceName name = new SpaceName(command.getName());
        SpaceCreateBy createBy = new SpaceCreateBy(command.getCreateBy());
        SpaceCreationDate creationDate = new SpaceCreationDate(LocalDate.now().toString());

        this.creator.execute(teamId, id, name, creationDate, createBy);
    }
}
