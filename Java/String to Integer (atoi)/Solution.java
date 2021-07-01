
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/884/
 * String to Integer (atoi)
 * 
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s atoi function). The algorithm for
 * myAtoi(string s) is as follows: Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-'
 * or '+'. Read this character in if it is either. This determines if the final
 * result is negative or positive respectively. Assume the result is positive if
 * neither is present. Read in next the characters until the next non-digit
 * charcter or the end of the input is reached. The rest of the string is
 * ignored. Convert these digits into an integer (i.e. "123" -> 123, "0032" ->
 * 32). If no digits were read, then the integer is 0. Change the sign as
 * necessary (from step 2). If the integer is out of the 32-bit signed integer
 * range [-231, 231 - 1], then clamp the integer so that it remains in the
 * range. Specifically, integers less than -231 should be clamped to -231, and
 * integers greater than 231 - 1 should be clamped to 231 - 1. Return the
 * integer as the final result. Note: Only the space character ' ' is considered
 * a whitespace character. Do not ignore any characters other than the leading
 * whitespace or the rest of the string after the digits.
 * 
 * Example 1: Input: s = "42" Output: 42 Explanation: The underlined characters
 * are what is read in, the caret is the current reader position. Step 1: "42"
 * (no characters read because there is no leading whitespace) ^ Step 2: "42"
 * (no characters read because there is neither a '-' nor '+') ^ Step 3: "42"
 * ("42" is read in) ^ The parsed integer is 42. Since 42 is in the range [-231,
 * 231 - 1], the final result is 42. Example 2: Input: s = " -42" Output: -42
 * Explanation: Step 1: " -42" (leading whitespace is read and ignored) ^ Step
 * 2: " -42" ('-' is read, so the result should be negative) ^ Step 3: " -42"
 * ("42" is read in) ^ The parsed integer is -42. Since -42 is in the range
 * [-231, 231 - 1], the final result is -42. Example 3: Input: s = "4193 with
 * words" Output: 4193 Explanation: Step 1: "4193 with words" (no characters
 * read because there is no leading whitespace) ^ Step 2: "4193 with words" (no
 * characters read because there is neither a '-' nor '+') ^ Step 3: "4193 with
 * words" ("4193" is read in; reading stops because the next character is a
 * non-digit) ^ The parsed integer is 4193. Since 4193 is in the range [-231,
 * 231 - 1], the final result is 4193. Example 4: Input: s = "words and 987"
 * Output: 0 Explanation: Step 1: "words and 987" (no characters read because
 * there is no leading whitespace) ^ Step 2: "words and 987" (no characters read
 * because there is neither a '-' nor '+') ^ Step 3: "words and 987" (reading
 * stops immediately because there is a non-digit 'w') ^ The parsed integer is 0
 * because no digits were read. Since 0 is in the range [-231, 231 - 1], the
 * final result is 0. Example 5: Input: s = "-91283472332" Output: -2147483648
 * Explanation: Step 1: "-91283472332" (no characters read because there is no
 * leading whitespace) ^ Step 2: "-91283472332" ('-' is read, so the result
 * should be negative) ^ Step 3: "-91283472332" ("91283472332" is read in) ^ The
 * parsed integer is -91283472332. Since -91283472332 is less than the lower
 * bound of the range [-231, 231 - 1], the final result is clamped to -231 =
 * -2147483648.
 * 
 * Constraints: 0 <= s.length <= 200 s consists of English letters (lower-case
 * and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 * 
 * Integer.MAX_VALUE: (2^31-1) 2147483647 Integer.MIN_VALUE: (-2^31) -2147483648
 */

class Solution {
    // 01
    public int myAtoi(String str) {
        int sign = 1, i = 0, r = 0;
        str = str.trim();
        if (str.isEmpty()) return 0;
        else if (str.charAt(i) == '-') { i++; sign = -1; }
        else if (str.charAt(i) == '+') { i++; }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int d = str.charAt(i) - '0';
            if (r > (Integer.MAX_VALUE - d) / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            r = r * 10 + d;
            i++;
        }
        return r * sign;
    }

    // Mine not working
    public int myAtoiMine(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        long n = 0;
        boolean isNegative = false;
        boolean found = false;
        boolean foundSign = false;
        for (int i = 0; i < s.length(); i++) {
            if (n > 0 && !Character.isDigit(s.charAt(i))) {
                break;
            }

            if (s.charAt(i) == ' ') {
                if (found) {
                    break;
                } else {
                    continue;
                }
            } else if (s.charAt(i) == '0') {
                if (found) {
                    break;
                } else {
                    continue;
                }
            } else if (s.charAt(i) == '-') {                
                if (found || foundSign) {
                    break;
                } else {
                    isNegative = true;
                    foundSign = true;
                    continue;
                }
            } else if (s.charAt(i) == '+') {
                if (found || foundSign) {
                    break;
                } else {
                    foundSign = true;
                    continue;
                }
            } else if (!Character.isDigit(s.charAt(i))) {
                break;
            }

            n = n * 10 + Character.getNumericValue(s.charAt(i));
        }

        if (isNegative) {
            n = -n;
        }

        if (n > Integer.MAX_VALUE) {
            n = Integer.MAX_VALUE;
        }

        if (n < Integer.MIN_VALUE) {
            n = Integer.MIN_VALUE;
        }

        return (int) n;
    }

    public void test(String s) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("myAtoi(%s): %s", s, myAtoi(s)));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "A man, a plan, a canal: Panama";
        sol.test(s);

        s = "0";
        sol.test(s);

        s = "42";
        sol.test(s);

        s = "214748364700";
        sol.test(s);

        s = "-2147483648111";
        sol.test(s);

        s = "-21";
        sol.test(s);

        s = " 459.888 ";
        sol.test(s);

        s = "-875.98";
        sol.test(s);

        s = "words and 987";
        sol.test(s);

        s = "+-12";
        sol.test(s);

        s = " ++890.2 ";
        sol.test(s);
        
        s = " -+890.2 ";
        sol.test(s);

        s = " --890.2 ";
        sol.test(s);

        s = " +890.88c ";
        sol.test(s);

        s = "00000-42a1234";
        sol.test(s);

        s = " 000+344b a ";
        sol.test(s);

    }
}

/*
 * 01
 * 1082 / 1082 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 39.2 MB
 */

/*
 * Mine
 * 
 */
