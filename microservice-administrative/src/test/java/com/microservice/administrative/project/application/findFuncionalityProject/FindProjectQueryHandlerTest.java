package com.microservice.administrative.project.application.findFuncionalityProject;

import com.microservice.administrative.project.ProjectUnitTestCase;
import com.microservice.administrative.project.domain.ProjectFuncionalitiesContainer;
import com.microservice.administrative.project.domain.ProjectFuncionalitiesContainerTest;
import com.microservice.administrative.project.domain.ProjectIdTest;
import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.shared.domain.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class FindProjectQueryHandlerTest extends ProjectUnitTestCase {

    FindProjectQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new FindProjectQueryHandler(new ProjectFinder(queryRepository));
    }

    @Test
    void it_should_find_an_existing_project() {

        ProjectFuncionalitiesContainer project = ProjectFuncionalitiesContainerTest.random();

        FindProjectQuery query = FindProjectQueryTest.create(project.getId().value());

        ProjectResponse response = ProjectResponseTest.create(project);

        shouldAnswerAnyFuncionalitiesProject(project);

        assertEquals(response.getResponse(), handler.handle(query).getResponse());
    }

    @Test
    void it_should_throw_an_exception_when_project_does_not_exists() {
        ProjectId id = ProjectIdTest.random();

        FindProjectQuery query = FindProjectQueryTest.create(id.value());

        shouldAnswerEmptyFuncionalitiesProject(id);

        assertThrows(ProjectNotFound.class, () -> handler.handle(query));
    }
}
