package com.dmx.administrative.user.application.find;

import com.dmx.administrative.user.domain.User;
import com.dmx.administrative.user.domain.UserDTO;
import com.dmx.shared.domain.bus.query.Response;

public class UserResponse implements Response {
    private final UserDTO response;

    public UserResponse(User response) {
        this.response = response.toPrimitives();
    }

    public UserDTO getResponse() {
        return this.response;
    }
}
