package com.microservice.administrative.user.application.find;

import com.microservice.administrative.shared.domain.Service;
import com.microservice.administrative.shared.domain.UserId;
import com.microservice.administrative.user.domain.User;
import com.microservice.administrative.user.domain.UserNotFindException;
import com.microservice.administrative.user.domain.UserQueryRepository;

import java.util.Optional;

@Service
public final class UserFinder {

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
