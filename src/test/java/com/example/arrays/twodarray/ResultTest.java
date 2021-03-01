package com.example.arrays.twodarray;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void ShouldReturnCorrectHourglassSum() {
        int[][] arr = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        assertThat(Result.hourglassSum(arr)).isEqualTo(7);
    }

    @Test
    void ShouldReturnCorrectHourglassSumInComplexArray() {
        int[][] arr = new int[][]{
                {-9, -9, -9, 1, 1, 1,},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        assertThat(Result.hourglassSum(arr)).isEqualTo(28);
    }
}