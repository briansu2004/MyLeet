
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/119/backtracking/852/
 * Palindrome Partitioning

 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
   // 03
   List<List<String>> resultLst;
   ArrayList<String> currLst;

   public List<List<String>> partition(String s) {
      resultLst = new ArrayList<List<String>>();
      currLst = new ArrayList<String>();
      backTrack(s, 0);
      return resultLst;
   }

   public void backTrack(String s, int l) {
      if (currLst.size() > 0 // the initial str could be palindrome
            && l >= s.length()) {
         List<String> r = (ArrayList<String>) currLst.clone();
         resultLst.add(r);
      }
      for (int i = l; i < s.length(); i++) {
         if (isPalindrome(s, l, i)) {
            if (l == i)
               currLst.add(Character.toString(s.charAt(i)));
            else
               currLst.add(s.substring(l, i + 1));
            backTrack(s, i + 1);
            currLst.remove(currLst.size() - 1);
         }
      }
   }

   public boolean isPalindrome(String str, int l, int r) {
      if (l == r)
         return true;
      while (l < r) {
         if (str.charAt(l) != str.charAt(r))
            return false;
         l++;
         r--;
      }
      return true;
   }

   // 02
   public List<List<String>> partition2(String s) {
      List<List<String>> res = new ArrayList<>();
      boolean[][] dp = new boolean[s.length()][s.length()];
      for (int i = 0; i < s.length(); i++) {
         for (int j = 0; j <= i; j++) {
            if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
               dp[j][i] = true;
            }
         }
      }
      helper(res, new ArrayList<>(), dp, s, 0);
      return res;
   }

   private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
      if (pos == s.length()) {
         res.add(new ArrayList<>(path));
         return;
      }

      for (int i = pos; i < s.length(); i++) {
         if (dp[pos][i]) {
            path.add(s.substring(pos, i + 1));
            helper(res, path, dp, s, i + 1);
            path.remove(path.size() - 1);
         }
      }
   }

   // 01
   public List<List<String>> partition1(String s) {
      // Backtracking
      // Edge case
      if (s == null || s.length() == 0)
         return new ArrayList<>();

      List<List<String>> result = new ArrayList<>();
      helper(s, new ArrayList<>(), result);
      return result;
   }

   public void helper(String s, List<String> step, List<List<String>> result) {
      // Base case
      if (s == null || s.length() == 0) {
         result.add(new ArrayList<>(step));
         return;
      }
      for (int i = 1; i <= s.length(); i++) {
         String temp = s.substring(0, i);
         if (!isPalindrome(temp))
            continue; // only do backtracking when current string is palindrome

         step.add(temp); // choose
         helper(s.substring(i, s.length()), step, result); // explore
         step.remove(step.size() - 1); // unchoose
      }
      return;
   }

   public boolean isPalindrome(String s) {
      int left = 0, right = s.length() - 1;
      while (left <= right) {
         if (s.charAt(left) != s.charAt(right))
            return false;
         left++;
         right--;
      }
      return true;
   }

   public void test(String s, List<List<String>> expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("partition(%s): %s", s, partition(s)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "aab";
      List<List<String>> expect = Arrays.asList(Arrays.asList(new String[] { "a", "a", "b" }),
            Arrays.asList(new String[] { "aa", "b" }));
      sol.test(s, expect);

      s = "a";
      expect = Arrays.asList(Arrays.asList(new String[] { "a" }));
      sol.test(s, expect);

   }
}

/*
01
32 / 32 test cases passed.
Status: Accepted
Runtime: 9 ms
Memory Usage: 52.7 MB

02
32 / 32 test cases passed.
Status: Accepted
Runtime: 7 ms
Memory Usage: 53.1 MB
Your runtime beats 99.36 % of java submissions.

03
32 / 32 test cases passed.
Status: Accepted
Runtime: 12 ms
Memory Usage: 52.9 MB
*/


