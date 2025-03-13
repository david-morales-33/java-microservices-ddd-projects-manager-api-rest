package com.microservice.administrative.project.application.findFuncionalityProject;

import com.microservice.administrative.shared.domain.UuidTest;

public final class FindProjectQueryTest {
    public static FindProjectQuery create(String id) {
        return new FindProjectQuery(id);
    }

    public static FindProjectQuery random() {
        return create(UuidTest.random());
    }
}
