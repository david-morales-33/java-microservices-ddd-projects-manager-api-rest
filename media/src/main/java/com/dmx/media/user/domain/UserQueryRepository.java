package com.dmx.media.user.domain;

import com.dmx.shared.domain.UserId;

import java.util.List;
import java.util.Optional;

public interface UserQueryRepository {
    Optional<User> find(UserId userId);

    List<User> searchAll();
}
