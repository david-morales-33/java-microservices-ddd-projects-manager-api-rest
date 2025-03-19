package com.microservice.media.shared.domain;

import java.util.UUID;

public final class UuidTest {
    public static  String random(){
        return UUID.randomUUID().toString();
    }
}
