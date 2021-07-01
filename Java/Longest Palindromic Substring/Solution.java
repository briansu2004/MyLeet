
/**
 * 
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/
 * 
 * Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"
Example 3:
Input: s = "a"
Output: "a"
Example 4:
Input: s = "ac"
Output: "a"
 
Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),

   Hide Hint #1  
How can we reuse a previously computed palindrome to compute a larger palindrome?
   Hide Hint #2  
If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a palindrome?
   Hide Hint #3  
Complexity based hint:
If we use brute-force and check whether for every start and end position a substring is a palindrome we have O(n^2) start - end pairs and O(n) palindromic checks. 
Can we reduce the time for palindromic checks to O(1) by reusing some previous computation.
 */


 
class Solution {
   //02
   public String longestPalindrome(String s) {
      if (s == null || s.length() < 1)
         return "";

      int start = 0, end = 0;

      for (int i = 0; i < s.length(); i++) {
         int len = Math.max(expand(s, i, i), expand(s, i, i + 1));

         if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
         }
      }

      return s.substring(start, end + 1);
   }

   public int expand(String s, int l, int r) {
      while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
         l--;
         r++;
      }

      return r - l - 1;
   }

   // 01
   public String longestPalindrome1(String s) {
      String ans = "";
      if (s.length() == 0) {
         return ans;
      }
      
      int n = s.length(), start = 0, end = 0;
      boolean[][] DP = new boolean[n][n];
      for (int i = n - 1; i >= 0; i--) {
         for (int j = i; j < n; j++) {
            DP[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || DP[i + 1][j - 1]);
            if (DP[i][j] && (j - i > end - start)) {
               start = i;
               end = j;
            }
         }
      }
      return s.substring(start, end + 1);
   }

   // Mine
   public String longestPalindromeMine(String s) {
      if (s == null || s.length() == 1) {
         return s;
      }

      return null;
   }

   public void test(String s, String expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("longestPalindrome(%s): %s", s, longestPalindrome(s)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "babad";
      sol.test(s, "bab or aba");

      s = "cbbd";
      sol.test(s, "bb");

      s = "ac";
      sol.test(s, "a");

      s = "a";
      sol.test(s, "a");
   }
}


/*
01
176 / 176 test cases passed.
Status: Accepted
Runtime: 338 ms
Memory Usage: 42.9 MB
*/

/*
02
176 / 176 test cases passed.
Status: Accepted
Runtime: 338 ms
Memory Usage: 42.9 MB
*/
