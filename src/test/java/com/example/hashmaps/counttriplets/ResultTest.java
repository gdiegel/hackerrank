package com.example.hashmaps.counttriplets;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    private static final Pattern COMPILE = Pattern.compile("\\s+$");

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
    void shouldReturn3ForExampleFive() {
        assertThat(Result.countTriplets(List.of(1L, 3L, 9L, 3L, 9L, 2L), 3)).isEqualTo(3);
    }

    @Test
    void shouldPerformBigTestcase3InTime() throws IOException {
        assertThat(countTripletsInFile("input03.txt")).isEqualTo(166661666700000L);
    }

    @Test
    void shouldPerformBigTestcase06InTime() throws IOException {
        assertThat(countTripletsInFile("input06.txt")).isEqualTo(2325652489L);
    }

    @Test
    void shouldPerformBigTestcase11InTime() throws IOException {
        assertThat(countTripletsInFile("input11.txt")).isEqualTo(1667018988625L);
    }

    private long countTripletsInFile(String fileName) throws IOException {
        final InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        final String[] nr = COMPILE.matcher(bufferedReader.readLine()).replaceAll("").split(" ");

        final long r = Long.parseLong(nr[1]);

        final List<Long> arr = Stream.of(COMPILE.matcher(bufferedReader.readLine()).replaceAll("").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        return Result.countTriplets(arr, r);
    }

}