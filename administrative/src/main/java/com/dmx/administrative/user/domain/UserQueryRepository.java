package com.dmx.administrative.user.domain;

import java.util.List;

public interface UserQueryRepository {
    User find(User user);
    List<User> searchAll();
}
