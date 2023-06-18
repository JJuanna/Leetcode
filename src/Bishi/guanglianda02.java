package Bishi;

import java.util.Scanner;

public class guanglianda02 {
    // n * m的矩形，有一个铡刀，一次切一刀，可以将矩形分成两个部分，想分成k个小矩形，求最小的切割次数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        if (k == 1) System.out.println(0);
        if (k == 2) System.out.println(Math.min(n, m) * Math.min(n, m));
//        if (k > n * m) System.out.println();
        System.out.println(compute(n, m, k));
    }

    public static int compute(int n, int m, int k) {
        int res = 0;
        // 贪心算法计算
        while (k > 1) {
            int min = Math.min(n, m);
            int max = Math.max(n, m);
            res += min * min;
            k -= 1;
            if (k - 1 <= min - 1) {
                res += k - 1;
                break;
            } else {
                res += min - 1;
                k -= min - 1;
            }
            n = max - 1;
        }
        return res;
    }
}
