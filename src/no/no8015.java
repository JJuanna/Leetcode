package no;

import java.util.HashMap;

public class no8015 {
    /**
     * 力扣周赛 2023.08.27
     * no8015
     * 找到距离原点位置最远的点
     * 思路：分别统计L，R，_的数字，位置最远的点的坐标为Max(num(L),num(R))+num(_)-min(num(L),num(R))
     *
     * @param moves
     * @return
     */
    public int furthestDistanceFromOrigin(String moves) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < moves.length(); i++) {
            if (!map.containsKey(moves.charAt(i))) {
                map.put(moves.charAt(i), 1);
            } else {
                map.put(moves.charAt(i), map.get(moves.charAt(i)) + 1);
            }
        }
        //统计哈希表中存储的数量
        int cntL = map.getOrDefault('L', 0);
        int cntR = map.getOrDefault('R', 0);
        int cnt_ = map.getOrDefault('_', 0);
        int max = Math.max(cntL, cntR);
        int min = Math.min(cntL, cntR);
        return max + cnt_ - min;
    }

    /**
     * no8022
     * 当前解法时间复杂度太高，O(n^2)，空间复杂度O(n)
     * @param n
     * @param target
     * @return
     */
    public static long minimumPossibleSum(int n, int target) {
//        if (n == 1) return 1;
        int m = 1;
        long sum = 0;
        int[] arr = new int[n];

        arr[0] = m;
        sum += arr[0];
        boolean flag;
        m += 1;
        for (int i = 1; i < n; i++) {
            // i表示该填入数字的位置
            // 保证每次新填入的数字中不存在两个和==target的情况
            flag = judge(arr, i, m, target);
            while (!flag) {
                m += 1;
                flag = judge(arr, i, m, target);
            }
            arr[i] = m;
            sum += arr[i];
            m += 1;
        }
        return sum;
    }

    public static boolean judge(int[] arr, int i, int m, int target) {
        for (int k = 0; k < i; k++) {
            if (arr[k] + m == target) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long sum = minimumPossibleSum(2, 3);
    }

}
