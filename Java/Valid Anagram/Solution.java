
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/882/
 * Valid Anagram
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * Example 1: Input: s = "anagram", t = "nagaram" Output: true Example 2: Input:
 * s = "rat", t = "car" Output: false
 * 
 * Constraints: 1 <= s.length, t.length <= 5 * 104 s and t consist of lowercase
 * English letters.
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt
 * your solution to such a case?
 */

import java.util.Arrays;

class Solution {
    // 01
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0)
                return false;
        }
        return true;
    }

    // Mine
    public boolean isAnagramMine(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] c1 = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c1[i] = s.charAt(i);
        }
        Arrays.sort(c1);
        String s2 = Arrays.toString(c1);
        for (int i = 0; i < s.length(); i++) {
            c1[i] = t.charAt(i);
        }
        Arrays.sort(c1);
        String t2 = Arrays.toString(c1);

        return s2.equals(t2);
    }

    public void test(String s, String t) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("isAnagram(%s, %s): %s", s, t, isAnagram(s, t)));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "anagram";
        String t = "nagaram";
        sol.test(s, t);

        s = "rat";
        t = "car";
        sol.test(s, t);

        // s = null;
        // t = null;
        // sol.test(s, t);

        s = "a";
        t = "aa";
        sol.test(s, t);

        s = "b";
        t = "b";
        sol.test(s, t);
    }
}

/*
* 01
* 34 / 34 test cases passed.
* Status: Accepted
* Runtime: 3 ms
* Memory Usage: 39.4 MB
*/

/*
 * Mine 34 / 34 test cases passed. 
 * Status: Accepted 
 * Runtime: 10 ms 
 * Memory Usage: 39.8 MB 
 * Your runtime beats 25.90 % of java submissions.
 */
