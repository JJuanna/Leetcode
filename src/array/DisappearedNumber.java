package array;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 思路：将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为消失的数字
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DisappearedNumber solution = new DisappearedNumber();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = new ArrayList<>();
        res = solution.findDisappearedNumbers(nums);
    }
}
