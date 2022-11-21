package com.example.stringmanipulation.specialstringagain;

import java.util.*;

public class Result {

    private static final Set<String> SPECIAL = new HashSet<>();

    static long substrCount(int n, String s) {
        return findSubstrings(n, s).stream()
                .filter(Result::isSpecialString)
                .count();
    }

    /**
     * n = 4
     * 0123
     * abcd
     */
    static List<String> findSubstrings(int n, String s) {
        System.out.printf("Input: %s%n", s);
        final List<String> subStrings = new ArrayList<>();

        for (int i = 0; i <= n - 1; i++) {
            for (int j = i; j <= n - 1; j++) {
                System.out.printf("Char at i (%d): %s%n", i, s.charAt(i));
                System.out.printf("Char at j (%d): %s%n", j, s.charAt(j));
                final String substring = s.substring(i, j + 1);
                System.out.printf("Substring from i (%d) to j (%d): %s%n", i, j, substring);
                subStrings.add(substring);
            }
        }
        System.out.printf("Substrings of [%s]: %s%n", s, subStrings);
        return subStrings;
    }

    static boolean isSpecialString(String s) {
        if (s == null || s.isBlank()) {
            return false;
        }

        if (SPECIAL.contains(s)) {
            return true;
        }

        if (s.length() == 1) {
            SPECIAL.add(s);
        } else {
            if (s.length() % 2 != 0) {
                final char[] charArray = s.toCharArray();
                final Set<Character> seen = new HashSet<>();
                for (int i = 0, charArrayLength = charArray.length; i < charArrayLength / 2; i++) {
                    final char chr = charArray[i];
                    final char oppositeChr = charArray[charArrayLength - i - 1];
                    System.out.println(i);
                    System.out.println(chr);
                    System.out.println(oppositeChr);
                    System.out.println();

                    seen.add(chr);
                    seen.add(oppositeChr);
                }
                System.out.println(seen);
                if (seen.size() == 1) {
                    SPECIAL.add(s);
                }
            } else {
                final OptionalInt max = s.chars().max();
                final OptionalInt min = s.chars().min();
                if (max.isPresent() && min.isPresent() && max.getAsInt() == min.getAsInt()) {
                    SPECIAL.add(s);
                }
            }
        }

        return SPECIAL.contains(s);
    }
}
