package Bishi;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class meituan114 {
    private static int[][] mem;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String weights = br.readLine();
        br.close();
        String[] weight = weights.split(" ");
        int[] intweight = new int[n];
        for (int i = 0; i < n; i++) {
            intweight[i] = Integer.parseInt(weight[i]);
        }
        mem = new int[n][n];
        dp = new int[n][n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(mem[i], -1);


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++) dp[i][j][k] = -1;
        }

        int r = dfs2(intweight, 0, n - 1, -1);
//        System.out.println(r);
        bw.write(Integer.toString(r));
        bw.flush();
//        System.out.println(r);

    }

    // 最优二叉树II：边的开销=边的两端节点权值的成绩
    private static int dfs2(int[] weights, int left, int right, int root) {
        int res = Integer.MAX_VALUE;
        // 让每一个节点都做一次根节点，构建二叉树
        // 无法构成子树
        if (left > right) return 0;
        // 该子树的最小开销已经计算过,直接返回
        if (root>=0 && dp[left][right][root] != -1) return dp[left][right][root];
        // 穷举根节点
        int leftcost = 0;
        int rightcost = 0;
        for (int i = left; i <= right; i++) {
            leftcost = dfs2(weights, left, i - 1, i);
            rightcost = dfs2(weights, i + 1, right, i);
            res = Math.min(res, leftcost + rightcost + weights[i] * (root != -1 ? weights[root] : 0));
        }
        // 更新子树的递归结果
        if(root>=0) dp[left][right][root] = res;
        return res;
    }

    // 最优二叉树：开销=节点权值*深度之和
    // 分治重构二叉树+记忆化递归，对于每一层递归，都将这一层构建子树的所有节点的权值都求一次和，
    // 每向下递归一层就累加一遍构建子树的节点权值，这样越深的节点就加得越多，对于第 i 层的节点，其权重就加了 i 次，相当于考虑了深度。
//    而每次根节点处于相对的第0层，所以每层计算节点权重之和时要减去根节点的权重。
    private static int dfs1(int[] weights, int left, int right) {
        int res = Integer.MAX_VALUE;
        // 让每一个节点都做一次根节点，构建二叉树
        // 无法构成子树
        if (left >= right) return 0;
        // 该子树的最小开销已经计算过,直接返回
        if (mem[left][right] != -1) return mem[left][right];
        // 每个节点加上其本身的权重
        int rawWightSum = 0;
        for (int i = left; i <= right; i++)
            rawWightSum += weights[i];
        // 穷举根节点
        for (int i = left; i <= right; i++) {
            res = Math.min(res, dfs1(weights, left, i - 1) + dfs1(weights, i + 1, right) + rawWightSum - weights[i]);
        }
        // 更新子树的递归结果
        mem[left][right] = res;
        return res;
    }
}
