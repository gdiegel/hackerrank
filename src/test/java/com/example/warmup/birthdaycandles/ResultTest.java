package com.example.warmup.birthdaycandles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResultTest {

    @Test
    void birthdayCakeCandles() {
        Assertions.assertThat(Result.birthdayCakeCandles(List.of(3, 2, 1, 3))).isEqualTo(2);
    }
}