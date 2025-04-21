package com.microservice.media.shared.infrastructure.bus.query;

public class QueryHandlerExecutionError extends RuntimeException {
    public QueryHandlerExecutionError(Throwable cause) {
        super(cause);
    }
}
