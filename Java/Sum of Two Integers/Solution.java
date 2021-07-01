/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/822/
 * Sum of Two Integers

Solution
Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
 

Constraints:

-1000 <= a, b <= 1000
 */

class Solution {
   // 01
   // a^b is the sum of a and b bitwise without carrier, 
   // (a&b)<<1 is the carrier computation bitwise, 
   // when the carrier is equal to 0, the recursion terminate, the code is much like Euclidean gcd
   public int getSum(int a, int b) {
      return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
   }

   public void test(int a, int b, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("divide(%s, %s): %s", a, b, getSum(a, b)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int a = 1;
      int b = 2;
      int expect = 3;
      sol.test(a, b, expect);

      a = 2;
      b = 3;
      expect = 5;
      sol.test(a, b, expect);

   }
}

/*
01
13 / 13 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 37.4 MB
*/
