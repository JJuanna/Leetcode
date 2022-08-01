package hashTable;

import java.util.*;

public class FourSum {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        for(int i:nums1){
            for(int j:nums2){
                temp = i+j;
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }
        for(int i:nums3){
            for(int j:nums4){
                temp = i+j;
                if(map.containsKey(0-temp)){
                    res += map.get(0-temp);
                }
            }
        }
        return res;
    }

    public  List<List<Integer>> fourSum(int[] nums, int target){
        // 双指针法：时间复杂度O(n^3),空间复杂度因为需要排序，所以是O(n)()
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        // 排序
        Arrays.sort(nums);
        // 两层循环
        for(int i = 0; i < nums.length; i++){
            // 去重
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        // sum==target
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 去重
                        while(left<right && nums[right]==nums[right-1]) right--;
                        while(left<right && nums[left]==nums[left+1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }


}
