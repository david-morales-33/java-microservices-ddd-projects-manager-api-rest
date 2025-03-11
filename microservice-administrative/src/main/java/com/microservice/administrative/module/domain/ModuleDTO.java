package com.microservice.administrative.module.domain;

import com.microservice.administrative.funcionality.domain.FuncionalityDTO;

import java.util.HashMap;

public record ModuleDTO(
        int id,
        String name,
        String creationDate,
        int funcionalitiesCounter,
        HashMap<Integer, FuncionalityDTO> funcionalityList
) {
}
