package com.example.warmup.repeatedstring;

import java.util.stream.IntStream;

public class Result {

    static long repeatedString(String s, long n) {
        final long numberOfAsInString = getNumberOfAsInString(s);
        long numberOfAs = numberOfAsInString * (n / s.length());
        final long remainder = n % s.length();
        if (remainder != 0) {
            numberOfAs += getNumberOfAsInString(s.substring(0, (int) remainder));
        }
        return numberOfAs;
    }

    private static long getNumberOfAsInString(String s) {
        return (int) IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .filter(c -> c == 'a').count();
    }

}
