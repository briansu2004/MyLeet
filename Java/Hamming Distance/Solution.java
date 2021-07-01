
/**
 *
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/762/
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

Example 1:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:
Input: x = 3, y = 1
Output: 1
 
Constraints:
0 <= x, y <= 231 - 1
 * 
 */

class Solution {
   // 01
   public int hammingDistance(int x, int y) {
      int val = x ^ y;
      int count = 0;
      while (val != 0) {
         int firstBit = val & 1;
         if (firstBit == 1) {
            count++;
         }
         val = val >>> 1;
      }
      return count;
   }

   // Mine
   public int hammingDistanceMine(int x, int y) {
      return hammingWeight(x ^ y);
   }

   public int hammingWeight(int n) {
      int count = 0;
      int mask = 1;
      for (int i = 0; i < 32; i++) {
         if ((n & mask) != 0) {
            count++;
         }
         mask = mask << 1;
      }
      return count;
   }

   public void test(int x, int y, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("hammingDistance(%s, %s): %s", x, y, hammingDistance(x, y)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int x = 1, y = 4;
      sol.test(x, y, 2);

      x = 3;
      y = 1;
      sol.test(x, y, 1);

   }
}

/*
* Mine
149 / 149 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 35.6 MB
Your memory usage beats 77.09 % of java submissions.
 */