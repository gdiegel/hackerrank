package com.example.sorting.markandtoys;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void maximumToys1234() {
        assertThat(Result.maximumToys(List.of(1, 2, 3, 4), 7)).isEqualTo(3);
    }

    @Test
    void maximumToys1125111200100010() {
        assertThat(Result.maximumToys(List.of(1, 12, 5, 111, 200, 1000, 10), 50)).isEqualTo(4);
    }
}