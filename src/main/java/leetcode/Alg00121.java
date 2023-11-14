package leetcode;

/**
 * 买卖股票的最佳时机
 *
 * @author hzzhou
 * @since 2023-11-13
 */
public class Alg00121 {

    public static void main(String[] args) {
        int[] grid = new int[]{7,1,5,3,6,4};
        Alg00121 alg = new Alg00121();
        System.out.println(alg.maxProfit(grid));
    }

    /**
     * 方法一：暴力法【超时】
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 方法二：一次遍历
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
