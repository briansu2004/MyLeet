
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/838/
 * Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

Follow up: Could you find an algorithm that runs in O(m + n) time?

   Hide Hint #1  
Use two pointers to create a window of letters in S, which would have all the characters from T.
   Hide Hint #2  
Since you have to find the minimum window in S which has all the characters from T, you need to expand and contract the window using the two pointers and keep checking the window for all the characters. This approach is also called Sliding Window Approach.
L ------------------------ R , Suppose this is the window that contains all characters of T 
                          
        L----------------- R , this is the contracted window. We found a smaller window that still contains all the characters in T

When the window is no longer valid, start expanding again using the right pointer. 
*/


class Solution {
   //03
   public String minWindow(String s, String t) {
      int[] need = new int[128];
      for (char c : t.toCharArray()) { // add counts for each letter encountered
         need[c] += 1;
      }
      char[] a = s.toCharArray();

      int missing = t.length();
      int l = 0, r = 0;
      int begin = 0, end = 0;

      // keep going until you find the substring
      while (r < s.length()) { // while we haven't reached the end
         char rightChar = a[r]; // get it's value in text

         if (need[rightChar] > 0) { // check if this is a char we need
            missing--; // if so, reduce missing count
         }
         need[rightChar]--; // reduce it's count in need array
         r++; // move onto next value in text string

         // once you have found the substring, is it the shortest?
         while (missing == 0) {
            char leftChar = a[l];
            // if is the first substring to be encountered
            // or it is greater than the current largest substring
            if (end == 0 || (r - l) < (end - begin)) {
               begin = l; // set begin and end to the substring boundaries
               end = r;
            }
            need[leftChar]++;
            if (need[leftChar] > 0) { // reset the need array
               missing++; // and the missing count
            }
            l++;
         }
      }
      return s.substring(begin, end);
   }

   //02
   public String minWindow2(String s, String t) {
      int[] map = new int[128];
      for (char c : t.toCharArray()) {
         map[c]++;
      }
      int start = 0;
      int end = 0;
      int minL = Integer.MAX_VALUE;
      int count = t.length();
      int minStart = 0;

      while (end < s.length()) {
         char c1 = s.charAt(end);
         if (map[c1] > 0)
            count--;
         map[c1]--;
         end++;
         while (count == 0) {
            if (minL > end - start) {
               minL = end - start;
               minStart = start;
            }
            char c2 = s.charAt(start);
            map[c2]++;
            if (map[c2] > 0)
               count++;
            start++;
         }
      }

      return minL == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minL);
   }

   //01
   public String minWindow1(String s, String t) {
      int[] count = new int[128];
      for (char c : t.toCharArray())
         count[c]++;

      int min = s.length() + 1, i = 0, j = 0, remain = t.length();

      String res = "";
      while (i < s.length()) {
         if (--count[s.charAt(i++)] >= 0)
            remain--;
         while (remain == 0) {
            if (i - j < min) {
               min = i - j;
               res = s.substring(j, i);
            }
            if (++count[s.charAt(j++)] > 0)
               remain++;
            ;
         }
      }
      return res;
   }

   public void test(String s, String t, String expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("minWindow(%s, %s): %s", s, t, minWindow(s, t)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String s = "a";
      String t = "a";
      String expect = "a";
      sol.test(s, t, expect);

      s = "a";
      t = "aa";
      expect = "";
      sol.test(s, t, expect);

      s = "ADOBECODEBANC";
      t = "ABC";
      expect = "BANC";
      sol.test(s, t, expect);

   }
}

/*
01
266 / 266 test cases passed.
Status: Accepted
Runtime: 11 ms
Memory Usage: 48.2 MB
*/

/*
02
266 / 266 test cases passed.
Status: Accepted
Runtime: 4 ms
Memory Usage: 39.1 MB
*/

/*
03
266 / 266 test cases passed.
Status: Accepted
Runtime: 5 ms
Memory Usage: 39 MB
*/
