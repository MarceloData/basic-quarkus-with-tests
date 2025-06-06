package com.tests.profiles;

import java.util.Set;

import io.quarkus.test.junit.QuarkusTestProfile;

public class Profiles {

    public static class NoTags implements QuarkusTestProfile {

    }

    public static class SingleTag implements QuarkusTestProfile {
        @Override
        public Set<String> tags() {
            return Set.of("test1");
        }
    }

    public static class MultipleTags implements QuarkusTestProfile {
        @Override
        public Set<String> tags() {
            return Set.of("test1", "test2");
        }
    }
}
