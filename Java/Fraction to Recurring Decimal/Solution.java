import java.util.HashMap;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/821/
 * Fraction to Recurring Decimal

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
If multiple answers are possible, return any of them.
It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:
Input: numerator = 2, denominator = 1
Output: "2"
Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"
Example 4:
Input: numerator = 4, denominator = 333
Output: "0.(012)"
Example 5:
Input: numerator = 1, denominator = 5
Output: "0.2"

Constraints:
-231 <= numerator, denominator <= 231 - 1
denominator != 0
   Hide Hint #1  
No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
   Hide Hint #2  
Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
   Hide Hint #3  
Notice that once the remainder starts repeating, so does the divided result.
   Hide Hint #4  
Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.
 */

class Solution {
   //02
   public String fractionToDecimal(int numerator, int denominator) {
      // If numerator is 0, answer will be 0
      if (numerator == 0)
         return "0";
      StringBuilder decimal = new StringBuilder();
      // Use XOR to check if the result contains negative sign
      // XOR returns true if both inputs are different i.e. if either the numerator or
      // the denominator is negative
      if (numerator < 0 ^ denominator < 0)
         decimal.append("-");
      // Use long to represent dividend and divisor to handle edge cases i.e. if
      // either
      // numerator or denominator are Integer.MAX_VALUE or Integer.MIN_VALUE
      long dividend = Math.abs(Long.valueOf(numerator));
      long divisor = Math.abs(Long.valueOf(denominator));
      // Append the quotient to result
      decimal.append(dividend / divisor);
      long remainder = dividend % divisor;
      // If the remainder is 0, division process is complete
      if (remainder == 0)
         return decimal.toString();
      // Append the decimal point to result
      decimal.append(".");
      // Perform long division and store the remainder and its position in the result
      // in a HashMap. The position is used to insert parentheses for the recurring
      // part
      HashMap<Long, Integer> position = new HashMap<>();
      while (remainder != 0) {
         // If the remainder is repeated, it means the recurring part has been found
         if (position.containsKey(remainder)) {
            decimal.insert(position.get(remainder), "(");
            decimal.append(")");
            return decimal.toString();
         }
         // Store the position of the remainder
         position.put(remainder, decimal.length());
         // Multiply remainder with 10 for the next long division process
         remainder *= 10;
         // Append the quotient to result
         decimal.append(remainder / divisor);
         // Update the remainder
         remainder %= divisor;
      }
      return decimal.toString();
   }

   //01
   public String fractionToDecimal1(int numerator, int denominator) {
      if (numerator == 0) {
         return "0";
      }
      StringBuilder res = new StringBuilder();
      // "+" or "-"
      res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
      long num = Math.abs((long) numerator);
      long den = Math.abs((long) denominator);

      // integral part
      res.append(num / den);
      num %= den;
      if (num == 0) {
         return res.toString();
      }

      // fractional part
      res.append(".");
      HashMap<Long, Integer> map = new HashMap<Long, Integer>();
      map.put(num, res.length());
      while (num != 0) {
         num *= 10;
         res.append(num / den);
         num %= den;
         if (map.containsKey(num)) {
            int index = map.get(num);
            res.insert(index, "(");
            res.append(")");
            break;
         } else {
            map.put(num, res.length());
         }
      }
      return res.toString();
   }

   public void test(int numerator, int denominator, String expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("fractionToDecimal(%s, %s): %s", numerator, denominator, fractionToDecimal(numerator, denominator)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int numerator = 10;
      int denominator = 3;
      String expect = "3.(3)";
      sol.test(numerator, denominator, expect);

      numerator = 7;
      denominator = -3;
      expect = "-2.(3)";
      sol.test(numerator, denominator, expect);

      numerator = 1;
      denominator = 2;
      expect = "0.5";
      sol.test(numerator, denominator, expect);

      numerator = 2;
      denominator = 1;
      expect = "2";
      sol.test(numerator, denominator, expect);

      numerator = 2;
      denominator = 3;
      expect = "0.(6)";
      sol.test(numerator, denominator, expect);

      numerator = 4;
      denominator = 333;
      expect = "0.(012)";
      sol.test(numerator, denominator, expect);

      numerator = 1;
      denominator = 5;
      expect = "0.2";
      sol.test(numerator, denominator, expect);
   }
}

/*
01
38 / 38 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38 MB
Your runtime beats 100.00 % of java submissions.
*/

/*
02
38 / 38 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 38.5 MB
*/