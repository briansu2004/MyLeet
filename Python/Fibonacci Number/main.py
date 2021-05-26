"""
https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/
Fibonacci Number

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Constraints:
0 <= n <= 30
"""

class Solution(object):
    def fib(self, n):
    #def fib(n):
        """
        :type n: int
        :rtype: int
        """
        cache = {}

        def recur_fib(n):
            if n in cache:
                return cache[n]

            if n < 2:
                return n

            result = recur_fib(n - 2) + recur_fib(n - 1)

            cache[n] = result
            return result

        return recur_fib(n)


if __name__ == "__main__":
    for n in range(100):
        print("fib({0}): {1}".format(n, Solution.fib(Solution, n)))



# 31 / 31 test cases passed.
# Status: Accepted
# Runtime: 20 ms
# Memory Usage: 13.6 MB
