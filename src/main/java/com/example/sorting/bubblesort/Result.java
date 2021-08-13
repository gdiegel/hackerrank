package com.example.sorting.bubblesort;

import java.util.List;

public class Result {

    public static void countSwaps(List<Integer> a) {
        final Integer[] arr = a.toArray(Integer[]::new);
        int numberOfSwaps = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    numberOfSwaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.%n", numberOfSwaps);
        System.out.printf("First Element: %d%n", arr[0]);
        System.out.printf("Last Element: %d%n", arr[arr.length - 1]);
    }
}