package com.microservice.media.space;

import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.infrastructure.UnitTestCase;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceQueryRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class SpaceUnitTestCase extends UnitTestCase {

    protected SpaceQueryRepository queryRepository;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        queryRepository = mock(SpaceQueryRepository.class);
    }

    public void shouldAnswerAnySpace(Space space){
        when(queryRepository.find(space.getId())).thenReturn(Optional.of(space));
    }

    public void shouldAnswerEmptySpace(SpaceId id){
        when(queryRepository.find(id)).thenReturn(Optional.empty());
    }
}
