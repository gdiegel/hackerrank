package com.example.hashmaps.counttriplets;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Result {

    /**
     *
     * [1, 3, 9, 9, 27, 81]
     *  0, 1, 2, 3,  4,  5
     *
     * 1=[0],
     * 3=[1],
     * 9=[2,3],
     * 27=[4]
     * 81=[5],
     *
     * 0,1,2
     * 0,1,3
     * 1,2,4
     * 1,3,4
     * 2,4,5
     * 3,4,5
     *
     * 81=5
     * 27=4 Map contains key 27*r and 27*r*r?
     * 9=3 Map contains key 9*r and 9*r*r? Yes -> Get indices for both
     * Get all ascending triplets from current index and indices of j and k
     * Save triplet of indices 3,4,5
     * 9=3,2 Map contains key 9*r and 9*r*r? Yes -> Get indices for both
     * Get all ascending triplets from current index and indices of j and k
     * Save 2,4,5
     * 3=1 Map contains key 3*r and 3*r*r? Yes -> Get indices for both
     * 9=3,2
     * 27=4
     * Get all ascending triplets from current index and indices of j and k
     * Save 1,3,4, 1,2,4
     */
    static long countTriplets(List<Long> arr, long r) {
        final Set<List<Long>> keyIndices = calculateKeyIndices(arr, r);
        return keyIndices.size();
    }

    private static Set<List<Long>> calculateKeyIndices(List<Long> arr, long r) {
        final Map<Long, Set<Long>> keyIndices = new ConcurrentHashMap<>(0);
        final Set<List<Long>> known = new HashSet<>(0);
        final int size = arr.size();
        for (int i = size - 1; i >= 0; i--) {
            final Long key = arr.get(i);
            final long index = i;
            keyIndices.compute(key, (k, v) -> {
                if (v == null) {
                    v = new HashSet<>(0);
                }
                v.add(index);
                return v;
            });
            if (keyIndices.containsKey(key * r) && keyIndices.containsKey(key * r * r)) {
                final Set<Long> jIndices = keyIndices.get(key * r);
                final Set<Long> kIndices = keyIndices.get(key * r * r);
                for (Long j : jIndices) {
                    for (Long k : kIndices) {
                        if (j > index && k > j) {
                            known.add(List.of(index, j, k));
                        }
                    }
                }
            }
        }
        return known;
    }
}
