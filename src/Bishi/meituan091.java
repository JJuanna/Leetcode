package Bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class meituan091 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int minWeight = sc.nextInt();
            int maxWeight = sc.nextInt();
            // 保证小和大
            if (minWeight > maxWeight) {
                int temp = minWeight;
                minWeight = maxWeight;
                maxWeight = temp;
            }
            int[] weight = new int[m];
            for (int i = 0; i < m; i++) {
                weight[i] = sc.nextInt();
            }
            System.out.println(judge(n, m, minWeight, maxWeight, weight));
        }
    }

    public static String judge(int n, int m, int minWeight, int maxWeight, int[] weight) {
        String yes = "YES";
        String no = "NO";
        int buy = 2;
        // 从小到大排序
        Arrays.sort(weight);
        // 分类讨论
        // 如果能做的个数大于2,
        if (n - m >= 2) {
            // 当前做的最小重量小于最小值，最大重量大于最大值，则直接判断无法满足要求(不能等于，注意边界条件)
            if (minWeight > weight[0] || maxWeight < weight[m - 1]) return no;
            // 否则，一定可以满足要求
            return yes;
        }
        if (n - m == 0) {
            // 没法做新的了，只能看做好的是否满足要求
            if (weight[0] == minWeight && weight[m - 1] == maxWeight)
                return yes;
            else return no;
        }
        if (n - m == 1) {
            // 如果只能做一个，那么判断做好的蛋糕中是否有一个等于minWeight或maxWeight
            if (weight[0] == minWeight || weight[m - 1] == maxWeight) return yes;
            else return no;
        }
        return no;
    }
}
