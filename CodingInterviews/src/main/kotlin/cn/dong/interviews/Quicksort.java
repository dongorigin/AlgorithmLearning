package cn.dong.interviews;

import java.util.Arrays;

/**
 * @author dong on 2018/10/27.
 */
public class Quicksort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end) return; // recursion exit
        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start; // [start, i-1] 是已处理区域
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, end);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 4, 5};
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
