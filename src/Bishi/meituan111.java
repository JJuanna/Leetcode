package Bishi;

import java.util.Arrays;
import java.util.Scanner;

public class meituan111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nxy = sc.nextLine();
        String[] s = nxy.split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);
        String scorestring = sc.nextLine();
        String[] scorearray = scorestring.split(" ");
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(scorearray[i]);
        }
        System.out.println(divide(n, score, x, y));

    }

    // 二分查找思想
    public static int divide(int n, int[] score, int x, int y) {
        int res = -1;
        // 二分查找一个分数线，最低分数线优先等价于左边优先
        // 对score进行排序
        Arrays.sort(score);
        int left = 0;
        int right = n - 1;
        int mid = (left + right) / 2;
        while (mid <= right && mid >= left) {
            if (right - mid <= y && right - mid >= x && mid - left + 1 >= x && mid - left + 1 <= y) {
                res = score[mid];

            }
            // 再往左边找
            mid--;
        }
        return res;
    }
}
