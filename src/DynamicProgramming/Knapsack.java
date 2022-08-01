package DynamicProgramming;

import javax.swing.*;

public class Knapsack {
    public static void twoDknapsack(int[] weight, int[] value, int knapsackSize) {
        int m = value.length, n = knapsackSize;
        // dp数组
        int[][] dp = new int[m][n + 1];
        // 初始化
        for (int j = weight[0]; j <= n; j++) {
            // 这里不能直接从下标0开始初始化，物品0的重量未必比背包的容量小
             dp[0][j] = value[0];
        }
        // 递推,按照先物品后背包的顺序递推
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                // 判断是否超重
                if (j - weight[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        //打印dp数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    // 一维dp数组
    public static void oneDknapsack(int[] weight, int[] value, int knapsackSize) {
        int[] dp = new int[knapsackSize + 1];
        // 初始化
        // 错误写法：正序遍历，正序遍历使得一个物品被放入背包多次（47行）
//        for (int j = weight[0]; j < knapsackSize + 1; j++) {
//            dp[j] = value[0];
//        }
//        for (int i = 1; i < weight.length; i++) {
//            for (int j = weight[i]; j < knapsackSize + 1; j++) {
//                if (j - weight[i] >= 0) {
//                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//                }
//            }
//        }
        // 一维的背包，必须是倒序遍历
        for (int i = 0; i < weight.length; i++) {
            for (int j = knapsackSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println("\n");

    }

    public static void main(String[] args) {
        int bagsize = 4;
        int[] weight = {3, 1, 4};
        int[] value = {20, 15, 30};
        oneDknapsack(weight, value, bagsize);
    }

    // 分割等和子集
    public boolean canPartition(int[] nums) {
        // 求背包的体积
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int bagSize = sum / 2, mod = sum % 2;
        if (mod != 0) return false;
        // 01背包问题
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[bagSize] == bagSize;
    }

    // 最后一块石头的重量
    public int lastStoneWeightII(int[] stones) {
        // 求背包的体积
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = bagSize; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        int res = sum - dp[bagSize] * 2;
        return res;
    }
}
