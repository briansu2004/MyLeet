
/**
 *
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/878/
 * Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Example 2:
Input: s = "IV"
Output: 4
Example 3:
Input: s = "IX"
Output: 9
Example 4:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

   Hide Hint #1  
Problem is simpler to solve by working the string from back to front and using a map.
 * 
 */



class Solution {
   // 01
   public int romanToInt(String s) {
      int[] map = new int[89];
      map['I'] = 1;
      map['V'] = 5;
      map['X'] = 10;
      map['L'] = 50;
      map['C'] = 100;
      map['D'] = 500;
      map['M'] = 1000;

      int ret = 0, pre = 1;
      for (int i = s.length() - 1; i >= 0; i--) {
         int cur = map[s.charAt(i)];
         if (cur < pre) {
            ret -= cur;
         } else {
            pre = cur;
            ret += cur;
         }
      }
      return ret;
   }


   public void test(String s, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("romanToInt(%s): %s", s, romanToInt(s)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }


 
   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "III";
      sol.test(s, 3);

      s = "IV";
      sol.test(s, 4);

      s = "IX";
      sol.test(s, 9);

      s = "LVIII";
      sol.test(s, 58);

      s = "MCMXCIV";
      sol.test(s, 1994);
   }
}

/*
* 01
3999 / 3999 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 39.2 MB
 */
