/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/816/
 * Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.
Follow up: Could you write a solution that works in logarithmic time complexity?

Example 1:
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:
Input: n = 0
Output: 0

Constraints:
0 <= n <= 104
 */

class Solution {
   //01
   public int trailingZeroes(int n) {
      int r = 0;
      while (n > 0) {
          n /= 5;
          r += n;
      }
      return r;
   }

   // Mine has issues
   // 5! -> 1
   // 10! -> 2
   // 15! -> 3
   public int trailingZeroes0(int n) {
      int k = 5;
      int sum = 0;
      while (n >= k) {
         sum += (n - n % k) / k;
         k *= k;
      }

      k = 100;
      while (n >= k) {
         sum -= (n - n % k) / k;
         k *= k;
      }

      return sum;
   }

   public void test(int n, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("trailingZeroes(%s): %s", n, trailingZeroes(n)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int n = 3;
      int expect = 0;
      // sol.test(n, expect);

      // n = 5;
      // expect = 1;
      // sol.test(n, expect);

      // n = 10;
      // expect = 2;
      // sol.test(n, expect);

      // n = 15;
      // expect = 3;
      // sol.test(n, expect);

      // n = 0;
      // expect = 0;
      // sol.test(n, expect);

      // n = 30;
      // expect = 7;
      // sol.test(n, expect);

      n = 30;
      expect = 7;
      sol.test(n, expect);

      n = 125;
      expect = 31;
      sol.test(n, expect);

      n = 100;
      expect = 24;
      sol.test(n, expect);

      n = 200;
      expect = 49;
      sol.test(n, expect);

      n = 1000;
      expect = 249;
      sol.test(n, expect);
   }
}

/*
Mine
Wrong Answer 
Input:
30
Output:
6
Expected:
7
*/

/*
01

*/
