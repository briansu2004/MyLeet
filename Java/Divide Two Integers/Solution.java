/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/820/
 * Divide Two Integers
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
Return the quotient after dividing dividend by divisor.
The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
Example 3:
Input: dividend = 0, divisor = 1
Output: 0
Example 4:
Input: dividend = 1, divisor = 1
Output: 1

Constraints:
-231 <= dividend, divisor <= 231 - 1
divisor != 0
 */

class Solution {
   // 01
   public int divide(int A, int B) {
      if (A == 1 << 31 && B == -1)
         return (1 << 31) - 1;
      int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
      while (a - b >= 0) {
         for (x = 0; a - (b << x << 1) >= 0; x++)
            ;
         res += 1 << x;
         a -= b << x;
      }
      return (A > 0) == (B > 0) ? res : -res;
   }

   // Mine
   public int divide0(int dividend, int divisor) {
      int n = (int) (((long) dividend - (long) dividend % (long) divisor) / (long) divisor);

      if (n > Integer.MAX_VALUE) {
         n = Integer.MAX_VALUE;
      } else if (n < Integer.MIN_VALUE) {
         n = Integer.MIN_VALUE;
      }

      return n;
   }

   public void test(int dividend, int divisor, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("divide(%s, %s): %s", dividend, divisor, divide(dividend, divisor)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int dividend = 10;
      int divisor = 3;
      int expect = 3;
      sol.test(dividend, divisor, expect);

      dividend = 7;
      divisor = -3;
      expect = -2;
      sol.test(dividend, divisor, expect);

      dividend = 1;
      divisor = 1;
      expect = 1;
      sol.test(dividend, divisor, expect);
      
      dividend = 0;
      divisor = 1;
      expect = 0;
      sol.test(dividend, divisor, expect);

      dividend = -2147483648;
      divisor = -1;
      expect = 2147483647;
      sol.test(dividend, divisor, expect);
   }
}

/*
Mine
Wrong Answer
Input:
-2147483648
-1
Output:
-2147483648
Expected:
2147483647
*/

/*
992 / 992 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 36 MB
Your runtime beats 100.00 % of java submissions.
*/
