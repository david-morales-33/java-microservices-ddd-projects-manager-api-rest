package com.dmx.item.domain;

import com.dmx.shared.domain.ItemId;

import java.util.Arrays;

public class Item {
    private final ItemId id;
    private final ItemDescription description;
    private final Module[] moduleList;

    public Item(
            ItemId id,
            ItemDescription description,
            Module[] moduleList
    ){
        this.id = id;
        this.description = description;
        this.moduleList = moduleList;
    }

    static Item create (
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

    static Item fromPrimitives(){

    }
    public ItemId getId() {
        return id;
    }

    public ItemDescription getDescription() {
        return description;
    }

    public Module[] getModuleList() {
        return moduleList;
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
