package Bishi;

import java.io.*;
import java.util.Scanner;

public class meituan114 {
    private static int[][] mem;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String weights = br.readLine();
        String[] weight = weights.split(" ");
        int[] intweight = new int[n];
        for(int i=0;i<n;i++){
            intweight[i] = Integer.parseInt(weight[i]);
        }
        mem = new int[n][n];
        int r = dfs1(intweight, 0, n-1);
        System.out.println(r);

    }
    // 最优二叉树II
    private static int dfs2(int[] weights, int left, int right){
        int res=0;

        return res;
    }
    // 最优二叉树
    // 通过递归方式
    private static int dfs1(int[] weights, int left, int right){
        int res=0;

        return res;
    }
}
