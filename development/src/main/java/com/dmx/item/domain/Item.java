package com.dmx.item.domain;

import com.dmx.module.domain.ModuleDTO;
import com.dmx.module.domain.ModuleName;
import com.dmx.module.domain.ModuleTaskCounter;
import com.dmx.module.domain.ModuleTaskState;
import com.dmx.shared.domain.ItemId;
import com.dmx.shared.domain.ModuleId;
import com.dmx.module.domain.Module;

import java.util.Arrays;

public class Item {
    private final ItemId id;
    private final ItemDescription description;
    private final Module[] moduleList;

    public Item(
            ItemId id,
            ItemDescription description,
            Module[] moduleList
    ) {
        this.id = id;
        this.description = description;
        this.moduleList = moduleList;
    }

    static Item create(
            ItemId id,
            ItemDescription description,
            Module[] moduleList
    ) {
        return new Item(
                id,
                description,
                moduleList
        );
    }

    static Item fromPrimitives(ItemDTO data) {
        int lenght = data.moduleList().length;
        Module[] moduleList = new Module[lenght];

        for (int module = 0; module < lenght; module++) {
            ModuleDTO currentModule = data.moduleList()[module];
            moduleList[module] = new Module(
                    new ModuleId(currentModule.id()),
                    new ModuleName(currentModule.name()),
                    new ModuleTaskCounter(currentModule.taskCounter()),
                    new ModuleTaskState(currentModule.taskState())
            );
        }
        return new Item(
                new ItemId(data.id()),
                new ItemDescription(data.description()),
                moduleList
        );
    }

    public ItemId getId() {
        return this.id;
    }

    public ItemDescription getDescription() {
        return this.description;
    }

    public Module[] getModuleList() {
        return this.moduleList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description=" + description +
                ", moduleList=" + Arrays.toString(moduleList) +
                '}';
    }
}
