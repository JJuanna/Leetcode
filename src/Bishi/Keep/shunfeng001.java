package Bishi.Keep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class shunfeng001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double times = 0;
        for (int i = n; i >= 1; i--) {
            times += Math.ceil(Math.log(i))+1;
        }
        System.out.println((int)(times-1));
    }
}
