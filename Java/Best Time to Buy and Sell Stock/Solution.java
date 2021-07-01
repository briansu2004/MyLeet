
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/572/
 * Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day. You want to maximize your profit by choosing a single day to
 * buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * Example 1: Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2
 * (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying
 * on day 2 and selling on day 1 is not allowed because you must buy before you
 * sell. Example 2: Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this
 * case, no transactions are done and the max profit = 0.
 * 
 * Constraints: 1 <= prices.length <= 105 0 <= prices[i] <= 104
 */

import java.util.Arrays;

class Solution {
    // 01
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else if (prices[i] - min > profit)
                profit = prices[i] - min;
        }
        System.gc();
        return profit;
    }

    // Mine
    public int maxProfitMine(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int max = 0;
        int low = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            if (prices[i] - low > max) {
                max = prices[i] - low;
            }
        }

        return max;
    }

    public void test(int[] prices) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), maxProfit(prices)));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        sol.test(prices);

        prices = new int[] { 7, 6, 4, 3, 1 };
        sol.test(prices);

        prices = new int[] { 10, 1, 8, 0, 3, 4 };
        sol.test(prices);

        prices = new int[] { 10, 30, 5, 15, 0, 20 };
        sol.test(prices);
    }
}

/*
 * 01
 * 211 / 211 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 55.9 MB
 * Your runtime beats 100.00 % of java submissions
 * Your memory usage beats 6.34 % of java submissions
 * 
 */

/*
 * Mine 211 / 211 test cases passed. Status: Accepted Runtime: 2 ms Memory
 * Usage: 52 MB Your runtime beats 59.53 % of java submissions. Your memory
 * usage beats 72.12 % of java submissions. *
 */