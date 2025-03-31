package com.microservice.administrative.shared.domain.criteria;

import java.util.function.Supplier;

public final class FilterSupplier implements Supplier<Filter> {
    @Override
    public Filter get() {
        return FilterTest.random();
    }
}
