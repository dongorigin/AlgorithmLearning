package cn.dong.leetcode;

import static org.junit.Assert.assertEquals;

/**
 * @author dong on 2018/11/03.
 */
public class BinarySearch {

    /**
     * @return -1 if target not exists
     */
    public static int searchFirst(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1; // avoid overflow
            int midVal = a[mid];
            if (midVal > target) {
                high = mid - 1;
            } else if (midVal < target) {
                low = mid + 1;
            } else { // midVal == target
                if (mid == 0 || a[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int searchLast(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else { // midVal == target
                if (mid == a.length - 1 || a[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // >= target
    public static int searchFirstGreaterThanOrEqualTo(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (a[mid] >= target) {
                // 这是不是第一个 >= target 的元素？通过判断前一个元素确定。是则命中，否则在前面继续找
                if (mid == 0 || a[mid - 1] < target) {
                    return mid; // hit
                } else {
                    high = mid - 1;
                }
            } else { // < target
                low = mid + 1;
            }
        }
        return -1;
    }

    // <= target
    public static int searchLastLessThanOrEqualTo(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (a[mid] <= target) {
                // 这是不是最后一个 <= target 的元素？通过判断下一个元素确定。是则命中，否则在后面继续找
                if (mid == a.length - 1 || a[mid + 1] > target) {
                    return mid; // hit
                } else {
                    low = mid + 1;
                }
            } else { // > target
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 2, 3, 4, 4, 7};
        assertEquals(0, searchFirst(input, 1));
        assertEquals(1, searchFirst(input, 2));
        assertEquals(5, searchFirst(input, 4));
        assertEquals(7, searchFirst(input, 7));
        assertEquals(-1, searchFirst(input, 0));
        assertEquals(-1, searchFirst(input, 6));

        assertEquals(0, searchLast(input, 1));
        assertEquals(3, searchLast(input, 2));
        assertEquals(6, searchLast(input, 4));
        assertEquals(7, searchLast(input, 7));
        assertEquals(-1, searchLast(input, 0));
        assertEquals(-1, searchLast(input, 6));

        assertEquals(4, searchFirstGreaterThanOrEqualTo(input, 3));
        assertEquals(7, searchFirstGreaterThanOrEqualTo(input, 5));
        assertEquals(0, searchFirstGreaterThanOrEqualTo(input, 0));
        assertEquals(-1, searchFirstGreaterThanOrEqualTo(input, 8));

        assertEquals(4, searchLastLessThanOrEqualTo(input, 3));
        assertEquals(6, searchLastLessThanOrEqualTo(input, 5));
        assertEquals(7, searchLastLessThanOrEqualTo(input, 8));
        assertEquals(0, searchLastLessThanOrEqualTo(input, 1));
        assertEquals(-1, searchLastLessThanOrEqualTo(input, 0));
    }
}
