package com.example.arrays.minimumswapstwo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void ShouldReturnZeroSwapsForMinimalArray() {
        final int[] clouds = new int[]{1};
        assertThat(Result.minimumSwaps(clouds)).isEqualTo(0);
    }

    @Test
    void ShouldReturnZeroSwapsForSortedTwoArray() {
        final int[] clouds = new int[]{1, 2};
        assertThat(Result.minimumSwaps(clouds)).isEqualTo(0);
    }

    @Test
    void ShouldReturnOneSwapForUnsortedTwoArray() {
        final int[] clouds = new int[]{2, 1};
        assertThat(Result.minimumSwaps(clouds)).isEqualTo(1);
    }

    @Test
    void ShouldReturnThreeSwapsForUnsortedFourArray() {
        final int[] clouds = new int[]{4, 3, 1, 2};
        assertThat(Result.minimumSwaps(clouds)).isEqualTo(3);
    }

    @Test
    void ShouldReturnThreeSwapsForUnsortedSevenArray() {
        final int[] clouds = new int[]{1, 3, 5, 2, 4, 6, 7};
        assertThat(Result.minimumSwaps(clouds)).isEqualTo(3);
    }

    @Test
    void ShouldReturnFiveSwapsForUnsortedSevenArray() {
        final int[] clouds = new int[]{7, 1, 3, 2, 4, 5, 6};
        assertThat(Result.minimumSwaps(clouds)).isEqualTo(5);
    }
}