package com.microservice.media.shared.domain.criteria;

public final class OrderTest {
    public static Order create(OrderBy orderBy, OrderType orderType) {
        return new Order(orderBy, orderType);
    }

    public static Order random() {
        return create(OrderByTest.random(), OrderTypeTest.random());
    }
}
