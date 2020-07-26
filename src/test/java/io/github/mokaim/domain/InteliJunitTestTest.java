package io.github.mokaim.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InteliJunitTestTest {

    @Test
    void builder() {

        InteliJunitTest inteliJunitTest = InteliJunitTest.builder().id("test").name("kwon").build();
        String id = inteliJunitTest.getId();
        String name = inteliJunitTest.getName();

        assertEquals("test", id);
    }
}