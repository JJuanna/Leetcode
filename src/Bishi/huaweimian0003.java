package Bishi;

import java.util.Scanner;

public class huaweimian0003 {
    static void PrintfSpace(int num) {                         //输出num个空格
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
            ;
        }
    }

    static void PrintfPositiveSequence(int num) {              //正序输出1...num
        for (int i = 1; i <= num; i++) {
            System.out.print(i);
        }
    }

    static void PrintfReverseSequence(int num) {               // 逆序输出num...1
        for (int i = num; i > 0; i--) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            // 空格+正序数字+逆序数字
            PrintfSpace(n - i);
            PrintfPositiveSequence(i);
            PrintfReverseSequence(i - 1);
//            PrintfSpace(n - i);                   //第一次没懂题目烦的错，最后一个数字后面加空格了
            System.out.println();
        }
    }

}