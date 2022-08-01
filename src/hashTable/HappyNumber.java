package hashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        // 需要考虑无限循环的情况
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = getSum(n);
        }
        return n==1;

    }
    public static int getSum(int n){
        int sum = 0;
        while(n>0){
            // 获取最低位数据的平方和
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }
}
