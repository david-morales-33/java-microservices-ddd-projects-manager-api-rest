package com.microservice.media.space.application.find;

import com.microservice.media.space.domain.SpaceDTO;
import com.microservice.media.space.domain.SpaceTest;

public final class SpaceResponseTest {
    public static SpaceResponse create(SpaceDTO spaceDTO){
        return new SpaceResponse(spaceDTO);
    }

    public static SpaceResponse random(){
        return create(SpaceTest.random().toPrimitives());
    }
}
