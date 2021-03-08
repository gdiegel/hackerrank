package com.example.hashmaps.ransomnote;

import java.util.HashMap;
import java.util.Map;

public class Result {

    static void checkMagazine(String[] magazine, String[] note) {
        boolean possible = true;
        final Map<String, Integer> wordCountMapMagazine = wordCounts(magazine);
        final Map<String, Integer> wordCountMapNote = wordCounts(note);
        for (Map.Entry<String, Integer> entry : wordCountMapNote.entrySet()) {
            if (!wordCountMapMagazine.containsKey(entry.getKey()) || wordCountMapMagazine.containsKey(entry.getKey()) && wordCountMapMagazine.get(entry.getKey()) < entry.getValue()) {
                possible = false;
                break;
            }
        }

        System.out.print(possible ? "Yes" : "No");
    }

    private static Map<String, Integer> wordCounts(String[] magazine) {
        final Map<String, Integer> wordCounts = new HashMap<>();
        for (final String value : magazine) {
            wordCounts.compute(value, (key, val) -> val == null ? 1 : val + 1);
        }
        return wordCounts;
    }
}
