package com.microservice.media.shared.domain;

public final class WordTest {
    public static String random(){
        return TestCreator.random().lorem().word();
    }
}
