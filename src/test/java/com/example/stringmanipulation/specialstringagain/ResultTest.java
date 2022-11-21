package com.example.stringmanipulation.specialstringagain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void shouldReturnTrueForStringOfLengthOneWhereEveryCharIsTheSame() {
        assertThat(Result.isSpecialString("a")).isTrue();
    }

    @Test
    void shouldReturnTrueForStringOfLengthTwoWhereEveryCharIsTheSame() {
        assertThat(Result.isSpecialString("aa")).isTrue();
    }

    @Test
    void shouldReturnTrueForpalindromOfLengthThree() {
        assertThat(Result.isSpecialString("aba")).isTrue();
    }

    @Test
    void shouldReturnTrueForpalindromOfLengthFive() {
        assertThat(Result.isSpecialString("aabaa")).isTrue();
    }

    @Test
    void shouldReturnFalseForStringOfLengthTwoWhereNotEveryCharIsTheSame() {
        assertThat(Result.isSpecialString("ab")).isFalse();
    }

    @Test
    void shouldReturnSetOfOneForStringOfLengthOne() {
        assertThat(Result.findSubstrings(1, "a")).containsExactly("a");
    }

    @Test
    void shouldReturnSetOfThreeForStringOfLengthTwo() {
        assertThat(Result.findSubstrings(2, "ab")).containsExactlyInAnyOrder("a", "b", "ab");
    }

    @Test
    void shouldReturnSetOfSixForStringOfLengthThree() {
        assertThat(Result.findSubstrings(3, "abc")).containsExactlyInAnyOrder("a", "b", "c", "ab", "bc", "abc");
    }

    @Test
    void shouldReturn7ForExample1() {
        Assertions.assertThat(Result.substrCount(5, "asasd")).isEqualTo(7);
    }

    @Test
    void shouldReturn10ForExample2() {
        Assertions.assertThat(Result.substrCount(7, "abcbaba")).isEqualTo(10);
    }

}