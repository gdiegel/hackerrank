package com.example.hashmaps.counttriplets;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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
        ConcurrentMap<Long, List<Integer>> valueToIndices = calculateValueToIndices(arr);
        final Set<Long> keys = valueToIndices.keySet();
        if (keys.size() == 1 && r == 1L) {
            final int n = valueToIndices.values().stream().toList().get(0).size();
            final int k = 3;
            return factorial(n).divide(factorial(n - k).multiply(BigInteger.valueOf(6))).longValue();

        }
        System.out.printf("Keys: %s%n", keys);
        for (final Long i : keys) {
            long j = i * r;
            long k = j * r;
            if (keys.contains(j) && keys.contains(k)) {
                System.out.printf("i,j,k: [%d,%d,%d]%n", i, j, k);
                final List<Integer> listI = valueToIndices.get(i);
                final List<Integer> listJ = valueToIndices.get(j);
                final List<Integer> listK = valueToIndices.get(k);
                numberOfTriplets += findNumberOfTriplets(listI, listJ, listK);
            }
        }
        return numberOfTriplets;
    }

    private static ConcurrentMap<Long, List<Integer>> calculateValueToIndices(List<Long> arr) {
        ConcurrentMap<Long, List<Integer>> valueToIndices = new ConcurrentHashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            final Long key = arr.get(i);
            final int index = i;
            valueToIndices.compute(key, (k, v) -> {
                if (v == null)
                    v = new ArrayList<>();
                v.add(index);
                return v;
            });
        }
        System.out.println(valueToIndices);
        return valueToIndices;
    }

    private static long findNumberOfTriplets(List<Integer> listI, List<Integer> listJ, List<Integer> listK) {
        long numberOfTriplets = 0L;
        for (int i = 0; i < listI.size(); i++) {
            for (int j = 0; j < listJ.size(); j++) {
                for (int k = 0; k < listK.size(); k++) {
                    final long entryI = listI.get(i);
                    final long entryJ = listJ.get(j);
                    final long entryK = listK.get(k);
                    System.out.printf("Checking [%d,%d,%d] at (%d,%d,%d):", entryI, entryJ, entryK, i, j, k);
                    if (entryI < entryJ && entryJ < entryK) {
                        System.out.printf(" TRUE%n");
                        numberOfTriplets++;
                    } else {
                        System.out.printf(" FALSE%n");
                    }
                }
            }
        }
        return numberOfTriplets;
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        System.out.printf("Factorial of %d is %d%n", n, result);
        return result;
    }
}
