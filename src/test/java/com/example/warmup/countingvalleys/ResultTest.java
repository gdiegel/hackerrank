package com.example.warmup.countingvalleys;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    public void ShouldReturnCorrectNumberOfValleys() {
        var string = "UDDDUDUU";
        assertThat(Result.countingValleys(string.length(), string)).isEqualTo(1);
    }
}