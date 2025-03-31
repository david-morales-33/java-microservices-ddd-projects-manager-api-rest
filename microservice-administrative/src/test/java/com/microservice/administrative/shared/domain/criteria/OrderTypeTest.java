package com.microservice.administrative.shared.domain.criteria;

import com.microservice.administrative.shared.domain.EnumTest;

public final class OrderTypeTest {
    public static OrderType random(){
        return EnumTest.random(OrderType.class);
    }

    public static void main(String[] args) {
        System.out.println(random().value());
    }
}
