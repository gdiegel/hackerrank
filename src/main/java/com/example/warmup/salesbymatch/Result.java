package com.example.warmup.salesbymatch;

import java.util.HashMap;
import java.util.Map;

public class Result {

    static int sockMerchant(int[] sockArray) {
        final Map<Integer, Integer> colorCounter = new HashMap<>();
        for (final int value : sockArray) {
            colorCounter.put(value, colorCounter.getOrDefault(value, 0) + 1);

        }
        System.out.println(colorCounter.entrySet());
        final int pairCount = colorCounter.values().stream()
                .map(integer -> integer / 2)
                .reduce(0, Integer::sum);
        System.out.printf("pairCount is [%d]%n", pairCount);
        return pairCount;
    }

}
