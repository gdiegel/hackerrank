package com.example.stringmanipulation.alternatingcharacters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void alternatingCharacters() {
        assertThat(Result.alternatingCharacters("AAAA")).isEqualTo(3);
    }

    @Test
    void alternatingCharacters2() {
        assertThat(Result.alternatingCharacters("ABABABAB")).isEqualTo(0);
    }
}