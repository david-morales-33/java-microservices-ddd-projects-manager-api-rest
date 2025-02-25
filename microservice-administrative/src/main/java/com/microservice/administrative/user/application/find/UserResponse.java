package com.microservice.administrative.user.application.find;

import com.microservice.administrative.shared.domain.bus.query.Response;
import com.microservice.administrative.user.domain.User;
import com.microservice.administrative.user.domain.UserDTO;

public class UserResponse implements Response {
    private final UserDTO response;

    public UserResponse(User response) {
        this.response = response.toPrimitives();
    }

    public UserDTO getResponse() {
        return this.response;
    }
}
