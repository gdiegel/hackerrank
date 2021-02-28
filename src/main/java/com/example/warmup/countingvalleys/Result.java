package com.example.warmup.countingvalleys;

public class Result {

    public static int countingValleys(String path) {
        int altitude = 0;
        int numberOfValleys = 0;
        for (int i = 0; i < path.length(); i++) {
            final char c = path.charAt(i);
            if (c == 'D') {
                altitude--;
            } else {
                altitude++;
            }
            if (c == 'U' && altitude == 0) {
                numberOfValleys++;
            }
        }
        return numberOfValleys;
    }
}
