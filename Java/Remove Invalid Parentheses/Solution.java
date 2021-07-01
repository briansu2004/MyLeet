
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/119/backtracking/854/
 * Remove Invalid Parentheses

Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
Return all the possible results. You may return the answer in any order.

Example 1:
Input: s = "()())()"
Output: ["(())()","()()()"]
Example 2:
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
Example 3:
Input: s = ")("
Output: [""]
 
Constraints:
1 <= s.length <= 25
s consists of lowercase English letters and parentheses '(' and ')'.
There will be at most 20 parentheses in s.

   Hide Hint #1  
Since we don't know which of the brackets can possibly be removed, we try out all the options!
   Hide Hint #2  
We can use recursion to try out all possibilities for the given expression. For each of the brackets, we have 2 options:
We keep the bracket and add it to the expression that we are building on the fly during recursion.
OR, we can discard the bracket and move on.
   Hide Hint #3  
The one thing all these valid expressions have in common is that they will all be of the same length i.e. as compared to the original expression, all of these expressions will have the same number of characters removed. Can we somehow find the number of misplaced parentheses and use it in our solution?
   Hide Hint #4  
The one thing all these valid expressions have in common is that they will all be of the same length i.e. as compared to the original expression, all of these expressions will have the same number of characters removed. Can we somehow find the number of misplaced parentheses and use it in our solution?
   Hide Hint #5  
For every left parenthesis, we should have a corresponding right parenthesis. We can make use of two counters which keep track of misplaced left and right parenthesis and in one iteration we can find out these two values.
0 1 2 3 4 5 6 7
( ) ) ) ( ( ( )  
i = 0, left = 1, right = 0
i = 1, left = 0, right = 0
i = 2, left = 0, right = 1
i = 3, left = 0, right = 2
i = 4, left = 1, right = 2
i = 5, left = 2, right = 2
i = 6, left = 3, right = 2
i = 7, left = 2, right = 2
We have 2 misplaced left and 2 misplaced right parentheses.
   Hide Hint #6  
We found out that the exact number of left and right parenthesis that has to be removed to get a valid expression. So, e.g. in a 1000 parentheses string, if there are 2 misplaced left and 2 misplaced right parentheses, after we are done discarding 2 left and 2 right parentheses, we will have only one option per remaining character in the expression i.e. to consider them. We can't discard them.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
   //01
   public List<String> removeInvalidParentheses(String s) {
      List<String> ans = new ArrayList<>();
      remove(s, ans, 0, 0, new char[] { '(', ')' });
      return ans;
   }

   public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
      for (int stack = 0, i = last_i; i < s.length(); ++i) {
         if (s.charAt(i) == par[0])
            stack++;
         if (s.charAt(i) == par[1])
            stack--;
         if (stack >= 0)
            continue;
         for (int j = last_j; j <= i; ++j)
            if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
               remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
         return;
      }
      String reversed = new StringBuilder(s).reverse().toString();
      if (par[0] == '(') // finished left to right
         remove(reversed, ans, 0, 0, new char[] { ')', '(' });
      else // finished right to left
         ans.add(reversed);
   }

   public void test(String s, List<String> expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("removeInvalidParentheses(%s): %s", s, removeInvalidParentheses(s)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "()())()";
      List<String> expect = Arrays.asList(new String[] { "(())()", "()()()" });
      sol.test(s, expect);

      s = "(a)())()";
      expect = Arrays.asList(new String[] { "(a())()","(a)()()" });
      sol.test(s, expect);

      s = ")(";
      expect = Arrays.asList(new String[] { "" });
      sol.test(s, expect);
   }
}

/*
01
125 / 125 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38.7 MB
*/


