package com.dmx.administrative.team.application.createSpace;

import com.dmx.administrative.space.domain.SpaceCreateBy;
import com.dmx.administrative.space.domain.SpaceCreationDate;
import com.dmx.administrative.space.domain.SpaceName;
import com.dmx.administrative.team.domain.Team;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.bus.command.CommandHandler;

import java.time.LocalDate;
import java.util.Date;

public class CreateSpaceCommandHandler implements CommandHandler<CreateSpaceCommand> {

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
