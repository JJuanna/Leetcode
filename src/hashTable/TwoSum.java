package hashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // 使用哈希表实现
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            // 哈希表中不存在
            if(map.get(target-nums[i])==null){
                map.put(nums[i], i);
            }
            else{
                // 哈希表中存在target-当前数字
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                // return res;
            }
        }
        return res;
    }
}
