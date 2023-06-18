package Bishi.zhaohang;

import java.util.Scanner;

// https://yexua.github.io/2019/04/10/%E6%8B%9B%E5%95%86%E9%93%B6%E8%A1%8C%E7%AC%94%E8%AF%95%E7%BC%96%E7%A8%8B%E9%A2%98/
public class qiaokeli {
    public static void main(String[] args) {
        // 求2^(n-6)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 6) {
            System.out.println(0);
        } else {
            System.out.println(Math.pow(2, n - 6) % 666666);
        }
    }
}
