package com.example.arrays.leftrotation;

import org.junit.jupiter.api.Test;

import static com.example.arrays.leftrotation.Result.rotLeft;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void canRotateArrayByOne() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        assertThat(rotLeft(array, 1)).containsExactly(2, 3, 4, 5, 1);
    }

    @Test
    void canRotateArrayByFour() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        assertThat(rotLeft(array, 4)).containsExactly(5, 1, 2, 3, 4);
    }

    @Test
    void canRotateArrayByFive() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        assertThat(rotLeft(array, 5)).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void canRotateArrayOfOneByOne() {
        int[] array = new int[]{1};
        assertThat(rotLeft(array, 1)).containsExactly(1);
    }

}