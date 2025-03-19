package com.microservice.media.space.domain;

import com.microservice.media.shared.domain.DateTest;

public final class SpaceCreationDateTest {
    public static SpaceCreationDate create(String value) {
        return new SpaceCreationDate(value);
    }

    public static SpaceCreationDate random() {
        return create(DateTest.random());
    }

    public static class SpaceUnitTest {



        void it_should_add_a_new_member(){

        }
    }
}
