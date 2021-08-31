package com.example.hashmaps.counttriplets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void shouldReturn2ForExampleOne() {
        assertThat(Result.countTriplets(List.of(1L, 2L, 2L, 4L), 2)).isEqualTo(2);
    }

    @Test
    void shouldReturn6ForExampleTwo() {
        assertThat(Result.countTriplets(List.of(1L, 3L, 9L, 9L, 27L, 81L), 3)).isEqualTo(6);
    }
}