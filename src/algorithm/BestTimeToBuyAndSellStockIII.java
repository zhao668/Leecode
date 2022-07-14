package src.algorithm;

/**
 * 买卖股票的最佳时机III
 * @author zjn
 * @date 2022/07/14
 **/
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        //dp[0]代表第一次交易的买入
        dp[0] = -prices[0];
        //dp[1]代表第一次交易的卖出
        dp[1] = 0;
        //dp[2]代表第二次交易的买入
        dp[2] = -prices[0];
        //dp[3]代表第二次交易的卖出
        dp[3] = 0;
        for (int i = 1; i <= prices.length; i++) {
            //要么保持不变，要么没有就买，有了就卖
            dp[0] = Math.max(dp[0], -prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
            //这已经是第二次交易了，所以得加上前一次交易卖出去的收获
            dp[2] = Math.max(dp[2], dp[1] - prices[i - 1]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i - 1]);
        }
        return dp[3];
    }
}

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 */
