package Bishi.mianshi;

public class leetcode11 {
    // 盛水最多的容器
    // 思路：双指针法，分别指向水槽的两端，每次移动短的一边，可能会使得矩形面积增大，移动长的一边，矩形面积一定减小
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxwater = 0;
        while (i < j) {
            maxwater = Math.max(maxwater, Math.min(height[i], height[j]) * (j - i));
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxwater;
    }
}
