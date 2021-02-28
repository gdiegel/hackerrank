package com.example.warmup.jumpingonthecloud;

public class Result {

    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;
        if (c.length == 2 || c.length == 3) {
            return 1;
        }

        while (i < c.length - 1) {
            if (canJumpTwo(c, i)) {
                i += 2;
            } else {
                i += 1;
            }
            jumps++;
        }

        return jumps;
    }

    private static boolean canJumpTwo(int[] c, int i) {
        return atNextToLastCloud(c, i) && c[i + 2] == 0;
    }

    private static boolean atNextToLastCloud(int[] c, int i) {
        return i < c.length - 2;
    }
}
