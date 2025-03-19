package com.microservice.media.shared.infrastructure;


import com.microservice.media.shared.domain.bus.command.CommandBus;
import com.microservice.media.shared.domain.bus.event.DomainEvent;
import com.microservice.media.shared.domain.bus.event.EventBus;
import com.microservice.media.shared.domain.bus.query.Query;
import com.microservice.media.shared.domain.bus.query.QueryBus;
import com.microservice.media.shared.domain.bus.query.Response;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public abstract class UnitTestCase {
    protected EventBus eventBus;
    protected QueryBus queryBus;
    protected CommandBus commandBus;

    @BeforeEach
    protected void setUp(){
        eventBus = mock(EventBus.class);
        queryBus = mock(QueryBus.class);
        commandBus = mock(CommandBus.class);
    }
    public void shouldHavePublished(List<DomainEvent> domainEvents) {
        verify(eventBus, atLeastOnce()).publish(domainEvents);
    }
    public void shouldHavePublished(DomainEvent domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }
    public void shouldAsk(Query query, Response response) {
        when(queryBus.ask(query)).thenReturn(response);
    }

}
