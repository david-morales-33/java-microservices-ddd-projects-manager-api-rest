package com.microservice.administrative.module.domain;

import com.microservice.administrative.funcionality.domain.Funcionality;
import com.microservice.administrative.funcionality.domain.FuncionalityTest;
import com.microservice.administrative.shared.domain.FuncionalityId;
import com.microservice.administrative.shared.domain.ModuleId;

import java.util.HashMap;

public final class ModuleTest {
    public static Module create(
            ModuleId id,
            ModuleName name,
            ModuleCreationDate creationDate,
            HashMap<Integer, Funcionality> funcionalityList
    ) {
        return new Module(id, name, creationDate, funcionalityList);
    }
    public static Module create(ModuleId id) {
        HashMap<Integer, Funcionality> funcionalityList = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Funcionality funcionality = FuncionalityTest.random(new FuncionalityId(i));
            funcionalityList.put(funcionality.getId().value(), funcionality);
        }
        return create(
                id,
                ModuleNameTest.random(),
                ModuleCreationDateTest.random(),
                funcionalityList
        );
    }

    public static Module random() {
        HashMap<Integer, Funcionality> funcionalityList = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Funcionality funcionality = FuncionalityTest.random(new FuncionalityId(i));
            funcionalityList.put(funcionality.getId().value(), funcionality);
        }
        return create(
                ModuleIdTest.random(),
                ModuleNameTest.random(),
                ModuleCreationDateTest.random(),
                funcionalityList
        );
    }
}
