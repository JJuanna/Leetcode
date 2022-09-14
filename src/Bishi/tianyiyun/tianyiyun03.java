package Bishi.tianyiyun;

import java.util.Scanner;

public class tianyiyun03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tili = sc.nextInt();
        int n = sc.nextInt();
        int[] shiyong = new int[n];
        for (int i = 0; i < n; i++) {
            shiyong[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] haoli = new int[m];
        for (int i = 0; i < m; i++) {
            haoli[i] = sc.nextInt();
        }
        System.out.println(twoDknapsack(haoli, shiyong, tili));
    }

    public static int twoDknapsack(int[] weight, int[] value, int knapsackSize) {
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
        return dp[m-1][n];
    }
}
