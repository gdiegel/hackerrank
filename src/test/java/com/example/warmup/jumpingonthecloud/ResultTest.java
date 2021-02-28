package com.example.warmup.jumpingonthecloud;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void shouldReturnTheCorrectNumberOfJumps() {
        var clouds = new int[]{0, 0, 1, 0, 0, 1, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(4);
    }

    @Test
    void shouldReturnTheCorrectNumberOfJumps2() {
        var clouds = new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(5);
    }

    @Test
    void shouldReturnTheCorrectNumberOfJumps3() {
        var clouds = new int[]{0, 0, 0, 1, 0, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(3);
    }

    @Test
    void shouldReturnTheCorrectNumberOfJumpsForMinimumArray() {
        var clouds = new int[]{0, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(1);
    }

    @Test
    void shouldReturnTheLeastAmountOfJumpsWhenOnlyTwoPossibilities() {
        var clouds = new int[]{0, 0, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(1);
    }
}