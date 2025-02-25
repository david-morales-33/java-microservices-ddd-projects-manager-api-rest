package com.microservice.administrative.user.domain;

public interface UserCommandRepository {
    void save(User user);
}
