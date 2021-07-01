/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/121/dynamic-programming/866/
 * Burst Balloons
 * 
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:
Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:
Input: nums = [1,5]
Output: 10

Constraints:
n == nums.length
1 <= n <= 500
0 <= nums[i] <= 100
*/

import java.util.Arrays;

class Solution {
   //02
   public int maxCoins(int[] nums) {
      int[] numsCopy = new int[nums.length + 2];
      int n = 1;
      for (int i : nums) {
         numsCopy[n++] = i;
      }
      numsCopy[0] = 1;
      numsCopy[n++] = 1;
      int[][] dp = new int[n][n];
      for (int len = 0; len < n; len++) {
         for (int j = len; j < n; j++) {
            int i = j - len, prd = numsCopy[i] * numsCopy[j], temp = 0;
            for (int k = i + 1; k < j; k++) {
               temp = Math.max(temp, dp[i][k] + dp[k][j] + numsCopy[k] * prd);
            }
            dp[i][j] = temp;
         }
      }
      return dp[0][n - 1];
   }

   //01
   public int maxCoins1(int[] nums) {
      int[][] dp = new int[nums.length][nums.length];
      return maxCoins(nums, 0, nums.length - 1, dp);
   }

   public int maxCoins(int[] nums, int start, int end, int[][] dp) {
      if (start > end) {
         return 0;
      }
      if (dp[start][end] != 0) {
         return dp[start][end];
      }
      int max = nums[start];
      for (int i = start; i <= end; i++) {
         int val = maxCoins(nums, start, i - 1, dp) + get(nums, i) * get(nums, start - 1) * get(nums, end + 1)
               + maxCoins(nums, i + 1, end, dp);

         max = Math.max(max, val);
      }
      dp[start][end] = max;
      return max;
   }

   public int get(int[] nums, int i) {
      if (i == -1 || i == nums.length) {
         return 1;
      }
      return nums[i];
   }

   public void test(int[] nums, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("maxCoins(%s): %s", Arrays.toString(nums), maxCoins(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 3,1,5,8 };
      int expect = 167;
      sol.test(nums, expect);

      nums = new int[] { 1, 5 };
      expect = 10;
      sol.test(nums, expect);

   }
}

/*
01
70 / 70 test cases passed.
Status: Accepted
Runtime: 177 ms
Memory Usage: 38.5 MB

02
70 / 70 test cases passed.
Status: Accepted
Runtime: 51 ms
Memory Usage: 38.7 MB
Your runtime beats 99.50 % of java submissions
*/


