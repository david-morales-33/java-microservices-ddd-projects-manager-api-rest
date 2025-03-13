package com.microservice.administrative.project;

import com.microservice.administrative.project.domain.*;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ProjectUnitTestCase extends UnitTestCase {
    protected ProjectCommandRepository commandRepository;
    protected ProjectQueryRepository queryRepository;
    protected ProjectRootRepository rootRepository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        commandRepository = mock(ProjectCommandRepository.class);
        queryRepository = mock(ProjectQueryRepository.class);
        rootRepository = mock(ProjectRootRepository.class);
    }

    public void shouldVerifySaveModuleProject(ProjectModulesContainer project) {
        verify(commandRepository, atLeastOnce()).saveProjectModulesContainer(project);
    }

    public void shouldVerifySaveFuncionalitiesProject(ProjectFuncionalitiesContainer project) {
        verify(commandRepository, atLeastOnce()).saveProjectFuncionalitiesContainer(project);
    }

    public void shouldVerifySaveProject(ProjectRoot projectRoot) {
        verify(rootRepository, atLeastOnce()).save(projectRoot);
    }

    public void shouldAnswerEmptyModuleProject(ProjectModulesContainer project) {
        when(queryRepository.findProjectModulesContainer(project.getId())).thenReturn(Optional.empty());
    }

    public void shouldAnswerAnyModuleProject(ProjectModulesContainer project) {
        when(queryRepository.findProjectModulesContainer(project.getId())).thenReturn(Optional.of(project));
    }

    public void shouldAnswerEmptyFuncionalitiesProject(ProjectId id) {
        when(queryRepository.findProjectFuncionalitiesContainer(id)).thenReturn(Optional.empty());
    }

    public void shouldAnswerAnyFuncionalitiesProject(ProjectFuncionalitiesContainer project) {
        when(queryRepository.findProjectFuncionalitiesContainer(project.getId())).thenReturn(Optional.of(project));
    }

    public void shouldAnswerAnyProject(ProjectRoot project) {
        when(rootRepository.find(project.getId())).thenReturn(Optional.of(project));
    }

    public void shouldAnswerEmptyProject(ProjectId id) {
        when(rootRepository.find(id)).thenReturn(Optional.empty());
    }
}
