package recursion_divide_conquer;

/**
 * @author Zeller
 * @Link <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/"> </a>
 * @Description 股票最佳买卖时间
 * @Date 2018/11/23
 **/
public class BestTimeToBuyandSellStock {
    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println("output:" + maxProfit(input));
    }

    public static int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                count += (prices[i + 1] - prices[i]);
            }
        }
        return count;
    }

}
