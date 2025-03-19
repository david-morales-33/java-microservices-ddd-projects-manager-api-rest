package com.microservice.media.shared.domain;

public final class DateTest {
    public static String random(){
        return  TestCreator.random().date().toString();
    }
}
