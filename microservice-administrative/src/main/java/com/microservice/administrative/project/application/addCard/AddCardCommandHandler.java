package com.microservice.administrative.project.application.addCard;

import java.time.LocalDate;

import com.microservice.administrative.card.domain.Card;
import com.microservice.administrative.card.domain.CardDTO;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.Service;
import com.microservice.administrative.shared.domain.bus.command.CommandHandler;

@Service
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
