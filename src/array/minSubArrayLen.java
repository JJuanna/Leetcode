package array;

import java.util.Arrays;

public class minSubArrayLen {
    /*
     * 题目描述
     * input:int target, int[] nums
     * output:int res, nums中和大于等于target的最小长度子数组的长度
     * 思路：(暴力法)使用滑动窗口，遍历一次数组，滑动窗口大小加1
     * 时间复杂度O(n^2)，空间复杂度O(1)
     * 会超时
     * */
    public int solution(int target, int[] nums) {
        int windowSize = 1;
        int sum = 0;
        while (windowSize <= nums.length) {
            for (int i = 0; i < nums.length - windowSize + 1; i++) {
                for (int j = i; j < i + windowSize; j++) {
                    sum += nums[j];
                }
                if (sum >= target) return windowSize;
                sum = 0;
            }
            windowSize++;
        }
        return 0;
    }

    /*
     * 动态调整滑动窗口的大小
     * 时间复杂度O(n)，空间复杂度O(1)
     * */
    public int solution2(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
