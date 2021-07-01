/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/121/dynamic-programming/864/
 * Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
   //02
   public boolean wordBreak(String s, List<String> wordDict) {
      return dfs(s, 0, wordDict, new Boolean[s.length()]);
   }

   private boolean dfs(String s, int currIndex, List<String> words, Boolean[] memo) {
      if (currIndex == s.length()) {
         return true;
      }

      if (memo[currIndex] != null)
         return memo[currIndex];

      for (String word : words) {
         if (s.startsWith(word, currIndex)) {
            if (dfs(s, currIndex + word.length(), words, memo)) {
               memo[currIndex] = true;
               return true;
            }
         }
      }

      memo[currIndex] = false;
      return false;
   }

   //01
   public boolean wordBreak1(String s, List<String> dict) {
      if (s == null || s.length() == 0)
         return false;

      int n = s.length();

      // dp[i] represents whether s[0...i] can be formed by dict
      boolean[] dp = new boolean[n];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j <= i; j++) {
            String sub = s.substring(j, i + 1);

            if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
               dp[i] = true;
               break;
            }
         }
      }

      return dp[n - 1];
   }

   public void test(String s, List<String> wordDict, boolean expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("wordBreak(%s, %s): %s", s, wordDict, wordBreak(s, wordDict)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "leetcode";
      List<String> wordDict = new ArrayList<String>();
      wordDict.add("leet");
      wordDict.add("code");
      boolean expect = true;
      sol.test(s, wordDict, expect);

      s = "applepenapple";
      wordDict = new ArrayList<String>();
      wordDict.add("apple");
      wordDict.add("pen");
      expect = true;
      sol.test(s, wordDict, expect);

      s = "catsandog";
      wordDict = new ArrayList<String>();
      wordDict.add("cats");
      wordDict.add("dog");
      wordDict.add("sand");
      wordDict.add("and");
      wordDict.add("cat");
      expect = false;
      sol.test(s, wordDict, expect);
   }
}

/*
01
42 / 42 test cases passed.
Status: Accepted
Runtime: 11 ms
Memory Usage: 38.9 MB

02
42 / 42 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 37.1 MB
Your runtime beats 100.00 % of java submissions.
*/


