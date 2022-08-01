package StackAndDeque;

import java.util.PriorityQueue;

public class KthLargest {

    /*
     * 求数据流的第K大数值
     * */
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        // 使用最小堆,只维护前k大的元素,如果有新的最大的元素进入，那么弹出优先队列中最小的元素，如果是比第k大小的元素，那么不进入队列
        // 比较k和nums.length的大小
        queue = new PriorityQueue<>();
        this.k = k;
        if (k <= nums.length) {
            for (int i = 0; i < k; i++) {
                queue.offer(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > queue.peek()) {
                    queue.offer(nums[i]);
                    queue.poll();
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                queue.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (queue.size() < this.k) {
            queue.offer(val);
        } else if (val > queue.peek()) {
            queue.offer(val);
            queue.poll();
        }
        return queue.peek();
    }

    /*
     * 数组中的第k个最大元素
     * 1<k<=nums.length<=10^4
     * 时间复杂度O(n),空间复杂度O(k)
     * 堆排序算法O(logn)
     * */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            q.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > q.peek()) {
                q.offer(nums[i]);
                q.poll();
            }
        }
        return q.peek();
    }

    /*
     * LCP 33.蓄水
     * */
    // bucket表示水桶，vat表示需要蓄水的量
    // 返回操作次数（操作包括升级水桶和蓄水）
//    public int storeWater(int[] bucket, int[] vat) {
//        //解决方案
//    }
}
