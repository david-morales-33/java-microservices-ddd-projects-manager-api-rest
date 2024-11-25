package com.dmx.administrative.module.domain;

import com.dmx.shared.domain.FuncionalityId;
import com.dmx.shared.domain.ModuleId;

public final class Module {
    private final ModuleId id;
    private final ModuleName name;
    private final ModuleCreationDate creationDate;
    private final ModuleFuncionalitiesCounter funcionalitiesCounter;
    private final FuncionalityId[] funcionalityList;

    public Module(
            ModuleId id,
            ModuleName name,
            ModuleCreationDate creationDate,
            ModuleFuncionalitiesCounter funcionalitiesConuter,
            FuncionalityId[] funcionalityList
    ) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.funcionalitiesCounter = funcionalitiesConuter;
        this.funcionalityList = funcionalityList;
    }

    public static Module fromPrimitives(ModuleDTO data) {
        FuncionalityId[] funcionalityIdList = new FuncionalityId[data.funcionalitiesCounter()];
        for (int funcionalitiesCounter = 0; funcionalitiesCounter < data.funcionalitiesCounter(); funcionalitiesCounter++) {
            funcionalityIdList[funcionalitiesCounter] = new FuncionalityId(data.funcionalityList()[funcionalitiesCounter]);
        }
        return new Module(
                new ModuleId(data.id()),
                new ModuleName(data.name()),
                new ModuleCreationDate(data.creationDate()),
                new ModuleFuncionalitiesCounter(data.funcionalitiesCounter()),
                funcionalityIdList
        );
    }
    public ModuleDTO toPrimitives() {
        String[] funcionalityList = new String[this.funcionalitiesCounter.value()];
        for (int funcionalitiesCounter = 0; funcionalitiesCounter < this.funcionalitiesCounter.value(); funcionalitiesCounter++) {
            funcionalityList[funcionalitiesCounter] = this.funcionalityList[funcionalitiesCounter].value();
        }
        return new ModuleDTO(
                this.id.value(),
                this.name.value(),
                this.creationDate.value(),
                this.funcionalitiesCounter.value(),
                funcionalityList
        );
    }

    public ModuleId getId() {
        return this.id;
    }

    public ModuleName getName() {
        return this.name;
    }

    public ModuleCreationDate getCreationDate() {
        return this.creationDate;
    }

    public ModuleFuncionalitiesCounter getFuncionalitiesCounter() {
        return this.funcionalitiesCounter;
    }

    public FuncionalityId[] getFuncionalityList() {
        return this.funcionalityList;
    }
}
