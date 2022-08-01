package DynamicProgramming;

public class HouseRobber {
    // 打家劫舍
    public int rob(int[] nums) {
        int size = nums.length;
        // dp[i]表示到第i个房子为止，小偷偷到的最大金额，i=0作为占位，不代表实际的房子
        // 还可以使用滚动数组减少空间复杂度
        int[] dp = new int[size + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= size; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[size];
    }

    // 打家劫舍I,所有房子都围成一圈
    // 两种情况，一种是第1个房子不偷，另一种是第1个房子偷
    public int rob1(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= size; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[size];
    }

//    public int myRob(int[] nums, int start, int end) {
//        int first = nums[start], second = Math.max(first, nums[start + 1]);
//        for (int i = start+2; i <= end; i++) {
//            int tmp = second;
//            second = Math.max(nums[i-2]+first,);
//        }
//        return dp[size];
//    }

}
