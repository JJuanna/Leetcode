package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 用暴力法解决，三层循环,会出现数据重复的问题
        // 使用双指针法,先对数组进行排序，才能使用双指针法
        nums = QuickSort(nums,0, nums.length-1);
        if(nums[0]>0) return res;
        for(int i = 0; i < nums.length; i++){
            // 如果排序后的第一个数字就大于0,那么不可能出现和为0的三元组
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while(left<right && nums[right]==nums[right-1]) right--;
                    while(left<right && nums[left]==nums[left+1]) left++;

                    right--;
                    left++;
                }
            }

        }
        return res;
    }
    public int[] QuickSort(int[] nums,int start, int end){
        partition(nums, start, end);
        return nums;
    }
    public void partition(int[] nums, int left, int right){
        if(left>right) return;
        int pivot = nums[left];
        int l = left, r=right;
        while(left<right){
            while(nums[right]>pivot && left<right){
                right--;
            }
            if(left<right){
                nums[left] = nums[right];
                left++;
            }
            while(nums[left]<pivot && left<right){
                left++;
            }
            if(left<right){
                nums[right] = nums[left];
                right--;
            }
            nums[left] = pivot;
            // 排序左边
            partition(nums, l, left-1);
            partition(nums, left+1, r);
        }
    }
}
