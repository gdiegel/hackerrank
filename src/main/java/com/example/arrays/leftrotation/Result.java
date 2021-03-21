package com.example.arrays.leftrotation;

public class Result {
    static int[] rotLeft(int[] a, int d) {
        if (d == a.length) {
            return a.clone();
        }

        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int newIndex = i - d;
            if (newIndex < 0) {
                newIndex += a.length;
            }
            temp[newIndex] = a[i];
        }

        return temp;
    }
}
