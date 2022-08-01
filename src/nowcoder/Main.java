package nowcoder;

import java.util.Scanner;

public class Main {
// 动态规划，时间复杂度O(n),空间复杂度O(n)
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        String s = cin.next();
        System.out.println(shua(n, s));
    }

    public static int shua(int n, String s) {
        int[] dp = new int[n+1];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1') dp[0]++;
        }
        for(int i=1; i<s.length()+1; i++){
            dp[i] = dp[i-1] + (s.charAt(i-1)=='0'?1:0)-(s.charAt(i-1)=='1'?1:0);
        }
        int min = dp[0];
        for(int i=1; i<dp.length; i++){
            if(min>dp[i]) min=dp[i];
        }
        return min;
    }

}
