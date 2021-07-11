package com.example.hashmaps.twostrings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void shouldReturnYesWhenContainsSubstringOfLengthOne() {
        assertThat(Result.twoStrings("abc", "adf")).isEqualTo("YES");
    }

    @Test
    void shouldReturnYesWhenContainsSubstringOfLengthTwo() {
        assertThat(Result.twoStrings("abc", "abf")).isEqualTo("YES");
    }

    @Test
    void shouldReturnNoWhenDoesNotContainSubstring() {
        assertThat(Result.twoStrings("abc", "def")).isEqualTo("NO");
    }
}