package com.microservice.administrative.shared.domain.criteria;

import com.microservice.administrative.shared.domain.WordTest;

public final class OrderByTest {
    public static OrderBy random(){
        return new OrderBy(WordTest.random());
    }
}
