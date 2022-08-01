package DynamicProgramming;

public class TargetSum {
    // 求一共有几种方式使得nums中的数字加减之后等于target
    // 解题思路：left组合-right组合=target, left+right=sum, 可以推出left=(target+sum)/2,将问题转化为找和为left的组合
    // 时间复杂度O(m*n),空间复杂度O(m),m为背包容量，n为正数个数
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if(size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                // 组合类问题通用的递推公式
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
