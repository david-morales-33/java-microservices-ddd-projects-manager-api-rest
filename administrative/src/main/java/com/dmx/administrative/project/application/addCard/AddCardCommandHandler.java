package com.dmx.administrative.project.application.addCard;

import com.dmx.administrative.card.domain.Card;
import com.dmx.administrative.card.domain.CardDTO;
import com.dmx.administrative.shared.domain.ProjectId;
import com.dmx.administrative.shared.domain.bus.command.CommandHandler;

import java.time.LocalDate;

public final class AddCardCommandHandler implements CommandHandler<AddCardCommand> {
    private final CardCreator creator;

    public AddCardCommandHandler(CardCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddCardCommand command) {
        ProjectId projectId = new ProjectId(command.getProjectId());
        Card card = Card.fromPrimitives(new CardDTO(command.getTeamId(), command.getName(), LocalDate.now().toString()));
        this.creator.execute(projectId, card);
    }
}
