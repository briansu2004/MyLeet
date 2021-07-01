
/**
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
Best Time to Buy and Sell Stock II

You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e., max profit = 0.

Constraints:
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
*/

import java.util.Arrays;

class Solution {
    //01
    public int maxProfit(int[] prices) {
        int ans = 0;
        int curr = 0;
        for(int i=1;i<prices.length;i++){
            curr = prices[i]-prices[i-1];
            if(curr>0){
                ans += curr;
            }
        }
        return ans;
    }

    public int maxProfitMine(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        if (prices.length == 2) {
            if (prices[1] > prices[0]) {
                return prices[1] - prices[0];
            }
            return 0;
        }

        boolean isUp = (prices[1] > prices[0] ? true : false);
        int sum = (isUp ? prices[1] - prices[0] : 0);

        for (int i = 1; i < prices.length - 1; i++) {
            if (isUp) {
                if (prices[i] < prices[i + 1]) {
                    // //
                    // isUp = true;
                    sum += prices[i + 1] - prices[i];
                } else {
                    // /= /\
                    isUp = false;
                }

            } else {
                // \
                if (prices[i] < prices[i + 1]) {
                    // \/
                    isUp = true;
                    sum += prices[i + 1] - prices[i];
                } else {
                    // \\
                    isUp = false;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] prices = new int[] {};
        System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), sol.maxProfit(prices)));

        prices = new int[] { 1 };
        System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), sol.maxProfit(prices)));

        prices = new int[] { 3, 9 };
        System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), sol.maxProfit(prices)));

        prices = new int[] { 6, 4 };
        System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), sol.maxProfit(prices)));

        prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), sol.maxProfit(prices)));

        prices = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), sol.maxProfit(prices)));

        prices = new int[] { 7, 6, 4, 3, 1 };
        System.out.println(String.format("maxProfit(%s): %s", Arrays.toString(prices), sol.maxProfit(prices)));

    }
}


/*
200 / 200 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38.8 MB
Your memory usage beats 26.31 % of java submissions.
*/

/*
#01
200 / 200 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 38.2 MB
our memory usage beats 92.64 % of java submissions.
*/