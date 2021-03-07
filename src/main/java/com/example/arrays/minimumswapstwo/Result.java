package com.example.arrays.minimumswapstwo;

public class Result {

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int realIndex = -1;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == i + 1) {
                        realIndex = j;
                        break;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[realIndex];
                arr[realIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }
}
