package com.example.hashmaps.twostrings;

import java.util.HashSet;
import java.util.Set;

public class Result {

    static String twoStrings(String s1, String s2) {
        boolean containsSubString = false;
        final Set<Character> map = new HashSet<>();
        for (final char c : s1.toCharArray()) {
            map.add(c);
        }

        for (final char c : s2.toCharArray()) {
            if (map.contains(c)) {
                containsSubString = true;
                break;
            }
        }
        return containsSubString ? "YES" : "NO";
    }

}
