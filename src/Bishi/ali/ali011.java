package Bishi.ali;

import java.util.Scanner;

public class ali011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        String s = sc.next();
        int res = computeCost(price, s);
        System.out.println(res);
    }

    private static int computeCost(int[] prices, String s) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (s.charAt(i) == 'T') {
                res += prices[i];
            } else {
                res += Math.max(5, Math.floor((double) prices[i] / (double) 100));
            }
        }
        return res;
    }
}
