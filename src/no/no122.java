package no;

public class no122 {
    // 贪心思想，求两天之间的利润，利润为负，不加，利润为正，加
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res + prices[i] - prices[i - 1], res);
        }
        return res;
    }
    // 动态规划

}
