package no;

public class no279 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
//    时间O(n*Sqrt(n))
    // 动态规划算法
    public static int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
