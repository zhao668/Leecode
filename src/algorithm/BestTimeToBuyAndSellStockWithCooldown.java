package src.algorithm;

/**
 * 最佳买卖股票时机含冷冻期
 * @author zjn
 * @date 2022/07/15
 **/
public class BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int[] dp = new int[4];
        //dp[i][j]，第i天状态为j，所剩的最多现金为dp[i][j]
        //状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
        //状态二：两天前就卖出了股票，度过了冷冻期，一直没有操作，今天保持卖出股票状态
        //状态三：今天卖出了股票
        //状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            int temp1 = dp[0];
            int temp2 = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp1 + prices[i - 1];
            dp[3] = temp2;
        }
        return Math.max(dp[3], Math.max(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
}

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
