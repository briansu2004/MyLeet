
/**
 *
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/745/
 * Power of Three
 * 
 * Given an integer n, return true if it is a power of three. Otherwise, return
 * false. An integer n is a power of three, if there exists an integer x such
 * that n == 3x.
 * 
 * Example 1: Input: n = 27 Output: true Example 2: Input: n = 0 Output: false
 * Example 3: Input: n = 9 Output: true Example 4: Input: n = 45 Output: false
 * 
 * Constraints: -231 <= n <= 231 - 1
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 */



class Solution {
   // 01
   public boolean isPowerOfThree(int n) {
      if (n < 1) {
         return false;
      }

      while (n % 3 == 0) {
            n /= 3;
      }

      return n == 1;
   }

   public boolean isPowerOfThreeMine(int n) {
      if (n == 1) {
         return true;
      }
      
      if (n < 1 || n % 3 != 0) {
         return false;
      }

      while (n > 3) {
         n /= 3; 
         if (n % 3 != 0) {
            return false;
         }
      }

      if (n == 1 || n == 3) {
         return true;
      } else {
         return false;
      }
   }

   public void test(int n, boolean expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("isPowerOfThree(%s): %s", n, isPowerOfThree(n)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }


 
   public static void main(String[] args) {
      Solution sol = new Solution();

      int n = 0;
      sol.test(n, false);

      n = 1;
      sol.test(n, true);

      n = 2;
      sol.test(n, false);

      n = 3;
      sol.test(n, true);

      n = 4;
      sol.test(n, false);

      n = 9;
      sol.test(n, true);

      n = 27;
      sol.test(n, true);

      n = 45;
      sol.test(n, false);
   }

}

/*
* 01
21038 / 21038 test cases passed.
Status: Accepted
Runtime: 10 ms
Memory Usage: 38.4 MB
*/

/*
 * Mine
 * 21038 / 21038 test cases passed.
Status: Accepted
Runtime: 10 ms
Memory Usage: 38.9 MB
Your runtime beats 99.88 % of java submissions.
Your memory usage beats 37.41 % of java submissions.
 */
