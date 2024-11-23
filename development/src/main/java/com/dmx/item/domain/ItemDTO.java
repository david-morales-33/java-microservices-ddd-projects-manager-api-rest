package com.dmx.item.domain;

import com.dmx.module.domain.ModuleDTO;

import java.util.Arrays;

public record ItemDTO(String id, String description, ModuleDTO[] moduleList) {
    @Override
    public String toString() {
        return "ItemDTO{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", moduleList=" + Arrays.toString(moduleList) +
                '}';
    }
}
