package com.microservice.media.user.domain;

public interface UserCommandRepository {
    void save(User user);
}
