package no;

public class no88 {
    // 从右向左合并
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int f = m-1;
        int s = n-1;
        for (int i = m+n-1; i >= 0; i--) {
            if(f<0 || (s>=0 && nums1[f]<=nums2[s])){
                nums1[i]=nums2[s];
                s--;
            }else{
                nums1[i] = nums1[f];
                f--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[2];
        int[] nums2 = {1, 2};
        nums1 = nums2;
        for (int i = 0; i < 2; i++) {
            System.out.println(nums1[i]);
        }
    }
}
