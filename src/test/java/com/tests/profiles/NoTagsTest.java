package com.tests.profiles;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(Profiles.NoTags.class)
public class NoTagsTest {

    @Test
    public void test() {

    }
}
