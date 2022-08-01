package hashTable;

import java.util.*;

public class IntersectionofTwoArrays {

    /*
    * 返回两个数组的交集
    * 方法一：时间复杂度O(n), 空间复杂度O(n)
    * */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num: nums2){
            // 检查相交的数字
            if(map.getOrDefault(num, 0)>0){
                // 说明num交集中的数据
                if(!lst.contains(num)){
                    lst.add(num);
                }
            }
        }
        int[] ret = new int[lst.size()];
        for(int i=0; i< lst.size(); i++){
            ret[i] = lst.get(i);
        }
        return ret;
    }

    /*
    * 方法二：时间复杂度O(n),空间复杂度O(n)*/
    public static int[] intersection2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int i:nums1){
            s1.add(i);
        }
        for(int j:nums2){
            if(s1.contains(j)){
                res.add(j);
            }
        }
        // 将集合转换成数组
        int[] ret = new int[res.size()];
        int index= 0;
        for(int i: res){
            ret[index++] = i;
        }
        return ret;
    }

    public static void main(String[] args) {
        // 输入是3行，第一行输入两个数组的长度，第二行和第三行分别输入时
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int[] nums1 = new int[first];
        int[] nums2 = new int[second];

        for(int i=0; i<first; i++){
            nums1[i] = sc.nextInt();
        }
        for(int j = 0; j<second; j++){
            nums2[j] = sc.nextInt();
        }

        int[] ret = intersection(nums1, nums2);
        for(int i=0; i<ret.length; i++){
            System.out.print(ret[i]);
        }


    }
}
