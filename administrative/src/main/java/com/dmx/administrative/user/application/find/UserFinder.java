package com.dmx.administrative.user.application.find;

import com.dmx.administrative.user.domain.User;
import com.dmx.administrative.user.domain.UserNotFindException;
import com.dmx.administrative.user.domain.UserQueryRepository;
import com.dmx.shared.domain.UserId;

import java.util.Optional;

public class UserFinder {

    private final UserQueryRepository queryRepository;

    public UserFinder(UserQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public UserResponse execute(UserId userId) throws UserNotFindException {
        Optional<User> user = this.queryRepository.find(userId);
        if (user.isEmpty()) throw new UserNotFindException(userId);
        return new UserResponse(user.get());
    }
}
