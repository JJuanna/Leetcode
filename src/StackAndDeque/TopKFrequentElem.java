package StackAndDeque;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElem {
    /*
     * 1.统计给定数组中元素出现的频率
     * 2.对频率进行排序
     * 3.找到前k个高频元素
     * */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计元素出现的频率
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 对频率进行排序
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        // 构建小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }
        int[] res = new int[k];
        for(int i=k-1; i>=0; i--){
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElem s = new TopKFrequentElem();
        int[] res = new int[2];
        res = s.topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 2, 4, 4, 4, 4, 4},2);
    }
}
