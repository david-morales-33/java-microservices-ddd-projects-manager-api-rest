package com.microservice.administrative.project.application.findModuleProject;

import com.microservice.administrative.project.ProjectModuleUnitTestCase;
import com.microservice.administrative.project.domain.ProjectModulesContainer;
import com.microservice.administrative.project.domain.ProjectModulesContainerTest;
import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.shared.domain.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public final class FindProjectQueryHandlerTest extends ProjectModuleUnitTestCase {

    FindProjectQueryHandler handler;

    @BeforeEach
    public void setUp() {
        super.setUp();
        handler = new FindProjectQueryHandler(new ProjectFinder(queryRepository));
    }

    @Test
    void it_should_find_an_existing_project() {
        ProjectModulesContainer project = ProjectModulesContainerTest.random();
        FindProjectQuery query = FindProjectQueryTest.create(project.getId().value());

        ProjectResponse response = ProjectResponseTest.create(
                project.getId(),
                project.getName(),
                project.getFuncionalitiesCounter(),
                project.getTeamList(),
                project.getCardList(),
                project.getModuleList()
        );

        shouldAnswerAnyModuleProject(project);
        assertEquals(response.getResponse(), handler.handle(query).getResponse());
    }

    @Test
    void it_should_throws_an_exception_when_project_doest_not_exists() {
        FindProjectQuery query = FindProjectQueryTest.random();

        shouldAnswerEmptyFuncionalitiesProject(new ProjectId(query.getProjectId()));
        assertThrows(ProjectNotFound.class, () -> handler.handle(query));
    }
}
