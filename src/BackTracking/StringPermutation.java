package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringPermutation {
    // 排列O(N!),时间复杂度O(),栈的深度为N，递归存储数据量最多N，空间复杂度O(N^2)
    // 存放最终结果
    List<String> res = new LinkedList<>();
    // 暂存结果
    StringBuilder path;
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        path = new StringBuilder();
        boolean[] used = new boolean[c.length];
        Arrays.fill(used, false);
        // 必须先排序
        Arrays.sort(c);
        backtracking(c, used);
        return res.toArray(new String[res.size()]);

    }
    public void backtracking(char[] c, boolean[] used){
        // 终止条件：生成一个组合
        if(path.length() == c.length){
            res.add(path.toString());
            return;
        }
        // 搜索
        for(int i=0; i<c.length; i++){
            // 如果同一树层访问过，则直接跳过&去重
            // 如果c[i]==c[i-1],说明同一数层有重复，跳过
            // 如果used[i-1]==false, 说明同一树层已经访问过，跳过
            // 如果used[i-1]==true, 说明同一树枝已经访问过
            if(i>0 && c[i] == c[i-1] && !used[i - 1]){
                continue;
            }
            // 检查是否被访问过
            if(used[i] == false){
                used[i] = true;
                path.append(Character.toString(c[i]));
                backtracking(c, used);
                // 回溯
                path.deleteCharAt(path.length()-1);
                used[i] = false;
            }
        }
    }
}
