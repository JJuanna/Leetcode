package num;

public class no169 {
    public static int majorityElement(int[] nums) {
        // 记录下标
        int res = 0;
        int count = 1;
        // 一次遍历
        for (int i = 1; i < nums.length; i++) {
            if (count != 0 && nums[res] == nums[i]) {
                count++;
            } else if (count != 0 && nums[res] != nums[i]) {
                // res下标位置不等于当前值
                count--;
            } else {
                res = i;
                count++;
            }
        }
        return nums[res];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
    // 测试用例
    // 输入空数组，会出现什么
    // 输入只有1个元素的数组
    // 输入两个元素的数组，两个元素相同，输出首个元素的值，两个元素不同，是否会输出执行出错（无法处理不存在多数元素的情况）
    // 输入4个元素的数组，不存在多数元素的情况
    // 输入长度大于n的数组，测试执行效率
}
