package com.example.warmup.countingvalleys;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void ShouldReturnCorrectNumberOfValleys() {
        final String path = "UDDDUDUU";
        assertThat(Result.countingValleys(path)).isEqualTo(1);
    }
}