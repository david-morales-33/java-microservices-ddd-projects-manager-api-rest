package com.microservice.media.shared.domain.criteria;

import com.microservice.media.shared.domain.EnumTest;

public final class FilterOperatorTest {
    public static FilterOperator random(){
        return EnumTest.random(FilterOperator.class);
    }
}
