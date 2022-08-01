package DivideAndConquer;

import javax.print.attribute.standard.PrinterName;

public class Solution {
    StringBuilder res;
    int count = 0, n, nine,start;
    // 创建字符列表
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n-1;
        // 全排列递归
        dfs(0);
        //删除最后一个逗号
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
    // 递归全排列
    void dfs(int x){
        // 终止条件
        if(x==n){
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res.append(s+",");
            if(n-start == nine) start--;
            return;
        }
        for(char i: loop){
            if(i=='9') nine++;
            num[x] = i;
            dfs(x+1);
        }
        nine--;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        String ans = s.printNumbers(3);
        System.out.println(ans);
    }
}
