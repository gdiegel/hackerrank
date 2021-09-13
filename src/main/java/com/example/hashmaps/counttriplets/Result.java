package com.example.hashmaps.counttriplets;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Result {

    /*
    [1,1,1,1,1]
     0,1,2,3,4
    Checking [1,1,1] at (0,1,2): TRUE
    Checking [1,1,1] at (0,1,3): TRUE
    Checking [1,1,1] at (0,2,3): TRUE
    Checking [1,1,1] at (1,2,3): TRUE

    1=0,1,2,3,4
    0,1,2, 0,1,3, 0,1,4, 0,2,3, 0,2,4, 0,3,4, 1,2,3, 1,2,4, 1,3,4, 2,3,4

    1 (1,1)

    [1,2,2,4]
     0,1,2,3
    Checking [1,2,2] at (0,1,2): FALSE
    Checking [1,2,4] at (0,1,3): TRUE
    Checking [1,2,4] at (0,2,3): TRUE
    Checking [2,2,4] at (1,2,3): FALSE

    1=0
    2=1,2
    4=3
    1 (2,4): 1*2*1=2 (for values 0, 1,2 and 3 find combinatory triplets where i < j < k)

    [1,3,9,3,1]
     0,1,2,3,4
    Checking [1,3,9] at (0,1,2): TRUE
    Checking [1,3,3] at (0,1,3): FALSE
    Checking [1,3,1] at (0,1,4): FALSE
    Checking [1,9,3] at (0,2,3): FALSE
    Checking [1,9,1] at (0,2,4): FALSE
    Checking [1,3,1] at (0,3,4): FALSE
    Checking [3,9,3] at (1,2,3): FALSE
    Checking [3,9,1] at (1,2,4): FALSE
    Checking [3,3,1] at (1,3,4): FALSE
    Checking [9,3,1] at (2,3,4): FALSE

    1=0,4
    3=1,3
    9=2

    1 (3,9): 0,1,2 (i < j < k) (for values i=0,4, j=1,3 and k=2 find combinatory triples where i<j<k)

    [1,3,9,3,9,2]
     0,1,2,3,4,5

     1=0
     2=5
     3=1,3
     9=2,4

     1 (3,9): 0, 1,3, 2,4 (for values i=0, j=1,3 and k=2,4 find combinatory triplets where i<j<k):

     0,1,2
     0,1,4
     0,3,4

    */
    static long countTriplets(List<Long> arr, long r) {
        long numberOfTriplets = 0L;
        final Map<Long, List<Long>> valueToIndices = calculateValueToIndices(arr);
        if (valueToIndices.size() == 1 && r == 1L) {
            final int n = valueToIndices.values().stream().toList().get(0).size();
            final int k = 3;
            return factorial(n).divide(factorial(n - k).multiply(BigInteger.valueOf(6))).longValue();

        }
        final Set<Long> keys = valueToIndices.keySet();
        for (final long i : keys) {
            long j = i * r;
            long k = j * r;
            if (keys.contains(j) && keys.contains(k)) {
                /*
                [9,3,1,1,3,9]
                 0,1,2,3,4,5

                1=2,3
                3=1,4
                9=0,5

                2,3,5, 2,4,5

                We can eliminate i > max(k) and j > max(k)
                 */
                final List<Long> listI = valueToIndices.get(i);
                final List<Long> listJ = valueToIndices.get(j);
                final List<Long> listK = valueToIndices.get(k);
                final long minI = listI.stream().min(Comparator.naturalOrder()).get();
                final long minJ = listJ.stream().min(Comparator.naturalOrder()).get();
                final long maxK = listK.stream().max(Comparator.naturalOrder()).get();
                final List<Long> optimizedListI = listI.parallelStream()
                    .sorted()
                    .filter(aLong -> aLong < maxK)
                    .collect(Collectors.toList());
                final List<Long> optimizedListJ = listJ.parallelStream()
                    .sorted()
                    .filter(aLong -> aLong < maxK)
                    .filter(aLong -> aLong > minI)
                    .collect(Collectors.toList());
                final List<Long> optimizedListK = listK.parallelStream()
                    .sorted()
                    .filter(aLong -> aLong > minJ)
                    .collect(Collectors.toList());
                numberOfTriplets += findNumberOfTriplets(optimizedListI, optimizedListJ, optimizedListK);
            }
        }
        return numberOfTriplets;
    }

    private static Map<Long, List<Long>> calculateValueToIndices(List<Long> arr) {
        Map<Long, List<Long>> valueToIndices = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            final Long key = arr.get(i);
            final long index = i;
            valueToIndices.compute(key, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(index);
                return v;
            });
        }
        System.out.println(valueToIndices);
        return valueToIndices;
    }

    private static long findNumberOfTriplets(List<Long> listI, List<Long> listJ, List<Long> listK) {
        System.out.println(listI);
        System.out.println(listJ);
        System.out.println(listK);
        long numberOfTriplets = 0L;
        for (Long entryI : listI) {
            for (Long entryJ : listJ) {
                for (Long entryK : listK) {
                    if (entryI < entryJ && entryJ < entryK) {
                        numberOfTriplets++;
                    }
                }
            }
        }
        return numberOfTriplets;
    }

    private static BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
