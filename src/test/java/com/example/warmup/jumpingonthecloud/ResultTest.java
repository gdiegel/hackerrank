package com.example.warmup.jumpingonthecloud;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void shouldReturnTheCorrectNumberOfJumps() {
        final int[] clouds = new int[]{0, 0, 1, 0, 0, 1, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(4);
    }

    @Test
    void shouldReturnTheCorrectNumberOfJumps2() {
        final int[] clouds = new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(5);
    }

    @Test
    void shouldReturnTheCorrectNumberOfJumps3() {
        final int[] clouds = new int[]{0, 0, 0, 1, 0, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(3);
    }

    @Test
    void shouldReturnTheCorrectNumberOfJumpsForMinimumArray() {
        final int[] clouds = new int[]{0, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(1);
    }

    @Test
    void shouldReturnTheLeastAmountOfJumpsWhenOnlyTwoPossibilities() {
        final int[] clouds = new int[]{0, 0, 0};
        assertThat(Result.jumpingOnClouds(clouds)).isEqualTo(1);
    }
}