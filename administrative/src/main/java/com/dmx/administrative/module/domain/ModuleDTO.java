package com.dmx.administrative.module.domain;

import com.dmx.administrative.funcionality.domain.FuncionalityDTO;

import java.util.HashMap;

public record ModuleDTO(
        int id,
        String name,
        String creationDate,
        int funcionalitiesCounter,
        HashMap<String, FuncionalityDTO> funcionalityList
) {
}
