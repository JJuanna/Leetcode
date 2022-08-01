package TopKsort;

import java.util.Arrays;
import java.util.Scanner;

public class mergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, temp);
    }
    public  static void mergeSort(int[] nums, int l, int r, int[] temp){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(nums, l,mid, temp);
            mergeSort(nums, mid+1, r, temp);
            merge(nums, l, mid, r, temp);//合并
        }
    }
// 归并排序时间复杂度分析：划分子区间O(logn),合并子区间O(n),时间复杂度是O(nlogn),空间复杂度O(n)
    private static void merge(int[] nums, int l, int m, int r, int[] temp) {
        int i = l; //左子序列指针式
        int j = m+1; //右子序列指针
        int t = 0;
        while(i<=m && j<=r){
            if(nums[i]<=nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }
        while(i<=m){
            temp[t++] = nums[i++];
        }
        while(j<=r){
            temp[t++] = nums[j++];
        }
        t = 0;
        while(l<=r){
            nums[l++] = temp[t++];
        }

    }
}
