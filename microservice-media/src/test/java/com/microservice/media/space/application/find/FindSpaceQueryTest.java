package com.microservice.media.space.application.find;

import com.microservice.media.shared.domain.UuidTest;

public final class FindSpaceQueryTest {
    public static FindSpaceQuery create(String spaceId){
        return new FindSpaceQuery(spaceId);
    }

    public static FindSpaceQuery random(){
        return create(UuidTest.random());
    }
}
