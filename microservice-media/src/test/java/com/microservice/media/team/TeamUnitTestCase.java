package com.microservice.media.team;

import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.criteria.Criteria;
import com.microservice.media.shared.infrastructure.UnitTestCase;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamCommandRepository;
import com.microservice.media.team.domain.TeamQueryRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class TeamUnitTestCase extends UnitTestCase {

    protected TeamQueryRepository queryRepository;
    protected TeamCommandRepository commandRepository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        queryRepository = mock(TeamQueryRepository.class);
        commandRepository = mock(TeamCommandRepository.class);
    }

    public void shouldAnswerAnyTeam(Team team) {
        when(queryRepository.find(team.getId())).thenReturn(Optional.of(team));
    }

    public void shouldAnswerEmptyTeam(TeamId id) {
        when(queryRepository.find(id)).thenReturn(Optional.empty());
    }

    public void shouldAnswerAnyTeamList(Team team) {
        when(queryRepository.searchAll()).thenReturn(List.of(team));
    }

    public void shouldAnswerEmptyTeamList() {
        when(queryRepository.searchAll()).thenReturn(new ArrayList<>());
    }

    public void shouldAnswerAnyTeamByCriteria(Criteria criteria, List<Team> teamList) {
        when(queryRepository.match(criteria)).thenReturn(teamList);
    }

    public void shouldAnswerEmptyTeamByCriteria(Criteria criteria) {
        when(queryRepository.match(criteria)).thenReturn(new ArrayList<>());
    }

    public void shouldVerifySaveTeam(Team team) {
        verify(commandRepository, atLeastOnce()).save(team);
    }
}
