package Bishi.tianyiyun;

import java.util.Scanner;

// 统计多个区间中，不重叠区间的长度
public class tianyiyun01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] strs = sc.next().split(",");
            nums[i][0] = Integer.parseInt(strs[0]);
            nums[i][1] = Integer.parseInt(strs[1]);
            max = Math.max(max, nums[i][0]);
            max = Math.max(max, nums[i][1]);
            min = Math.min(min, nums[i][0]);
            min = Math.min(min, nums[i][1]);
        }
        int[] record = new int[max];
        // 统计每一个区间格子，用record[j]表示格子j的重叠数量
        for (int i = 0; i < n; i++) {
            for (int j = nums[i][0]; j < nums[i][1]; j++) {
                record[j]++;
            }
        }
        int res = 0;
        // 重叠数量为1的就是不重叠长度
        for (int i = min; i < max; i++) {
            if (record[i] == 1) {
                res++;
            }
        }
        System.out.println(res);
    }
}
