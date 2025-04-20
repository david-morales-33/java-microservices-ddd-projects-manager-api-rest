package com.microservice.media.space.application.find;

import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.space.SpaceUnitTestCase;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceIdTest;
import com.microservice.media.space.domain.SpaceTest;
import com.microservice.media.team.domain.SpaceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class FindSpaceQueryHandlerTest extends SpaceUnitTestCase {

    FindSpaceQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new FindSpaceQueryHandler(new SpaceFinder(queryRepository));
    }

    @Test
    void it_should_find_an_existinting_space() {

        Space space = SpaceTest.random();
        SpaceResponse response = SpaceResponseTest.create(space.toPrimitives());
        FindSpaceQuery query = FindSpaceQueryTest.create(space.getId().value());

        shouldAnswerAnySpace(space);

        assertEquals(response.response(), handler.handle(query).response());
    }

    @Test
    void it_should_throw_an_exception_when_space_does_not_exists() {
        SpaceId id = SpaceIdTest.random();
        FindSpaceQuery query = FindSpaceQueryTest.create(id.value());

        shouldAnswerEmptySpace(id);

        assertThrows(SpaceNotFoundException.class, () -> handler.handle(query));
    }
}
