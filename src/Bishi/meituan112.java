package Bishi;

import java.util.Arrays;
import java.util.Scanner;

public class meituan112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String scorestring = sc.nextLine();
        String[] scorearray = scorestring.split(" ");
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(scorearray[i]);
        }
        System.out.println(ops(n, score));

    }
    public static int ops(int n, int[] scores){
        int res = 0;
        Arrays.sort(scores);
        for(int i=0;i<n;i++){
            res+= Math.abs(scores[i]-(i+1));
        }
        return res;
    }
}
