package com.example.hashmaps.counttriplets;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
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

    @Test
    void shouldReturn1ForExampleThree() {
        assertThat(Result.countTriplets(List.of(1L, 3L, 9L, 3L, 1L), 3)).isEqualTo(1);
    }

    @Test
    void shouldReturn4ForExampleFour() {
        assertThat(Result.countTriplets(List.of(1L, 1L, 1L, 1L), 1)).isEqualTo(4);
    }

    @Test
    void should() throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("input03.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = Result.countTriplets(arr, r);

        assertThat(ans).isEqualTo(166661666700000L);
    }

}