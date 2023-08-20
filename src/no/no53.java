package no;

public class no53 {
    // 动态规划优化版
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int dp = nums[0];
        for (int i=1; i<nums.length; i++) {
            // 警惕，nums数组中有负数，如果将max和dp都定义成MIN_VALUE,会导致加一个负数的时候，向下溢出导致结果错误
            dp = Math.max(nums[i], dp + nums[i]);
            max = Math.max(dp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2};
        System.out.println(maxSubArray(nums));
    }
}
