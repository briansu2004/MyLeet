import java.util.Stack;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/880/
 * Reverse Integer
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0. Assume the environment does not allow you to
 * store 64-bit integers (signed or unsigned).
 * 
 * Example 1: Input: x = 123 Output: 321 Example 2: Input: x = -123 Output: -321
 * Example 3: Input: x = 120 Output: 21 Example 4: Input: x = 0 Output: 0
 * 
 * Constraints: -231 <= x <= 231 - 1
 * Integer.MAX_VALUE: (2^31-1)   2147483647
 * Integer.MIN_VALUE: (-2^31)   -2147483648
 * 2^31 - 1 = 2147483647 
 *  2^30 - 1 = 1073741823
 * 2^29 - 1 = 536870911
 */

class Solution {
    // #01
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        long res = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            res = res * 10 + digit;

            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) res;
    }

    // Mine
    // has issues
    public int reverse0(int x) {
        if (x > -10 && x < 10) {
            return x;
        }

        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int n = 0;
        Stack<Integer> s = new Stack<Integer>();
        while (x > 9) {
            s.push(x % 10);
            x = (x - x % 10) / 10;
        }
        s.push(x);

        int i = 1;
        while (!s.empty()) {
            // n += s.pop() * i;
            int j = s.pop();
            if (j * i < 0 || j * i > Integer.MAX_VALUE) {
                // j: 9; i: 1000000000;
                // j*i: 9000000000 > Integer.MAX_VALUE
                // but it shows as 410065408
                return 0;
            }

            n += j * i;

            i *= 10;
            if (i < 0 || i > Integer.MAX_VALUE) {
                return 0;
            }
        }

        if (n < 0 || n > Integer.MAX_VALUE) {
            return 0;
        }

        if (isNegative) {
            n = -n;
        }

        return n;
    }

    public int reverseTmp(int x) {
        if (x > -10 && x < 10) {
            return x;
        }

        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int n = 0;
        Stack<Integer> s = new Stack<Integer>();
        while (x > 9) {
            // s.push((x - x % 10) / 10);
            s.push(x % 10);
            x = (x - x % 10) / 10;
        }
        s.push(x);

        int i = 1;
        while (!s.empty()) {
            // int j = s.pop();
            // if (n + j * i > Integer.MAX_VALUE) {
            // return 0;
            // }
            // n += j * i;
            // if (n > Integer.MAX_VALUE) {
            // return 0;
            // }
            n += s.pop() * i;

            i *= 10;
        }

        // if (n > Integer.MAX_VALUE) {
        // return 0;
        // }

        if (n < 0) {
            return 0;
        }

        if (isNegative) {
            n = -n;
        }

        return n;
    }

    public void test(int x) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("reverse(%s): %s", x, reverse(x)));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(String.format("Integer.MAX_VALUE: %s", Integer.MAX_VALUE));
        System.out.println(String.format("Integer.MIN_VALUE: %s", Integer.MIN_VALUE));

        int x = 123;
        sol.test(x);

        x = -123;
        sol.test(x);

        x = 120;
        sol.test(x);

        x = 0;
        sol.test(x);

        x = 536870911;
        sol.test(x);

        x = 1073741822; // expect to return 0
        sol.test(x);

        x = 1073741823; // expect to return 0
        sol.test(x);

        x = 2147483647; // expect to return 0
        sol.test(x);

        x = 1534236469; // expect to return 0
        sol.test(x);

    }
}

/*
 * 01 1032 / 1032 test cases passed. Status: Accepted Runtime: 1 ms Memory
 * Usage: 36 MB
 */
