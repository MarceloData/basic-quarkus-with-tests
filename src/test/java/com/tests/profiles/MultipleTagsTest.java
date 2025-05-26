package com.tests.profiles;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(Profiles.MultipleTags.class)
public class MultipleTagsTest {

    @Test
    public void test() {
        // test something
    }
}
