package com.example.arrays.twodarray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Result {

    static int hourglassSum(int[][] arr) {
        final List<Integer> hourglassSums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                hourglassSums.add(sum);
            }
        }
        hourglassSums.sort(Comparator.reverseOrder());

        return hourglassSums.get(0);
    }

}
