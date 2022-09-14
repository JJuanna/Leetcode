package Bishi.ali;

public class ali001 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 1, 2, 3, 3, 2, 1, 2, 3};
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 2) {
                count++;
                if (i - 1 >= 0 && i + 1 < nums.length) {
                    if ((nums[i - 1] == 1 && nums[i + 1] == 3) || (nums[i - 1] == 3 && nums[i + 1] == 1)) {
                        if (i - 2 > -0 && nums[i - 2] == 2) {
                            count += 1;
                        } else {
                            count += 2;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
