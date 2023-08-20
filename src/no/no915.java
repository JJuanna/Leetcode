package no;

public class no915 {
    // 分割数组
    // 空间复杂度为O(1)的解法
    public int partitionDisjoint(int[] nums) {
        int res = 0;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > left[i - 1]) {
                left[i] = nums[i];
            } else {
                left[i] = left[i - 1];
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < right[i + 1]) {
                right[i] = nums[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (left[i] < right[i + 1]) {
                res = i + 1;
                break;
            }
        }
        return res;
    }
}
