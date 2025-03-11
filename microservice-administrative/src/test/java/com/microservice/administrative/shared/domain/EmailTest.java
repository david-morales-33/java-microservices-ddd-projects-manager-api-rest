package com.microservice.administrative.shared.domain;

public final class EmailTest {
    public static String random(){
        return TestCreator.random().internet().emailAddress();
    }
}
