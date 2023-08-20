package no;

import java.util.LinkedList;

public class StockSpanner {
    LinkedList<Integer> list;
    LinkedList<Integer> kuadu;

    public StockSpanner() {
        list = new LinkedList<>();
        kuadu = new LinkedList<>();
    }

    public int next(int price) {
        // 股票的跨度是股票价格小于或等于今天价格的最大连续日数(重点是连续)
        int count = 1;
        int n = list.size() - 1;
        // 从后向前遍历统计，遇到大于今日价格的股价就停止
        for (int i = n; i >= 0; ) {
            if (price >= list.get(i)) {
                count += kuadu.get(i);
                i -= kuadu.get(i);
            } else {
                break;
            }
        }
        list.add(price);
        kuadu.add(count);
        return count;
    }

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(2402));
        System.out.println(s.next(9532));
        System.out.println(s.next(2879));
        System.out.println(s.next(2809));
        System.out.println(s.next(3523));
    }
}
