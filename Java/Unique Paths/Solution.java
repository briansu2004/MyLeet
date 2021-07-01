/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/
 * Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Example 1:
Input: m = 3, n = 7
Output: 28
Example 2:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:
Input: m = 7, n = 3
Output: 28
Example 4:
Input: m = 3, n = 3
Output: 6

Constraints:
1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
 * 
 */

import java.util.Arrays;

class Solution {
   // 02
   // https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/discuss/241181/Java-Solutions
   public int uniquePaths(int m, int n) {
      int[] cur = new int[m];
      Arrays.fill(cur, 1);

      for (int i = 1; i < n; i++) {
         for (int j = 1; j < m; j++) {
            // current cell = top cell + left cell cur[j] = cur[j] + cur[j - 1]
            cur[j] += cur[j - 1];
         }
      }
      return cur[m - 1];
   }

   // 01
   // select m (or n) from [(m-1)+(n-1)]
   public int uniquePaths1(int m, int n) {
      int smaller = m > n ? n - 1 : m - 1;
      int totalsteps = m + n - 2;
      long result = 1;
      for (int counter = 1; counter <= smaller; counter++) {
         result *= totalsteps--;
         result /= counter;
      }
      return (int) result;
   }

   // Mine has issues
   public int uniquePaths0(int m, int n) {
      int smaller = m > n ? n - 1 : m - 1;
      int totalsteps = m + n - 2;
      int result = 1;
      for (int counter = 1; counter <= smaller; counter++) {
         result *= totalsteps--;
         result /= counter;
      }
      return result;
   }

   public void test(int m, int n, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("canJump(%s, %s): %s", m, n, uniquePaths(m, n)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int m = 3;
      int n = 7;
      int expect = 28;
      sol.test(m, n, expect);

      m = 7;
      n = 3;
      expect = 28;
      sol.test(m, n, expect);

      m = 3;
      n = 2;
      expect = 3;
      sol.test(m, n, expect);

      m = 3;
      n = 3;
      expect = 6;
      sol.test(m, n, expect);

      m = 51;
      n = 9;
      expect = 1916797311;
      sol.test(m, n, expect);
   }
}


/*
Mine
Input:
51
9
Output:
-230686337
Expected:
1916797311
*/

/*
*01
62 / 62 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 35.8 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 52.75 % of java submissions.
*/

/*
02
62 / 62 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 35.7 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 67.10 % of java submissions.
*/
