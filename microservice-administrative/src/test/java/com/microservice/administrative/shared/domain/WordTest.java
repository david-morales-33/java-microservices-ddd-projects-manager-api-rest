package com.microservice.administrative.shared.domain;

public final class WordTest {
    public static String random(){
        return TestCreator.random().lorem().word();
    }
}
