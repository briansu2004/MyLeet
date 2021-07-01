
/**
 *
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/565/
 * Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:
Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 
Example 1:
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:
Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:
Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

Constraints:
The input must be a binary string of length 32.
 
Follow up: If this function is called many times, how would you optimize it?
 * 
 */

class Solution {
   // you need to treat n as an unsigned value

   // 02
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

   // 01
   public int hammingWeight1(int n) {
      int ones = 0;
      while (n != 0) {
         ones = ones + (n & 1);
         n = n >>> 1;
      }
      return ones;
   }

   public void test(int s, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("hammingWeight(%s): %s", s, hammingWeight(s)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int s = 00000000000000000000000010000000;
      sol.test(s, 1);

      s = 00000000000000000000000000001011;
      sol.test(s, 3);

   }
}

/*
* 01
601 / 601 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 36.2 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 16.13 % of java submissions.
 */

 /*
601 / 601 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 36 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 25.70 % of java submissions.
 */