package com.microservice.media.shared.domain;

public final class IntegerTest {
    public static Integer random(){
        return TestCreator.random().number().randomDigit();
    }
}
