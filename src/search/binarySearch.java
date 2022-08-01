package search;

public class binarySearch {
    public int search(int[] nums, int target) {
        // 二分查找，时间复杂度O(logn),空间复杂度O(1)
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else return mid;
        }
        return -1;
    }

    /*
     * 找两个有序数组中的中位数
     * 题目名称：4. 寻找两个正序数组的中位数
     * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 方法一：合并两个有序数组，然后进行二分查找。主要是合并的方法（采用归并法）
        // 时间复杂度O(m+n),空间复杂度O(m+n)
        int[] nums = new int[nums1.length + nums2.length];
        // 用两个指针标记两个数组的位置
        int p1 = 0, p2 = 0, i = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] <= nums2[p2]) {
                nums[i++] = nums1[p1++];
            } else {
                nums[i++] = nums2[p2++];
            }
        }
        while (p1 < nums1.length) {
            nums[i++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            nums[i++] = nums2[p2++];
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + " ");
        }
        int mid = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (double) (nums[mid] + nums[mid - 1]) / (double) 2;
        }
        return nums[mid];

        // 如果想要将时间复杂度降低到O(log(m+n))呢？不进行归并的方法
    }
}
