package Bishi;

import javafx.beans.binding.ObjectExpression;

import java.util.*;

public class huawei0 {
    public static void main(String[] args) {
//        跳台阶输入
//        int[] nums = {2,1,1,5,6,2,3};
//        System.out.println(jump(nums,3));
//        分组输入
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int in = N;
//        ArrayList<String[]> al = new ArrayList<>();
//        while (in-- > 0) {
//            String[] s = new String[2];
//            s[0] = sc.next();
//            s[1] = sc.next();
//            al.add(s);
//        }
//        System.out.println(divide(N, al));
//        计算任务执行时间输入
//        Scanner sc = new Scanner(System.in);
//        String tasks = sc.nextLine();
//        String relations = sc.nextLine();
//        String res = computeTime(tasks, relations);
//        System.out.println(res);
//        String regex = "\\.\\s*";
//        String str = "Alphs.Beta.Gamma.";
//        String[] result = str.split(regex);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
        System.out.println(6&3);

    }

    // 带条件限制的跳台阶
    public static int jump(int[] nums, int k) {
        int res = 0, prior = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(cur, nums[i] + i);
            if (cur >= nums.length) {
                return ++res;
            }
            if (i == prior) {
                prior = cur;
                ++res;
                if (res >= k) {
                    return -1;
                }
            }
        }
        return res;
    }

    // 给小朋友分组
    public static int divide(int N, ArrayList<String[]> al) {
        Map<String, Integer> map = new HashMap<>();
        int mark = 1;
        int res = 1;
        if (N > 0) {
            map.put(al.get(0)[0], mark);
            map.put(al.get(0)[1], mark);
        }
        for (int i = 1; i < N; i++) {
            String key1 = al.get(i)[0];
            String key2 = al.get(i)[1];
            // 可能得到空值
            Object value1 = map.get(key1);
            Object value2 = map.get(key2);
//            System.out.println(value1);
//            System.out.println(value2);
            // 如果出现两个key得到的value不同，需要将两个key的value改为较小的value,以及和两个key相关联的key的value也需要修改
            if (value1 != null && value2 != null && value1 != value2) {
                // 遍历map,如果有这两个key对应的相同value，都修改
                int minValue = map.get(key1) < map.get(key2) ? map.get(key1) : map.get(key2);
                int maxValue = map.get(key1) > map.get(key2) ? map.get(key1) : map.get(key2);
                map.put(key1, minValue);
                map.put(key2, minValue);
                for (String key : map.keySet()) {
                    if (map.get(key) == maxValue) {
                        map.put(key, minValue);
                    }
                }
                res--;
            } else {
                if (map.containsKey(key1)) {
                    map.put(key2, map.get(key1));
                } else if (map.containsKey(key2)) {
                    map.put(key1, map.get(key2));
                } else {
                    // 如果都没有，就重新建立一个分组
                    mark++;
                    res++;
                    map.put(key1, mark);
                    map.put(key2, mark);
                }
            }
        }
//        Set<Integer> hs = new HashSet<>(map.values());
        return res;
    }
//测试用例
//6
//        Jack Tom
//        Alice John
//        Jessica Leonie
//        Tom Alice
//        John Jack
//        Leonie Jessica


    // https://blog.csdn.net/weixin_42669700/article/details/120203034
// 计算任务实际执行时间=执行时间+等待时间
// 任务本来按顺序排队，当任务发现有依赖执行的任务未执行时，重新到队尾排队
//    任务：下标、时间 依赖关系：任务下标和任务下标
// 输入：任务按顺序存入队列，任务的下标和完成时间也是用哈希表表示，依赖关系用哈希表表示，输入是用逗号间隔的字符串，依赖关系用->间隔
// 输出: 任务的执行时间需要按照原始输入任务的顺序输出，输出是用逗号间隔的字符串
    private static String computeTime(String tasks, String relations) {
//        处理任务
        String[] s = tasks.split(",");
        Map<Integer, Integer> indexMapTime = new HashMap<>();
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            que.add(i);
            indexMapTime.put(i, Integer.parseInt(s[i]));
        }
//        结果
        int[] res = new int[que.size()];
//        标记时间
        int totalTime = 0;
//        关系
        String[] rela = relations.split(",");
//        考虑哈希冲突,value用list表示
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (String r : rela) {
            String[] taskPair = r.split("->");
            if (map.containsKey(Integer.parseInt(taskPair[0]))) {
                // 添加依赖的任务
                map.get(Integer.parseInt(taskPair[0])).add(Integer.parseInt(taskPair[1]));
            } else {
                // 不存在这个key
                List<Integer> lst = new LinkedList<>();
                lst.add(Integer.parseInt(taskPair[1]));
                map.put(Integer.parseInt(taskPair[0]), lst);
            }
        }

        // 遍历任务
        while (!que.isEmpty()) {
            // 出队头
            int taskIndex = que.remove();
            // 查找有无依赖的任务
            if (map.containsKey(taskIndex)) {
                // 获取lst
                List<Integer> lst = map.get(taskIndex);
                // 删除已经完成的任务
                List<Integer> newlst = new LinkedList<>();
                for (Integer integer : lst) {
                    if (res[integer] == 0) {
                        // 说明当前任务依赖的任务已经完成了
                        newlst.add(integer);
                    }
                }
                if (newlst.size() == 0) {
                    // 新的列表为空，说明当前已经完成所有依赖的任务了
                    totalTime += indexMapTime.get(taskIndex);
                    res[taskIndex] = totalTime;
                } else {
                    // 有依赖的任务，将当前的任务插入到队列尾
                    que.add(taskIndex);
                }
            } else {
                // 没有依赖的任务,直接执行,将当前任务移出队列
                totalTime += indexMapTime.get(taskIndex);
                res[taskIndex] = totalTime;
                // 将map中的依赖数据删除
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
            if (i != res.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}




