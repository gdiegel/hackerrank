package com.example.warmup.jumpingonthecloud;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void shouldReturnTheCorrectNumberOfJumps() {
        var clouds = new int[]{0, 0, 1, 0, 0, 1, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(4);
    }
}