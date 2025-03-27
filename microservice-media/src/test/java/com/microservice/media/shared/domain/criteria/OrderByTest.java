package com.microservice.media.shared.domain.criteria;

import com.microservice.media.shared.domain.WordTest;

public final class OrderByTest {
    public static OrderBy random(){
        return new OrderBy(WordTest.random());
    }
}
