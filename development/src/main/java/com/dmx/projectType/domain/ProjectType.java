package com.dmx.projectType.domain;

import com.dmx.shared.domain.ProjectTypeId;

public class ProjectType {
    private final ProjectTypeId id;
    private final ProjectTypeName name;

    public ProjectType(ProjectTypeId id, ProjectTypeName name){
        this.id = id;
        this.name = name;
    }

//    static public ProjectType(){
//
//    }
}
