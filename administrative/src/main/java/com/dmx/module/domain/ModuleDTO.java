package com.dmx.module.domain;

import com.dmx.shared.domain.FuncionalityId;
import com.dmx.shared.domain.ModuleId;

public record ModuleDTO(
        String id,
        String name,
        String creationDate,
        int funcionalitiesCounter,
        String[] funcionalityList
) {
}
