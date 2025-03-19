package com.microservice.media.shared.domain;

public final class BooleanTest {
    public static Boolean random(){
        return TestCreator.random().bool().bool();
    }
}
