package Bishi;

import java.util.*;

public class microsoft {

    public static int solution(int[] A) {
        int n = A.length;
        int sum = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        double target = sum / 2;
        double cur = sum;
        Queue<Double> queue = new PriorityQueue<>(
                new Comparator<Double>() {
                    @Override
                    public int  compare(Double o1, Double o2) {
                        return (int) (o2 - o1);
                    }
                });
        for (double i: A){
            queue.offer(i);
        }
        while (cur>target){
            double x = queue.poll();
            x=x/2.0;
            cur = cur-x;
            num++;
            queue.offer(x);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] A = {5,9,8,1};
        System.out.println(solution(A));
    }
}
