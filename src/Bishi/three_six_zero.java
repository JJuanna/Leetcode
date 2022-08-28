package Bishi;

import java.util.Scanner;

// 360一题，刷礼物
public class three_six_zero {
    static int n,m;
    static int[][] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        // 当前一天7天内粉丝别的粉丝刷榜总和
        int[] sumNow = new int[m];
        // 自己的粉丝每天需要刷榜的数量
        int[] my = new int[n];
        int sumMax = 0;
        int temp = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            sumMax = 0;
            for(int j = 0; j < m; j++){
                sumNow[j] += nums[i][j];
                if(i >= 7){
                    sumNow[j] -= nums[i-7][j];
                }
                sumMax = Math.max(sumMax, sumNow[j]);
            }
            if(i >= 7){
                res -= my[i-7];
            }
            my[i] = Math.max(res, sumMax+1) - res;
            res += my[i];
            System.out.println(my[i]);
            temp += my[i];
        }
        System.out.println(temp);
    }
}
