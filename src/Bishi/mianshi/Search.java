package Bishi.mianshi;

// 搜索旋转数组：一个有序的数组，在未知的某个点上进行了旋转，给定一个目标数字，查找这个数字在数组中的下标
public class Search {
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target)
                return left;
            else if (nums[right] == target)
                return right;
            else if (nums[mid] == target)
                return mid;
            else {
                if (target > nums[mid]) {
                    if (nums[mid] > nums[0])
                        left = mid + 1;
                    else {
                        if (target > nums[0])
                            right = mid - 1;
                        else
                            left = mid + 1;
                    }
                } else {
                    if (nums[mid] < nums[0])
                        right = mid - 1;
                    else {
                        if (target < nums[0])
                            left = mid + 1;
                        else
                            right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int res = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(res);
    }
}
