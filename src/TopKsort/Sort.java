package TopKsort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 7, 10, 6};
        int k = 4;
        int[] res = new int[k];
        res = getLeastNumbers(nums, k);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        // 排序：时间复杂度O(NlogN),空间复杂度O(k)
        // 拓展：如果数据量非常大，应该如何找Top k数据
        if (k == 0) return new int[0];
        int[] res = new int[k];
        res = QuickSort(arr, 0, arr.length - 1, k - 1);
        return res;
    }

    //方法一：快排，只需要找到k-1下标的值，时间复杂度O(n)，最坏情况下划分n次，空间复杂度O(n)
    public static int[] QuickSort(int[] nums, int left, int right, int k) {
        //一次分区
        int i = partition(nums, left, right);
        if (i == k) {
            return Arrays.copyOf(nums, i + 1);
        }
        return i > k ? QuickSort(nums, left, i - 1, k) : QuickSort(nums, i + 1, right, k);
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (pivot < nums[j] && i < j) j--;
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (pivot > nums[i] && i < j) i++;
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
            nums[i] = pivot;
        }
        return i;
    }

    //方法二：堆排序
    //大根堆（找前k小），小根堆（找前k大）
}
