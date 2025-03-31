package com.microservice.administrative.shared.domain.criteria;

import com.microservice.administrative.shared.domain.EnumTest;

public final class FilterOperatorTest {
    public static FilterOperator random(){
        return EnumTest.random(FilterOperator.class);
    }
}
