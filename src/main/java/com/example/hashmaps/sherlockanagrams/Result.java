package com.example.hashmaps.sherlockanagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.text.MessageFormat.format;

public class Result {

    public static int sherlockAndAnagrams(String s) {
        System.out.println(format("Original string: [{0}]", s));
        final char[] chars = s.toCharArray();
        Map<String, Integer> subStrings = new HashMap<>();

        for (int length = 1; length < chars.length; length++) {
            System.out.println(format("Length: [{0}]", length));
            for (int index = 0; index < chars.length; index++) {
                System.out.println(format("Index: [{0}]", index));
                if (index + length > chars.length) {
                    continue;
                }
                final String candidate = new String(Arrays.copyOfRange(chars, index, index + length));
                System.out.println(format("Candidate: [{0}]", candidate));
                final String s1 = sortString(candidate);
                if (subStrings.containsKey(s1)) {
                    subStrings.computeIfPresent(s1, (key, val) -> val + 1);
                } else {
                    subStrings.put(s1, 1);
                }
            }
        }
        System.out.println(subStrings);
        return 0;
    }

    private static String sortString(String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
