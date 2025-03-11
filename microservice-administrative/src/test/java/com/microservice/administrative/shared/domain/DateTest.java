package com.microservice.administrative.shared.domain;

public final class DateTest {
    public static String random(){
        return  TestCreator.random().date().toString();
    }
}
