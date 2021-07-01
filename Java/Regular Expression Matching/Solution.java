
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/119/backtracking/856/
 * Regular Expression Matching

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where: 
'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:
Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:
Input: s = "mississippi", p = "mis*is*p*."
Output: false

Constraints:
0 <= s.length <= 20
0 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
*/

class Solution {
   //03
   public boolean isMatch(String s, String p) {
      if (s == null)
         return p.length() == 0 ? true : false;
      if (p == null)
         return s.length() == 0 ? true : false;

      return dfs(s, 0, p, 0);

   }

   private boolean dfs(String s, int sIndex, String p, int pIndex) {
      if (pIndex == p.length()) {
         return sIndex == s.length();
      }

      if (pIndex + 1 == p.length() || p.charAt(pIndex + 1) != '*') {

         if (sIndex < s.length() && checkEquals(s.charAt(sIndex), p.charAt(pIndex))) {
            return dfs(s, sIndex + 1, p, pIndex + 1);
         } else {
            return false;
         }

      } else {
         while (sIndex < s.length() && checkEquals(s.charAt(sIndex), p.charAt(pIndex))) {
            if (dfs(s, sIndex, p, pIndex + 2))
               return true;
            sIndex++;
         }
         return dfs(s, sIndex, p, pIndex + 2);
      }
   }

   private boolean checkEquals(char c1, char c2) {
      return c2 == '.' || c1 == c2;
   }

   //02
   Boolean[][] dp;

   public boolean isMatch2(String s, String p) {
      dp = new Boolean[s.length()][p.length()];
      return dfs(0, 0, s, p);
   }

   private boolean dfs(int sIdx, int pIdx, String s, String p) {
      if (p.length() == pIdx) {
         return sIdx == s.length();
      }

      if (sIdx < s.length() && dp[sIdx][pIdx] != null)
         return dp[sIdx][pIdx];

      boolean isMatch = sIdx < s.length() && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '.');

      boolean ret = false;
      if (pIdx < p.length() - 1 && p.charAt(pIdx + 1) == '*') {
         ret = dfs(sIdx, pIdx + 2, s, p) || (isMatch && dfs(sIdx + 1, pIdx, s, p));
      } else if (isMatch) {
         ret = dfs(sIdx + 1, pIdx + 1, s, p);
      }

      if (sIdx < s.length()) {
         dp[sIdx][pIdx] = ret;
         return ret;
      }

      return ret;
   }

   //01
   public boolean isMatch1(String text, String pattern) {
      if (pattern.length() == 0)
         return text.length() == 0;
      boolean[][] memo = new boolean[text.length() + 1][pattern.length() + 1];
      memo[0][0] = true;
      for (int i = 1; i <= text.length(); i++) {
         memo[i][0] = false;
      }
      for (int j = 1; j <= pattern.length(); j++) {
         memo[0][j] = pattern.charAt(j - 1) != '*' ? false : (j - 3 < 0 ? true : memo[0][j - 2] == true);
      }
      for (int i = 0; i < text.length(); i++) {
         for (int j = 0; j < pattern.length(); j++) {
            boolean firstMatch = isMatch(text, pattern, i, j);
            if (pattern.charAt(j) == '*') {
               memo[i + 1][j + 1] = memo[i + 1][j - 1] || (isMatch(text, pattern, i, j - 1) && memo[i][j + 1]);
            } else {
               memo[i + 1][j + 1] = firstMatch && memo[i][j];
            }
         }
      }
      return memo[text.length()][pattern.length()];
   }

   private boolean isMatch(String text, String pattern, int i, int j) {
      return text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.';
   }

   public void test(String s, String p, Boolean expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("isMatch(%s, %s): %s", s, p, isMatch(s, p)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "aa";
      String p = "a";
      boolean expect = false;
      sol.test(s, p, expect);

      s = "aa";
      p = "a*";
      expect = true;
      sol.test(s, p, expect);

      s = "ab";
      p = ".*";
      expect = true;
      sol.test(s, p, expect);

      s = "aab";
      p = "c*a*b";
      expect = true;
      sol.test(s, p, expect);

      s = "mississippi";
      p = "mis*is*p*.";
      expect = false;
      sol.test(s, p, expect);
   }
}

/*
01
448 / 448 test cases passed.
Status: Accepted
Memory Usage: 38848000

02
448 / 448 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38.9 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 66.76 % of java submissions.

03
448 / 448 test cases passed.
Status: Accepted
Memory Usage: 37396000
Your memory usage beats 97.26 % of java submissions.
*/


