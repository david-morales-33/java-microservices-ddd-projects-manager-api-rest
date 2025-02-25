package com.microservice.development.shared.domain.bus.query;

public final class QueryHandlerExecutionException extends RuntimeException {
    public QueryHandlerExecutionException(Throwable message) {
        super(message);
    }
}
