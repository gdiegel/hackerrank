package com.example.warmup.repeatedstring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void ShouldReturnCorrectNumberOfAsWhenNoRemainder() {
        final String s = "abcac";
        final long n = 10L;
        assertThat(Result.repeatedString(s, n)).isEqualTo(4L);
    }

    @Test
    void ShouldReturnCorrectNumberOfAsWhenRemainderContainsAs() {
        final String s = "abcac";
        final long n = 14L;
        assertThat(Result.repeatedString(s, n)).isEqualTo(6L);
    }

    @Test
    void ShouldReturnCorrectNumberOfAsWhenRemainderDoesNotContainsAs() {
        final String s = "dbaca";
        final long n = 12L;
        assertThat(Result.repeatedString(s, n)).isEqualTo(4L);
    }

    @Test
    void ShouldReturnCorrectNumberOfAsWhenSingleChar() {
        final String s = "a";
        final long n = 1000000000000L;
        assertThat(Result.repeatedString(s, n)).isEqualTo(1000000000000L);
    }
}