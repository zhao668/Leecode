package src.algorithm;

/**
 * 01背包
 * @author zjn
 * @date 2022/07/07
 **/
public class Backpack01 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    private static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wlen = weight.length, value0 = 0;
        int[][] dp = new int[wlen + 1][bagSize + 1];
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = value0;
        }
        //遍历顺序，先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= wlen; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}