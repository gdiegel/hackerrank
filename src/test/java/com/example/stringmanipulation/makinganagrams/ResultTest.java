package com.example.stringmanipulation.makinganagrams;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void makeAnagramCDEABC() {
        assertThat(Result.makeAnagram("cde", "abc")).isEqualTo(4);
    }

    @Test
    void makeAnagramLarge() {
        assertThat(Result.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke")).isEqualTo(30);
    }

    @Test
    void makeAnagramRepeat() {
        assertThat(Result.makeAnagram("abaa", "abc")).isEqualTo(3);

    }

}