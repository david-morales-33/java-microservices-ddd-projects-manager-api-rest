package com.microservice.media.shared.domain.criteria;

import com.microservice.media.shared.domain.EnumTest;

public final class OrderTypeTest {
    public static OrderType random(){
        return EnumTest.random(OrderType.class);
    }

    public static void main(String[] args) {
        System.out.println(random().value());
    }
}
