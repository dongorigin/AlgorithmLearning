package cn.dong.interviews;

/**
 * @author dong on 2018/10/27.
 */
public class TopK {
    public static int topK(int[] numbers, int k) {
        if (numbers == null || k < 0 || k >= numbers.length) {
            throw new IllegalArgumentException("numbers is null or k out of bounds");
        }
        int start = 0;
        int end = numbers.length - 1;
        int pivot = partition(numbers, start, end);
        while (pivot + 1 != k) {
            if (pivot + 1 > k) {
                pivot = partition(numbers, start, pivot - 1);
            } else {
                // pivot + 1 < k
                pivot = partition(numbers, pivot + 1, end);
            }
        }
        return numbers[pivot];
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
    }
}
