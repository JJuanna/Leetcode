package Bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpatialRelationUtil {
    private SpatialRelationUtil() {
    }


    public static class Point {

        public Point(int a, int b) {
            x = a;
            y = b;
        }

        public double x;
        public double y;
    }

    /**
     * 返回一个点是否在一个多边形区域内
     *
     * @param mPoints 多边形坐标点列表
     * @param point   待判断点
     * @return true 多边形包含这个点,false 多边形未包含这个点。
     */
    public static boolean isPolygonContainsPoint(List<Point> mPoints, Point point) {
        int nCross = 0;
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            // 取多边形任意一个边,做点point的水平延长线,求解与当前边的交点个数
            // p1p2是水平线段,要么没有交点,要么有无限个交点
            if (p1.y == p2.y) continue;
            // point 在p1p2 底部 --> 无交点
            if (point.y < Math.min(p1.y, p2.y)) continue;
            // point 在p1p2 顶部 --> 无交点
            if (point.y >= Math.max(p1.y, p2.y)) continue;
            // 求解 point点水平线与当前p1p2边的交点的 X 坐标 通过前面几个if条件筛选,这里的如果求出来有交点一定在p1p2连接线上,而不是延长线上.
            double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
            if (x > point.x) // 当x=point.x时,说明point在p1p2线段上
                nCross++; // 只统计单边交点
        }
        // 单边交点为偶数，点在多边形之外 ---
        return (nCross % 2 == 1);
    }

    /**
     * 返回一个点是否在一个多边形边界上
     *
     * @param mPoints 多边形坐标点列表
     * @param point   待判断点
     * @return true 点在多边形边上,false 点不在多边形边上。
     */
    public static boolean isPointInPolygonBoundary(List<Point> mPoints, Point point) {
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            // 取多边形任意一个边,做点point的水平延长线,求解与当前边的交点个数

            // point 在p1p2 底部 --> 无交点
            if (point.y < Math.min(p1.y, p2.y)) continue;
            // point 在p1p2 顶部 --> 无交点
            if (point.y > Math.max(p1.y, p2.y)) continue;

            // p1p2是水平线段,要么没有交点,要么有无限个交点
            if (p1.y == p2.y) {
                double minX = Math.min(p1.x, p2.x);
                double maxX = Math.max(p1.x, p2.x);
                // point在水平线段p1p2上,直接return true
                if ((point.y == p1.y) && (point.x >= minX && point.x <= maxX)) {
                    return true;
                }
            } else { // 求解交点
                double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
                if (x == point.x) // 当x=point.x时,说明point在p1p2线段上
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int P = Integer.parseInt(br.readLine());
        // 读入已经刷的坐标点
        List<Point> pPoint = new ArrayList<>();
        String[] points = br.readLine().split(" ");
        for (int i = 0; i < points.length; i++) {
            String[] temp = points[i].split(",");
            pPoint.add(new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        // 读入待检测的坐标点
        int Q = Integer.parseInt(br.readLine());
        String[] qpoints = br.readLine().split(" ");
        List<Point> qPoint = new ArrayList<>();
        for (int i = 0; i < qpoints.length; i++) {
            String[] temp = qpoints[i].split(",");
            qPoint.add(new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        // 遍历判断每一个点，存入res中
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            if (isPolygonContainsPoint(pPoint, qPoint.get(i)) || isPointInPolygonBoundary(pPoint, qPoint.get(i))) {
                res.add(1);
            } else {
                res.add(0);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
    }

}
//100 100
//        14
//        1,1 1,2 1,3 1,4 1,5 2,1 2,5 3,1 3,4 3,5 4,1 4,2 4,3 4,4
//        10
//        0,0 1,1 2,2 3,3 4,4 5,5 60,60 70,70 80,80 90,90