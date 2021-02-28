package com.example.warmup.salesbymatch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void ShouldReturnCorrectNumberOfPairs() {
        final int[] colors = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        assertThat(Result.sockMerchant(colors)).isEqualTo(3);
    }
}