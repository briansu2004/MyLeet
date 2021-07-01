
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/119/backtracking/855/
 * Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:
Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:
Input: s = "acdcb", p = "a*c?b"
Output: false

Constraints:
0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
*/

class Solution {
   //03
   public boolean isMatch(String S, String pattern) {
      if (S == null || pattern == null)
         return false;
      int N = S.length();
      int M = pattern.length();

      int i = 0, starIndex = -1, patternIndex = -1, j = 0;

      while (i < N) {
         if (i < N && j < M && (S.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
            i++;
            j++;
         } else if (j < M && pattern.charAt(j) == '*') {
            starIndex = i;
            patternIndex = j;
            j++;
         } else if (patternIndex == -1)
            return false;
         else {
            i = starIndex + 1;
            j = patternIndex;
            starIndex = i;
         }
      }

      if (j < M)
         while (j < M)
            if (pattern.charAt(j++) != '*')
               return false;

      return true;
   }

   //02
   public boolean isMatch2(String s, String p) {
      int n = s.length();
      int m = p.length();
      int i = 0;
      int j = 0;
      int lastSeenStar = -1;
      int lastMatchChar = 0;
      while (i < n) {
         int chs = s.charAt(i);
         // if same character
         if (j < m && chs == p.charAt(j)) {
            i++;
            j++;
         }
         // if ? then also we assue normal match
         else if (j < m && p.charAt(j) == '?') {
            i++;
            j++;
         }
         // if * is there then we note down index of star element and index in main
         // string till which we have successfully matched
         else if (j < m && p.charAt(j) == '*') {
            lastSeenStar = j;
            lastMatchChar = i;
            j++;
         }
         // if the chars are not equal and there is no ? or *. Then we see do we have a
         // star there in pattern previosuly? if yes, we go back to last matched string
         // and check from next character of there.
         else if (lastSeenStar != -1) {
            j = lastSeenStar + 1;
            lastMatchChar++;
            i = lastMatchChar;
         } else
            return false;
      }
      while (j < m && p.charAt(j) == '*')
         j++;
      return j == m;
   }

   // 01
   public boolean isMatch1(String s, String p) {
      int m = s.length(), n = p.length();
      char[] ws = s.toCharArray();
      char[] wp = p.toCharArray();
      boolean[][] dp = new boolean[m + 1][n + 1];
      dp[0][0] = true;
      for (int j = 1; j <= n; j++)
         dp[0][j] = dp[0][j - 1] && wp[j - 1] == '*';
      for (int i = 1; i <= m; i++)
         dp[i][0] = false;
      for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {
            if (wp[j - 1] == '?' || ws[i - 1] == wp[j - 1])
               dp[i][j] = dp[i - 1][j - 1];
            else if (wp[j - 1] == '*')
               dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
         }
      }
      return dp[m][n];
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
      p = "*";
      expect = true;
      sol.test(s, p, expect);

      s = "cb";
      p = "?a";
      expect = false;
      sol.test(s, p, expect);

      s = "adceb";
      p = "*a*b";
      expect = true;
      sol.test(s, p, expect);

      s = "acdcb";
      p = "a*c?b";
      expect = false;
      sol.test(s, p, expect);
   }
}

/*
01
1811 / 1811 test cases passed.
Status: Accepted
Runtime: 12 ms
Memory Usage: 39.3 MB

02
1811 / 1811 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 39.4 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 62.32 % of java submissions.

03
1811 / 1811 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 38.9 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 94.07 % of java submissions.
*/


