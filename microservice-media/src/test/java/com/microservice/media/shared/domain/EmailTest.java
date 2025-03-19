package com.microservice.media.shared.domain;

public final class EmailTest {
    public static String random(){
        return TestCreator.random().internet().emailAddress();
    }
}
