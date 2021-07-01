
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/886/
 * Count and Say
 * 
 * The count-and-say sequence is a sequence of digit strings defined by the
 * recursive formula: countAndSay(1) = "1" countAndSay(n) is the way you would
 * "say" the digit string from countAndSay(n-1), which is then converted into a
 * different digit string. To determine how you "say" a digit string, split it
 * into the minimal number of groups so that each group is a contiguous section
 * all of the same character. Then for each group, say the number of characters,
 * then say the character. To convert the saying into a digit string, replace
 * the counts with a number and concatenate every saying. For example, the
 * saying and conversion for digit string "3322251": Given a positive integer n,
 * return the nth term of the count-and-say sequence.
 * 
 * Example 1: Input: n = 1 Output: "1" Explanation: This is the base case.
 * Example 2: Input: n = 4 Output: "1211" Explanation: countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11" countAndSay(3) = say "11" = two 1's =
 * "21" countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 * 
 * Constraints: 1 <= n <= 30
 * 
 * Hint #1 The following are the terms from n=1 to n=10 of the count-and-say
 * sequence: 1. 1 2. 11 3. 21 4. 1211 5. 111221 6. 312211 7. 13112221 8.
 * 1113213211 9. 31131211131221 10. 13211311123113112211
 * 
 * Hint #2 To generate the nth term, just count and say the n-1th term.
 */

import java.util.HashMap;

class Solution {
    // 01

    // Mine
    HashMap<Integer, String> cache = new HashMap<Integer, String>();

    public String countAndSay(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n == 1) {
            cache.put(1, "1");
            return "1";
        }

        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                // say it
                sb.append(cnt);
                sb.append(s.charAt(i));
                cnt = 1;
            } else {
                cnt++;
                continue;
            }
        }

        sb.append(cnt);
        sb.append(s.charAt(s.length() - 1));

        cache.put(n, sb.toString());

        return sb.toString();
    }

    public void test(int s) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("countAndSay(%s): %s", s, countAndSay(s)));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int i = 1; i < 10; i++) {
            sol.test(i);
        }
    }
}

/*
 * 01
 * 
 */

/*
 * Mine 30 / 30 test cases passed. Status: Accepted Runtime: 2 ms Memory Usage:
 * 36.5 MB
 * Your runtime beats 72.59 % of java submissions
 * Your memory usage beats 82.62 % of java submissions.
 */
