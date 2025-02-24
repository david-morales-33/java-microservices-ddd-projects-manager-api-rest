package com.dmx.development.module.domain;

import com.dmx.development.funcionality.domain.FuncionalityDTO;

import java.util.HashMap;

public record ModuleDTO(
        int id,
        String name,
        String creationDate,
        int funcionalitiesCounter,
        HashMap<String, FuncionalityDTO> funcionalityList
) {
}
