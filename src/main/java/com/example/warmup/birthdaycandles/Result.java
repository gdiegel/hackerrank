package com.example.warmup.birthdaycandles;

import java.util.List;

public class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = 0;
        for (Integer candle : candles) {
            if (candle > max)
                max = candle;
        }

        int finalMax = max;
        return Math.toIntExact(candles.stream().filter(integer -> integer == finalMax).count());
    }

}
