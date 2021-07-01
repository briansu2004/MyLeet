
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/883/
 * Valid Palindrome
 * 
 * Given a string s, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Example 1: Input: s = "A man, a plan, a canal: Panama" Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome. Example 2: Input: s =
 * "race a car" Output: false Explanation: "raceacar" is not a palindrome.
 * 
 * Constraints: 1 <= s.length <= 2 * 105 s consists only of printable ASCII
 * characters.
 */

class Solution {
    // 01
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length -1;
        while (left <= right) {
            while (left < chars.length && !Character.isLetterOrDigit(chars[left])) left++;
            while (right >= 0 && !Character.isLetterOrDigit(chars[right])) right--;
            if ( left <= right && Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Mine
    public boolean isPalindromeMine(String s) {
        if (s.length() == 1) {
            return true;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0, j = s.length() - 1; i < Math.ceil(s.length() / 2); i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public void test(String s) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("isPalindrome(%s): %s", s, isPalindrome(s)));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "A man, a plan, a canal: Panama";
        sol.test(s);

        s = "race a car";
        sol.test(s);
    }
}

/*
 * 01
 * 480 / 480 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 38.9 MB
 * Your runtime beats 97.80 % of java submissions.
 * Your memory usage beats 79.07 % of java submissions.
 */

/*
 * Mine
 * 480 / 480 test cases passed.
 * Status: Accepted
 * Runtime: 25 ms
 * Memory Usage: 40.3 MB
 * Your runtime beats 21.05 % of java submissions.
 * Your memory usage beats 9.69 % of java submissions.
 */
