package com.microservice.media.shared.domain;

public final class FloatTest {
    public static Float random() {
        return (float) TestCreator.random().number().numberBetween(0, 100) / 100;
    }
}
