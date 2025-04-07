package com.microservice.development.module.domain;

import com.microservice.development.funcionality.domain.Funcionality;
import com.microservice.development.funcionality.domain.FuncionalityDTO;
import com.microservice.development.shared.domain.ModuleId;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Module {
    private final ModuleId id;
    private final ModuleName name;
    private final ModuleCreationDate creationDate;
    private ModuleFuncionalitiesCounter funcionalitiesCounter;
    private Map<Integer, Funcionality> funcionalityList;

    public Module(
            ModuleId id,
            ModuleName name,
            ModuleCreationDate creationDate,
            Map<Integer, Funcionality> funcionalityList
    ) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.funcionalitiesCounter = new ModuleFuncionalitiesCounter(funcionalityList.size());
        this.funcionalityList = funcionalityList;
    }

    private Module() {
        this.id = null;
        this.name = null;
        this.creationDate = null;
        this.funcionalityList = new HashMap<>();
        this.funcionalitiesCounter = new ModuleFuncionalitiesCounter(0);
    }

    public static Module fromPrimitives(ModuleDTO data) {
        HashMap<Integer, Funcionality> funcionalityList = new HashMap<>();
        data.funcionalityList().forEach((key, value) -> {
            funcionalityList.put(key, Funcionality.fromPrimitives(value));
        });

        return new Module(
                new ModuleId(data.id()),
                new ModuleName(data.name()),
                new ModuleCreationDate(data.creationDate()),
                funcionalityList
        );
    }

    public ModuleDTO toPrimitives() {
        HashMap<Integer, FuncionalityDTO> funcionalityList = new HashMap<>();
        this.funcionalityList.forEach((key, value) -> {
            funcionalityList.put(key, value.toPrimitives());
        });
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

    public Map<Integer, Funcionality> getFuncionalityList() {
        return this.funcionalityList;
    }

    public void setFuncionalityList(Map<Integer, Funcionality> funcionalityList) {
        this.funcionalityList = funcionalityList;
        this.funcionalitiesCounter = new ModuleFuncionalitiesCounter(funcionalityList.size());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(id, module.id) && Objects.equals(name, module.name) && Objects.equals(creationDate, module.creationDate) && Objects.equals(funcionalitiesCounter, module.funcionalitiesCounter) && Objects.equals(funcionalityList, module.funcionalityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, funcionalitiesCounter, funcionalityList);
    }
}
