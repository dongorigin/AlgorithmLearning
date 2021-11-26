package cn.dong.interviews;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author dong on 2018/10/27.
 */
public class TopK {
    public static int topK(int[] numbers, int k) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers is null");
        }
        if (k < 0 || k >= numbers.length) {
            throw new IllegalArgumentException("k out of bounds");
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            final int pivot = partition(numbers, start, end);
            if (pivot + 1 == k) {
                return numbers[pivot];
            } else if (pivot + 1 > k) {
                end = pivot - 1;
            } else { // pivot + 1 < k
                start = pivot + 1;
            }
        }
        throw new IllegalStateException("unreachable code, top k not found");
    }

    private static int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int i = start; // [start, i-1] 的区间是大于 pivot 的元素
        for (int j = start; j < end; j++) {
            if (numbers[j] > pivot) {
                swap(numbers, i, j);
                i++;
            }
        }
        swap(numbers, i, end);
        return i;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {5, 4, 9, 11, 6, 3, 8};
        System.out.println(topK(input, 3));

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/TopK.txt"));
            String[] inputs = reader.readLine().split(",");
            int[] numbers = Arrays.stream(inputs)
                    .mapToInt(s -> Integer.parseInt(s.trim()))
                    .toArray();
            int k = Integer.parseInt(reader.readLine());
            int expect = Integer.parseInt(reader.readLine());
            int actual = topK(numbers, k);
            System.out.println(String.format("expect=%s, actual=%s", expect, actual));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
