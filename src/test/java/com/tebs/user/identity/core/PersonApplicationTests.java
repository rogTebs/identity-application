package com.tebs.user.identity.core;


import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonApplicationTests {

    @SpringBootConfiguration  // ← tells Spring to use this as config
    static class TestConfig {
        // empty, just a marker
    }

    @Test
    void contextLoads() {
    }

}
