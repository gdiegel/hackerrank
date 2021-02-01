package com.example.warmup.countingvalleys;

public class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int altitude = 0;
        int numberOfValleys = 0;
        for (int i = 0; i < steps; i++) {
            System.out.println("Current altitude: " + altitude);
            final char c = path.charAt(i);
            if (c == 'D') {
                altitude--;
                System.out.println("\\");
            } else {
                altitude++;
                System.out.println("/");
            }
            if (c == 'U' && altitude == 0) {
                numberOfValleys++;
            }
        }
        System.out.println(numberOfValleys);
        return numberOfValleys;
    }
}
