package Bishi.nohang;

import java.util.Scanner;

//https://codeleading.com/article/35744690636/
public class findPoint {
    // 给定k个点，找这k个点中离质心最近的点的编号
    // 质心：横纵坐标为所有点的均值

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] points = sc.nextLine().split(" ");
        // 计算质心
        double centerx = 0.0;
        double centery = 0.0;
        for (int i = 0; i < points.length; i++) {
            centerx += points[i].charAt(0);
            centery += points[i].charAt(2);
        }
        centerx = centerx / (double) points.length;
        centery = centery / (double) points.length;
        int index = findIndex(centerx, centery, points);
        System.out.println(index);
    }

    public static int findIndex(double x, double y, String[] points) {
        double minDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < points.length; i++) {
            // 只需要计算距离的平方即可,如果有相同的值，优先输出下标小的点
            double tempDistance = Math.pow((points[i].charAt(0) - x), 2) + Math.pow((points[i].charAt(2) - y), 2);
            if (minDistance > tempDistance) {
                minIndex = i;
                minDistance = tempDistance;
            }
        }
        return minIndex;
    }

}
