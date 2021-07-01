import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/121/dynamic-programming/862/
 * Best Time to Buy and Sell Stock with Cooldown
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:
Input: prices = [1]
Output: 0

Constraints:
1 <= prices.length <= 5000
0 <= prices[i] <= 1000
*/

class Solution {
   //01
   public int maxProfit(int[] prices) {
      if (prices == null || prices.length <= 1)
         return 0;

      int b0 = -prices[0], b1 = b0;
      int s0 = 0, s1 = 0, s2 = 0;

      for (int i = 1; i < prices.length; i++) {
         b0 = Math.max(b1, s2 - prices[i]);
         s0 = Math.max(s1, b1 + prices[i]);
         b1 = b0;
         s2 = s1;
         s1 = s0;
      }
      return s0;
   }

   public void test(int[] prices, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), maxProfit(prices)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] prices = { 1, 2, 3, 0, 2 };
      int expect = 3;
      sol.test(prices, expect);

      prices = new int[] { 1 };
      expect = 0;
      sol.test(prices, expect);

   }
}

/*
01
210 / 210 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 36.7 MB
Your runtime beats 100.00 % of java submissions
Your memory usage beats 86.11 % of java submissions.
*/


