"""
https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
"""

import math

class Solution(object):
    #03
    def climbStairs(self, n):
        if n <= 2:
            return n
        else:
            memo = []
            memo.append(0)
            memo.append(1)
            memo.append(2)
            for i in range(3, n+1):
                sum = memo[1]+memo[2]
                memo[0], memo[1] = memo[1], memo[2]
                memo[2] = sum
            return memo[-1]


    def climbStairs3(self, n):
        if n <= 2:
            return n
        else:
            memo = []
            memo.append(0)
            memo.append(1)
            memo.append(2)
            for i in range(3, n+1):
                sum = memo[1]+memo[2]
                memo[0] = memo[1]
                memo[1] = memo[2]
                memo[2] = sum
            return memo[-1]

    #02
    def climbStairs2(self, n):
        """
        :type n: int
        :rtype: int
        """
        cache = {}
        cache[0] = 0
        cache[1] = 1
        cache[2] = 2

        def recur_climbStairs(n):
            if n in cache:
                return cache[n]

            if n==1: return 1
            if n==2: return 2
            a, b = 1, 2
            for _ in range(4, n+1):
                a, b = b, a+b

            cache[n] = b
            return b

        return recur_climbStairs(n)

    #01
    def climbStairs1(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = 0
        x = n//2
        
        for y in range(x+1):
            #print("n: {0}, y: {1}, + {2}".format(n, y, math.factorial(n-y)/(math.factorial(y)*math.factorial(n-y-y))))
            result += math.factorial(n-y)/(math.factorial(y)*math.factorial(n-y-y))
            
        return result

if __name__ == "__main__":
    for n in range(100):
        print("climbStairs({0}): {1}".format(n, int(Solution.climbStairs(Solution, n))))


# Adding cache
# 45 / 45 test cases passed.
# Status: Accepted
# Runtime: 20 ms
# Memory Usage: 13.2 MB
# Your runtime beats 37.78 % of python submissions.

# 01
# 45 / 45 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.5 MB
# Your runtime beats 71.44 % of python submissions.

