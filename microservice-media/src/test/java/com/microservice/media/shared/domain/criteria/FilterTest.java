package com.microservice.media.shared.domain.criteria;

public final class FilterTest {
    public static Filter create(
            FilterField field,
            FilterOperator operator,
            FilterValue value
    ) {
        return new Filter(field, operator, value);
    }

    public static Filter random() {
        return create(FilterFieldTest.random(), FilterOperatorTest.random(), FilterValueTest.random());
    }
}
