package com.microservice.media.team.domain;

import java.util.function.Supplier;

public final class TeamSupplier implements Supplier<Team> {
    @Override
    public Team get() {
        return TeamTest.random();
    }
}
