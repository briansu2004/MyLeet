
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/836/
 * Basic Calculator II

Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7
Example 2:
Input: s = " 3/2 "
Output: 1
Example 3:
Input: s = " 3+5 / 2 "
Output: 5

Constraints:
1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/

import java.util.Stack;

class Solution {
   //01
   public int calculate(String s) {
      int len;
      if (s == null || (len = s.length()) == 0)
         return 0;
      Stack<Integer> stack = new Stack<Integer>();
      int num = 0;
      char sign = '+';
      for (int i = 0; i < len; i++) {
         if (Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i) - '0';
         }
         if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
            if (sign == '-') {
               stack.push(-num);
            }
            if (sign == '+') {
               stack.push(num);
            }
            if (sign == '*') {
               stack.push(stack.pop() * num);
            }
            if (sign == '/') {
               stack.push(stack.pop() / num);
            }
            sign = s.charAt(i);
            num = 0;
         }
      }

      int re = 0;
      for (int i : stack) {
         re += i;
      }
      return re;
   }

   public void test(String s, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("calculate(%s): %s", s, calculate(s)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "3+2*2";
      int expect = 7;
      sol.test(s, expect);

      s = " 3/2 ";
      expect = 1;
      sol.test(s, expect);

      s = " 3+5 / 2 ";
      expect = 5;
      sol.test(s, expect);
   }
}

/*
01
109 / 109 test cases passed.
Status: Accepted
Runtime: 25 ms
Memory Usage: 41.7 MB
*/

