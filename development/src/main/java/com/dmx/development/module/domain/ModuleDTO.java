package com.dmx.development.module.domain;

import com.dmx.development.funcionality.domain.FuncionalityDTO;
import com.dmx.shared.domain.FuncionalityId;
import com.dmx.shared.domain.ModuleId;

import java.util.HashMap;

public record ModuleDTO(
        String id,
        String name,
        String creationDate,
        int funcionalitiesCounter,
        HashMap<String, FuncionalityDTO> funcionalityList
) {
}
