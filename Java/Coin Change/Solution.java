/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/809/
 * Coin Change
 * 
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:
Input: coins = [1], amount = 0
Output: 0
Example 4:
Input: coins = [1], amount = 1
Output: 1
Example 5:
Input: coins = [1], amount = 2
Output: 2

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */

import java.util.Arrays;
import java.util.TreeSet;

class Solution {
   // 03
   private static final int NA = 10001;

   public int coinChange(int[] coins, int amount) {
      if (amount == 0)
         return 0;

      Arrays.sort(coins);
      int maxCoin = coins[coins.length - 1];
      int div = amount / maxCoin;
      int mul = div * maxCoin;
      if (mul == amount)
         return div;

      return (div > 20) ? coinChangeDP(coins, amount) : coinChangeRecursive(coins, amount);
   }

   private static int coinChangeDP(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, NA);
      dp[0] = 0;

      for (int c : coins) {
         for (int a = c; a <= amount; a++) {
            dp[a] = Math.min(dp[a], dp[a - c] + 1);
         }
      }

      return (dp[amount] == NA) ? -1 : dp[amount];
   }

   private static int coinChangeRecursive(int[] coins, int amount) {
      int[] min = new int[] { Integer.MAX_VALUE };
      coinChangeRecursive(coins, amount, coins.length - 1, 0, min);
      return (min[0] == Integer.MAX_VALUE) ? -1 : min[0];
   }

   private static void coinChangeRecursive(int[] coins, int amount, int idx, int count, int[] min) {
      if (idx == -1)
         return;

      int c = coins[idx--];

      if (c > amount) {
         coinChangeRecursive(coins, amount, idx, count, min);
         return;
      }

      int n = amount / c;
      int remain = amount - n * c;

      if (remain == 0) {
         min[0] = Math.min(min[0], n + count);
         return;
      }

      if (idx == -1)
         return;

      for (; n >= 0; n--, remain = amount - n * c) {
         int cnt = count + n;
         if (cnt < min[0])
            coinChangeRecursive(coins, remain, idx, cnt, min);
         else
            return;
      }
   }

   //02
   public int coinChange2(int[] coins, int amount) {
      int max = amount + 1;
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, max);
      dp[0] = 0;

      for (int i = 0; i <= amount; i++) {
         int min = -1;
         for (int coin : coins) {
            if (i >= coin) {
               dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
         }
      }
      return dp[amount] == max ? -1 : dp[amount];
   }

   // 01
   public static int coinChange1(int[] coins, int amount) {
      if (coins == null || coins.length == 0 || amount <= 0) {
         return 0;
      }

      int[] minNumber = new int[amount + 1];
      for (int i = 1; i <= amount; i++) {
         minNumber[i] = Integer.MAX_VALUE;
         for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE) {
               minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
         }
      }
      if (minNumber[amount] == Integer.MAX_VALUE) {
         return -1;
      } else {
         return minNumber[amount];
      }
   }

   // Mine has issues
   public int coinChange0(int[] coins, int amount) {
      if (amount == 0) {
         return 0;
      }

      if (coins.length == 1) {
         if (amount % coins[0] == 0) {
            return amount / coins[0];
         } else {
            return -1;
         }
      }

      TreeSet<Integer> set = new TreeSet<Integer>();
      for (int i = 0; i < coins.length; i++) {
         set.add(Integer.valueOf(coins[i]));
      }

      int cnt = 0;
      while (set.size() > 0) {
         int max = set.last();
         if (max == 0) {
            return -1;
         }

         cnt += (amount - amount % max) / max;
         amount = amount % max;
         set.remove(max);
      }

      if (amount > 0) {
         return -1;
      }

      return cnt;
   }

   public void test(int[] coins, int amount, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(
            String.format("coinChange(%s, %s): %s", Arrays.toString(coins), amount, coinChange(coins, amount)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] coins = { 1 };
      int amount = 2;
      int expect = 2;
      sol.test(coins, amount, expect);

      coins = new int[] { 1 };
      amount = 1;
      expect = 1;
      sol.test(coins, amount, expect);

      coins = new int[] { 1 };
      amount = 0;
      expect = 0;
      sol.test(coins, amount, expect);

      coins = new int[] { 2 };
      amount = 3;
      expect = -1;
      sol.test(coins, amount, expect);

      coins = new int[] { 1, 2, 5 };
      amount = 11;
      expect = 3;
      sol.test(coins, amount, expect);

      // 6249-408*15=129
      // 129-83=46
      coins = new int[] { 186, 419, 83, 408 };
      amount = 6249;
      expect = 20;
      sol.test(coins, amount, expect);
   }
}

/*
Mine
Input:
[186,419,83,408]
6249
Output:
-1
Expected:
20
*/

/*
01
188 / 188 test cases passed.
Status: Accepted
Runtime: 23 ms
Memory Usage: 38.1 MB
*/

/*
02
188 / 188 test cases passed.
Status: Accepted
Runtime: 27 ms
Memory Usage: 41.9 MB
*/

/*
03
188 / 188 test cases passed.
Status: Accepted
Runtime: 12 ms
Memory Usage: 39.7 MB
*/
