package com.example.hashmaps.counttriplets;

import java.util.List;

public class Result {

    /* 1, 2, 2, 4
       0, 1, 2, 3

       (0,1), (1,2), (2,2), (3,4)
    */
    static long countTriplets(List<Long> arr, long r) {
        long numberOfTriplets = 0L;

        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    final long entryI = arr.get(i);
                    final long entryJ = arr.get(j);
                    final long entryK = arr.get(k);
                    if (entryJ == entryI * r && entryK == entryJ * r) {
                        numberOfTriplets++;
                    }
                }
            }
        }

        return numberOfTriplets;
    }
}
