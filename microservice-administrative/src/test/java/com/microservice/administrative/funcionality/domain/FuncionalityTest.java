package com.microservice.administrative.funcionality.domain;

import com.microservice.administrative.shared.domain.FuncionalityId;
import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.team.domain.TeamIdTest;

public final class FuncionalityTest {
    public static Funcionality create(
            FuncionalityId id,
            FuncionalityName name,
            FuncionalityDescription description,
            FuncionalityCreationdate creationdate,
            FuncionalityState state,
            TeamId teamId
    ) {
        return new Funcionality(id, name, description, creationdate, state, teamId);
    }

    public static Funcionality random() {
        return create(
                FuncionalityIdTest.random(),
                FuncionalityNameTest.random(),
                FuncionalityDescriptionTest.random(),
                FuncionalityCreationDateTest.random(),
                FuncionalityStateTest.random(),
                TeamIdTest.random()
        );
    }
}
