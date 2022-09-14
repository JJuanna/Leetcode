package Bishi.gongshanghang;
// https://string.quest/read/7609340
// 给定平面上n个点，求最多有多少点共线
public class dianGongXian {
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3},{4,4},{1,2},{1,3}};
        System.out.println(conutPoints(points));
    }

    // 暴力法求共线点的个数
    public static int conutPoints(int[][] points) {
        if (points.length < 3) return points.length;
        // 至少有两个点
        int maxPoints = 2;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                long x1 = points[i][0], y1 = points[i][1];
                long x2 = points[j][0], y2 = points[j][1];
                // 如果两个点相同，继续向后找一个点
                if (x1 == x2 && y1 == y2) {
                    continue;
                }
                int temp = 0;
                for (int k = 0; k < points.length; k++) {
                    long x = points[k][0];
                    long y = points[k][1];
                    if ((y - y1) * (x2 - x1) == (y2 - y1) * (x - x1)) {
                        temp++;
                    }
                }
                maxPoints = Math.max(maxPoints, temp);
            }
        }
        return maxPoints;
    }
}
