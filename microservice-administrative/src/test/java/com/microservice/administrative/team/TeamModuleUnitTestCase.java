package com.microservice.administrative.team;

import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.shared.domain.criteria.Criteria;
import com.microservice.administrative.shared.infrastructure.UnitTestCase;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamCommandRepository;
import com.microservice.administrative.team.domain.TeamQueryRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class TeamModuleUnitTestCase extends UnitTestCase {
    protected TeamQueryRepository queryRepository;
    protected TeamCommandRepository commandRepository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        queryRepository = mock(TeamQueryRepository.class);
        commandRepository = mock(TeamCommandRepository.class);
    }

    public void shouldHaveSave(Team team) {
        verify(commandRepository, atLeastOnce()).save(team);
    }

    public void shouldHaveAsk(TeamId id) {
        verify(queryRepository, atLeastOnce()).find(id);
    }

    public void shouldHaveAskById(Team team) {
        when(queryRepository.find(team.getId())).thenReturn(Optional.of(team));
    }

    public void shouldHaveAskById(TeamId id) {
        when(queryRepository.find(id)).thenReturn(Optional.empty());
    }
}
