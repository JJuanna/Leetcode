package array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 双指针法
        // 思路：一个指针指向移动后数字的位置，另一个指针用来遍历数组
        // O(n),O(1)
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[m] = nums[i];
                m++;
            }
        }
        if (m != 0) {
            for (int i = m; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
