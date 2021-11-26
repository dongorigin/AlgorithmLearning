package cn.dong.interviews;

import java.util.Arrays;

/**
 * No.21 Make all odd numbers before even numbers
 * use quicksort partition
 *
 * @author dong on 2018/11/05.
 */
public class ReorderArray {

    public static void reorder(int[] nums) {
        int i = 0; // [0, i-1] range is odd
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        reorder(input);
        System.out.println(Arrays.toString(input));
    }
}
