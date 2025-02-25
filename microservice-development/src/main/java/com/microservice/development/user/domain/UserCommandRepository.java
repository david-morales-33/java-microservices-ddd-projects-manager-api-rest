package com.microservice.development.user.domain;

public interface UserCommandRepository {
    void save(User user);
}
