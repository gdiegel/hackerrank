package com.example.sorting.markandtoys;

import java.util.List;

public class Result {

    public static int maximumToys(List<Integer> prices, int k) {
        int sum = 0;
        int numberOfToys = 0;
        for (final var price : prices.stream().sorted().toList()) {
            if (sum + price > k) {
                break;
            }
            sum += price;
            numberOfToys++;
        }

        return numberOfToys;
    }
}