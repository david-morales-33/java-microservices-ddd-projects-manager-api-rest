package com.microservice.administrative.project.domain;

public interface ProjectCommandRepository {
    void saveProjectFuncionalitiesContainer(ProjectFuncionalitiesContainer project);
    void saveProjectModulesContainer(ProjectModulesContainer project);
}
