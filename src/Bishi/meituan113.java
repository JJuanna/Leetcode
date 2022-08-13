package Bishi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


/*
* 输入和输出的性能问题
*数据量大的话，最好用BufferedReader，数据量小就没所谓了。
* System.out默认每调用一次write都会直接flush，相当于没有使用缓冲区；
* Scanner虽然用了缓冲区，但它读取特定类型数据是通过正则匹配实现的，速度相对也是较慢的。
* 这道题运行超时就是因为数据量很大，读取和输出答案的时候性能比较差
* 所以要尽量使用BufferedReader和BufferedWriter
* */
public class meituan113 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(sc.readLine());
        while (n-- > 0) {
            int zhuoziNum = Integer.parseInt(sc.readLine());
            String str = sc.readLine();
            int[] zhuozi = new int[zhuoziNum];
            for (int i = 0; i < zhuoziNum; i++) {
                zhuozi[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            int personNum = Integer.parseInt(sc.readLine());
            String personSex = sc.readLine();
            int[] res = stackPredict(zhuoziNum, zhuozi, personNum, personSex);
            for(int r:res){
                writer.write(Integer.toString(r));
                writer.newLine();
            }
        }
        writer.flush();
    }


    private static void predict(int zhuoziNum, int[] zhuozi, int personNum, String personSex) {
        // 模拟题
        for (int i = 0; i < personNum; i++) {
            char sex = personSex.charAt(i);
            boolean flag = false;
            if (sex == 'M') {
                // 男性，优先选择有一个人的座位
                for (int j = 0; j < zhuoziNum; j++) {
                    if (zhuozi[j] == 1) {
                        zhuozi[j] += 1;
                        flag = true;
                        System.out.println(j + 1);
                        break;
                    }
                }
                if (!flag) {
                    for (int j = 0; j < zhuoziNum; j++) {
                        if (zhuozi[j] == 0) {
                            zhuozi[j] += 1;
                            flag = true;
                            System.out.println(j + 1);
                            break;
                        }
                    }
                }
            } else if (sex == 'F') {
                for (int j = 0; j < zhuoziNum; j++) {
                    if (zhuozi[j] == 0) {
                        zhuozi[j] += 1;
                        flag = true;
                        System.out.println(j + 1);
                        break;
                    }
                }
                if (!flag) {
                    for (int j = 0; j < zhuoziNum; j++) {
                        if (zhuozi[j] == 1) {
                            zhuozi[j] += 1;
                            flag = true;
                            System.out.println(j + 1);
                            break;
                        }
                    }
                }

            }
        }
    }

    // 使用三个小根堆存储分别有0，1，2个人的桌子的桌号
    // 选择合适的数据结构
    // 本质上是查找，所以算法优化要向查找优化
    private static int[] stackPredict(int zhuoziNum, int[] zhuozi, int personNum, String personSex) {
        // 设置三个堆
        List<PriorityQueue<Integer>> pqs = new ArrayList<>();
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        // 建堆
        for (int i = 0; i < zhuozi.length; i++) {
            pqs.get(zhuozi[i]).add(i);
        }
        int[] res = new int[personNum];
        for (int i = 0; i < personNum; i++) {
            int table;
            if (personSex.charAt(i) == 'M') {
                if (pqs.get(1).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            } else {
                if(!pqs.get(0).isEmpty()){
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                }else{
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            }
            res[i]=table+1;
        }
        return res;
    }
}
