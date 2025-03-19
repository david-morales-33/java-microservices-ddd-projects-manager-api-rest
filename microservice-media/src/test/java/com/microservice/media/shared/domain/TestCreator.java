package com.microservice.media.shared.domain;

import com.github.javafaker.Faker;

public final class TestCreator {
    private final static Faker faker = new Faker();

    public static Faker random(){
        return faker;
    }
}
