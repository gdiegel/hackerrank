package com.example.hashmaps.counttriplets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("UnnecessaryBoxing")
public class Result {

    /**
     * [1,3,9,3,9,2]
     *  0,1,2,3,4,5
     *
     *  n=6 r=3
     *
     *  1=0
     *  2=5
     *  3=1,3
     *  9=2,4
     *
     *  0,1,2
     *  0,1,4
     *  0,3,4
     *
     * [1,3,9,3,1]
     *  0,1,2,3,4
     *
     *  n=5 r=3
     *
     *  1=0,4
     *  3=1,3
     *  9=2
     *
     *  0,1,2
     *
     *  For each triplet of keys with common ratio r create combinatorically the set of all triplets of indices
     *  that are strictly increasing.
     */
    static long countTriplets(List<Long> arr, long r) {
        long numberOfTriplets = 0L;
        final Map<Long, List<Long>> keyIndices = calculateKeyIndices(arr, r);
        final Map<Long, List<Long>> relevantKeyIndices = calculateRelevantKeyIndices(keyIndices, r);
        return numberOfTriplets;
    }

    private static Map<Long, List<Long>> calculateKeyIndices(List<Long> arr, long r) {
        final long start = System.nanoTime();
        Map<Long, List<Long>> keyIndices = new ConcurrentHashMap<>(0);
        final int size = arr.size();
        for (int i = 0; i < size; i++) {
            final Long key = arr.get(i);
            final long index = i;
            keyIndices.compute(key, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>(0);
                }
                v.add(index);
                return v;
            });
        }
        System.out.printf("Calculating key indices took [%d ms]%n", (System.nanoTime() - start) / 1000 / 1000);
        return keyIndices;
    }

    private static Map<Long, List<Long>> calculateRelevantKeyIndices(Map<Long, List<Long>> keyIndices, long r) {
        final Map<Long, List<Long>> relevantKeyIndices = new ConcurrentHashMap<>(0);

        final long start = System.nanoTime();
        keyIndices.forEach((key, indices) -> {
            if (keyIndices.containsKey(key * r) && keyIndices.containsKey(key * r * r) ||
                keyIndices.containsKey(key / r) && keyIndices.containsKey(key * r) ||
                keyIndices.containsKey(key / r / r) && keyIndices.containsKey(key / r)) {
                relevantKeyIndices.put(key, indices);
            }
        });
        System.out.println(relevantKeyIndices);
        System.out.printf("Calculating relevant key indices took [%d ms]%n", (System.nanoTime() - start) / 1000 / 1000);
        return relevantKeyIndices;
    }

    private static class Triplet<U> {
        private final U first;
        private final U second;
        private final U third;

        private Triplet(U first, U second, U third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public U getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        public U getThird() {
            return third;
        }
    }
}
