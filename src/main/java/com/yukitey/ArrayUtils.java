package com.yukitey;

import java.util.Arrays;

public class ArrayUtils {
    public int[] sort(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        return copy;
    }
}