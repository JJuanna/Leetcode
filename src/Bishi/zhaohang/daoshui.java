package Bishi.zhaohang;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class daoshui {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int w = sc.nextInt();
//        // 每个杯子容量不同,每个杯子分给谁也不确定
//        int[] ai = new int[2 * n];
//        for (int i = 0; i < 2 * n; i++) {
//            ai[i] = sc.nextInt();
//        }
//        Arrays.sort(ai);
//        // 因为男生的水的数量要是女生的二倍，所以小杯子给女生用，大杯子给男生用
//        // 男生的第一个杯子容量和女生第一个杯子容量,同时也是倒水的上限
//        double bMax = ai[n], gMax = ai[0];
//        double res = 0.0;
//        // 男生第一个杯子的容量小于等于女生的第一个杯子的容量的二倍
//        if (bMax / 2 <= gMax) {
//            // 那么女生杯子能装的水是男生第一个杯子的1/2
//            res = bMax * 1.5 * n;
//        } else {
//            // 否则，男生第一个杯子能装的水是女生第一个杯子容量的二倍
//            res = gMax * 3 * n;
//        }
//        if (res > w) {
//            // res>w说明，杯子的分水总容量大于w，采用其他方案，w毫升水一定会被分完
//            res = w;
//        }
//        System.out.printf("%.6f", res);
        try{
            FileWriter writer = new FileWriter("d:/a.txt");
            writer.write(97);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
