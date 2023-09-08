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

    /**
     * 找非降序旋转数组中的最小值
     *
     * @param nums
     * @return
     */
    public int minNumberInRotateArray(int[] nums) {
        // write code here
        // 由于数组由两个递增数组组成，且后面的递增数组的所有值一定小于前面的递增数组的最小值，因此从数组最末一位向前遍历(时间复杂度O(n))
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[right] < nums[mid]) {
                // mid在左边的增序数组中,最小值在mid右边[mid+1,right]
                left = mid + 1;
            } else if (nums[right] > nums[mid]) {
                // mid在右边的增序数组中，最小值在mid的左边或就是mid,[left,mid]
                right = mid;
            } else right--;//如果nums[right]==nums[mid]无法判断最小值在哪边，那么缩小范围
        }
        return nums[left];
    }
}
