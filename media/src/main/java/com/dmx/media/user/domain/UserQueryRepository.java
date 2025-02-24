package com.dmx.media.user.domain;


import java.util.List;
import java.util.Optional;

import com.dmx.media.shared.domain.UserId;

public interface UserQueryRepository {
    Optional<User> find(UserId userId);

    List<User> searchAll();
}
