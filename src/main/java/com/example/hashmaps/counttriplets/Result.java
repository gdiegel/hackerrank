package com.example.hashmaps.counttriplets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Result {

    /**
     * [1, 3, 9, 9, 27, 81]
     * 0, 1, 2, 3,  4,  5
     * <p>
     * 1=[0],
     * 3=[1],
     * 9=[2,3],
     * 27=[4]
     * 81=[5],
     * <p>
     * 0,1,2
     * 0,1,3
     * 1,2,4
     * 1,3,4
     * 2,4,5
     * 3,4,5
     * <p>
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
    static long countTriplets(List<Long> array, long r) {
        final Map<Long, List<Long>> keyIndices = new ConcurrentHashMap<>(0);
        final int arrayLength = array.size();
        long numberOfTriplets = 0L;
        for (int i = arrayLength - 1; i >= 0; i--) {
            final long key = array.get(i);
            final long index = i;
            keyIndices.compute(key, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>(0);
                }
                v.add(index);
                return v;
            });
            final long key1 = key * r;
            final long key2 = key * r * r;
            if (!keyIndices.containsKey(key1) || !keyIndices.containsKey(key2)) {
                continue;
            }
            for (final long j : keyIndices.get(key1)) {
                if (j > index) {
                    for (final long k : keyIndices.get(key2)) {
                        if (k > j) {
                            numberOfTriplets++;
                        }
                    }
                }
            }
        }
        return numberOfTriplets;
    }
}
