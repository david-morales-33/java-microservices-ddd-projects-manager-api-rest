package com.microservice.administrative.shared.domain;

public final class BooleanTest {
    public static Boolean random(){
        return TestCreator.random().bool().bool();
    }
}
