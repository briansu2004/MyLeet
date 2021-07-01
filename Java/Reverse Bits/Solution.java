
/**
 * * https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/648/
 * Reverse Bits

Reverse bits of a given 32 bits unsigned integer.
Note:
Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
Follow up:
If this function is called many times, how would you optimize it?

Example 1:
Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:
Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.

Constraints:
The input must be a binary string of length 32
 * 
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
   // you need to treat n as an unsigned value


   // 01
   // cache
   private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
   
   public int reverseBits(int n) {
      byte[] bytes = new byte[4];
      for (int i = 0; i < 4; i++) // convert int into 4 bytes
         bytes[i] = (byte)((n >>> 8*i) & 0xFF);
      int result = 0;
      for (int i = 0; i < 4; i++) {
         result += reverseByte(bytes[i]); // reverse per byte
         if (i < 3)
               result <<= 8;
      }
      return result;
   }

   private int reverseByte(byte b) {
      Integer value = cache.get(b); // first look up from cache
      if (value != null)
         return value;
      value = 0;
      // reverse by bit
      for (int i = 0; i < 8; i++) {
         value += ((b >>> i) & 1);
         if (i < 7)
               value <<= 1;
      }
      cache.put(b, value);
      return value;
   }

   public void test(int s, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("reverseBits(%s): %s", s, reverseBits(s)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int s = 00000000000000000000000010011100;
      sol.test(s, 956301312);

      // int s = 00000010100101000001111010011100;
      // sol.test(s, 964176192);

      // s = 11111111111111111111111111111101;
      // sol.test(s, 3221225471);

   }
}

/*
* 01
600 / 600 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38.8 MB
 */