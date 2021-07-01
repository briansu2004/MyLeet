
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/743/
 * Fizz Buzz

Given an integer n, return a string array answer (1-indexed) where:
answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i if non of the above conditions are true.

Example 1:
Input: n = 3
Output: ["1","2","Fizz"]
Example 2:
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

Constraints:
1 <= n <= 104
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // 01

    // Mine
    public List<String> fizzBuzz(int n) {
        List<String> l = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                l.add("FizzBuzz");
            } else if (i % 3 == 0) {
                l.add("Fizz");
            } else if (i % 5 == 0) {
                l.add("Buzz");
            } else {
                l.add(String.valueOf(i));
            }
        }
        return l;
    }

    public void test(int n) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("fizzBuzz(%s): %s", n, Arrays.toString(fizzBuzz(n).toArray())));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 3;
        sol.test(n);

        n = 5;
        sol.test(n);
        
        n = 15;
        sol.test(n);
    }
}

/*
* Mine
 * 8 / 8 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 40.1 MB
Your runtime beats 99.65 % of java submissions.
Your memory usage beats 47.28 % of java submissions.
 */
