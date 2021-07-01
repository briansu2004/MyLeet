
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/121/dynamic-programming/861/
 * Decode Ways

A message containing letters from A-Z can be encoded into numbers using the following mapping:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
Given a string s containing only digits, return the number of ways to decode it.
The answer is guaranteed to fit in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:
Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
Hence, there are no valid ways to decode this since all digits need to be mapped.
Example 4:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
*/

class Solution {
   //02
   public int numDecodings(String s) {
      if (s.charAt(0) == '0')
         return 0;

      int result = 1;
      int dp0 = 1;
      int dp1 = 1;

      for (int i = 1; i < s.length(); i++) {
         int num = s.charAt(i) - '0';
         if (num == 0) {
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
               result = dp0;
            } else
               return 0;
         } else if ((num < 10 && s.charAt(i - 1) == '1') || (num < 7 && s.charAt(i - 1) == '2')) {
            result = dp0 + dp1;
         } else
            result = dp1;
         dp0 = dp1;
         dp1 = result;
      }
      return result;
   }

   //01
   //I used a dp array of size n + 1 to save subproblem solutions. 
   //dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1.
   //I then check one digit and two digit combination and save the results along the way. 
   //In the end, dp[n] will be the end result.
   public int numDecodings1(String s) {
      if (s == null || s.length() == 0) {
         return 0;
      }
      int n = s.length();
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = s.charAt(0) != '0' ? 1 : 0;
      for (int i = 2; i <= n; i++) {
         int first = Integer.valueOf(s.substring(i - 1, i));
         int second = Integer.valueOf(s.substring(i - 2, i));
         if (first >= 1 && first <= 9) {
            dp[i] += dp[i - 1];
         }
         if (second >= 10 && second <= 26) {
            dp[i] += dp[i - 2];
         }
      }
      return dp[n];
   }

   public void test(String s, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("numDecodings(%s): %s", s, numDecodings(s)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "12";
      int expect = 2;
      sol.test(s, expect);

      s = "226";
      expect = 3;
      sol.test(s, expect);

      s = "0";
      expect = 0;
      sol.test(s, expect);

      s = "06";
      expect = 0;
      sol.test(s, expect);
   }
}

/*
01
269 / 269 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 37.7 MB
Your runtime beats 93.62 % of java submissions.

02
269 / 269 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 37 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 88.98 % of java submissions.
*/


