package com.microservice.administrative.project.application.addCard;

import com.microservice.administrative.card.domain.*;
import com.microservice.administrative.project.ProjectUnitTestCase;
import com.microservice.administrative.project.domain.*;
import com.microservice.administrative.shared.domain.CardId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class AddCardCommandHandlerTest extends ProjectUnitTestCase {

    AddCardCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new AddCardCommandHandler(new CardCreator(rootRepository));
    }

    @Test
    void it_should_create_a_new_card() {
        AddCardCommand command = AddCardCommandTest.random();
        ProjectRoot project = ProjectRootTest.create(ProjectIdTest.create(command.getProjectId()));

        shouldAnswerAnyProject(project);

        handler.handle(command);

        shouldVerifySaveProject(project);
    }

    @Test
    void it_should_throw_an_exception_when_project_does_not_exists() {
        AddCardCommand command = AddCardCommandTest.random();

        shouldAnswerEmptyProject(ProjectIdTest.create(command.getProjectId()));

        assertThrows(ProjectNotFound.class, () -> handler.handle(command));
    }

    @Test
    void it_should_throws_an_exception_when_card_already_exists() {
        AddCardCommand command = AddCardCommandTest.random();

        CardId cardId = CardIdTest.random();

        HashMap<String, Card> cardList = new HashMap<>();
        cardList.put(cardId.value(), CardTest.create(cardId, CardNameTest.create(command.getName()), CardCreationDateTest.random()));

        ProjectRoot project = ProjectRootTest.create(
                ProjectIdTest.create(command.getProjectId()),
                ProjectNameTest.random(),
                ProjectFuncionalitiesCounterTest.random(),
                new HashMap<>(),
                cardList
        );

        shouldAnswerAnyProject(project);

        assertThrows(ProjectInternalException.class, ()-> handler.handle(command));
    }
}
