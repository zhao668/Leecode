package src.algorithm;

/**
 * 一维dp数组01背包
 * @author zjn
 * @date 2022/07/11
 **/
public class Backpack01II {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }

    private static void testWeightBagProblem(int[] weight, int[] value, int bagWight) {
        int wLen = weight.length;
        //定义dp数组， dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWight + 1];
        //遍历顺序，先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++) {
            for (int j = bagWight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWight; j++) {
            System.out.print(dp[j] + " ");
        }
    }
}
