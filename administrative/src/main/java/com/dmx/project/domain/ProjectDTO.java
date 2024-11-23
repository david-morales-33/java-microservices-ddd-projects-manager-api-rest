package com.dmx.project.domain;

import java.util.Arrays;

public record ProjectDTO(String id, String name, String[] itemList) {
    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemList=" + Arrays.toString(itemList) +
                '}';
    }
}
