package StackAndDeque;

import javax.print.attribute.IntegerSyntax;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindow {
    public static void main(String[] args) {
        //输入数组和滑动窗口大小
//        Scanner sc = new Scanner(System.in);
//        int m=0,k=0;
//        int[] number = new int[m];
//        while(sc.hasNext()){
//            m = sc.nextInt();
//            number = new int [m];
//            for(int i=0; i<m; i++){
//                number[i] = sc.nextInt();
//            }
//            k = sc.nextInt();
//        }
        int m = 8, k = 3;
        int[] number = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = new int[m - k + 1];
        res = maxSlidingWindow(number, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        //时间复杂度O(n),空间复杂度O(1)
        //极端条件判断
        if (nums.length == 0 || k == 0) return new int[0];
        //单调队列需要满足两个条件
        //一是队列中的元素在当前窗口内
        //二是队列保持单调递减
        int length = nums.length - k + 1;
        int[] res = new int[length];
        Deque<Integer> que = new LinkedList<>();
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除deque中的nums[i-1]
            if (i > 0 && que.peekFirst() == nums[i - 1]) {
                que.removeFirst();
            }
            //保持队列元素单调递减
            while (!que.isEmpty() && nums[j] > que.peekLast()) {
                que.removeLast();
            }
            que.add(nums[j]);
            if (i >= 0) res[i] = que.peekFirst();
        }
        return res;
    }

}
