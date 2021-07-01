/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/121/dynamic-programming/865/
 *  Word Break II

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []

Constraints:
1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
   //02
   public List<String> wordBreak(String s, List<String> wordDict) {
      List<String> res = new ArrayList<>();
      HashSet<String> set = new HashSet<>(wordDict);
      StringBuilder sb = new StringBuilder();
      dfs(res, sb, s, 0, set);
      return res;
   }

   public void dfs(List<String> res, StringBuilder sb, String s, int idx, HashSet<String> set) {
      // base case
      if (idx == s.length()) {
         res.add(sb.toString());
         return;
      }

      for (int i = idx; i < s.length(); i++) {
         String cur = s.substring(idx, i + 1);
         if (!set.contains(cur))
            continue;
         int len = sb.length();
         if (i == s.length() - 1) {
            sb.append(cur);
         } else {
            sb.append(cur).append(" ");
         }
         dfs(res, sb, s, i + 1, set);
         sb.setLength(len);
      }
   }

   //01
   private final Map<String, List<String>> cache = new HashMap<>();

   private boolean containsSuffix(List<String> dict, String str) {
      for (int i = 0; i < str.length(); i++) {
         if (dict.contains(str.substring(i)))
            return true;
      }
      return false;
   }

   public List<String> wordBreak1(String s, List<String> dict) {
      if (cache.containsKey(s))
         return cache.get(s);
      List<String> result = new LinkedList<>();
      if (dict.contains(s))
         result.add(s);
      for (int i = 1; i < s.length(); i++) {
         String left = s.substring(0, i), right = s.substring(i);
         if (dict.contains(left) && containsSuffix(dict, right)) {
            for (String ss : wordBreak(right, dict)) {
               result.add(left + " " + ss);
            }
         }
      }
      cache.put(s, result);
      return result;
   }

   public void test(String s, List<String> wordDict, List<String> expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("wordBreak(%s, %s): %s", s, wordDict, wordBreak(s, wordDict)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "catsanddog";
      List<String> wordDict = new ArrayList<String>();
      wordDict.add("cat");
      wordDict.add("cats");
      wordDict.add("and");
      wordDict.add("sand");
      wordDict.add("dog");
      List<String> expect = new ArrayList<String>();
      expect.add("cats and dog");
      expect.add("cat sand dog");
      sol.test(s, wordDict, expect);

      s = "pineapplepenapple";
      wordDict = new ArrayList<String>();
      wordDict.add("apple");
      wordDict.add("pen");
      wordDict.add("applepen");
      wordDict.add("pine");
      wordDict.add("pineapple");
      expect = new ArrayList<String>();
      expect.add("pine apple pen apple");
      expect.add("pineapple pen apple");
      expect.add("pine applepen apple");
      sol.test(s, wordDict, expect);

      s = "catsandog";
      wordDict = new ArrayList<String>();
      wordDict.add("cats");
      wordDict.add("dog");
      wordDict.add("sand");
      wordDict.add("and");
      wordDict.add("cat");
      expect = new ArrayList<String>();
      sol.test(s, wordDict, expect);

   }
}

/*
01
26 / 26 test cases passed.
Status: Accepted
Runtime: 5 ms
Memory Usage: 37.5 MB

02
26 / 26 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 37.1 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 94.11 % of java submissions.
*/


