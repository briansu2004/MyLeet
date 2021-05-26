"""
https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/
Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

Constraints:
1 <= n <= 104
"""


import math


class Solution(object):
    # 03
    def numSquares(target):
        level, targets, roots = 0, set({target}), set(
            [(x+1)**2 for x in range(int(target**0.5))])

        while targets:
            targets = None if targets.intersection(roots) else set(
                [x-y for x in targets for y in roots if x-y > 0])
            level += 1

        return level

    # 02
    def numSquares(self, n):
        sqrtList = set()
        for i in range(1, int(n**0.5)+1):
            sqrtList.add(i**2)
        if n in sqrtList:
            return 1
        else:
            for square in sqrtList:
                if n - square in sqrtList:
                    return 2
            for k in range(int(math.log(n, 4))+1):
                if n % (4**k) == 0 and (n/(4**k) - 7) % 8 == 0:
                    return 4
            return 3

    # 01
    def numSquares1(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2:
            return n
        lst = []
        i = 1
        while i * i <= n:
            lst.append(i * i)
            i += 1
        cnt = 0
        toCheck = {n}
        while toCheck:
            cnt += 1
            temp = set()
            for x in toCheck:
                for y in lst:
                    if x == y:
                        return cnt
                    if x < y:
                        break
                    temp.add(x-y)
            toCheck = temp

        return cnt


if __name__ == "__main__":
    sol = Solution()

    n = 12
    print("numSquares({0}): {1}".format(n, sol.numSquares(n)))

    n = 13
    print("numSquares({0}): {1}".format(n, sol.numSquares(n)))

    n = 1
    print("numSquares({0}): {1}".format(n, sol.numSquares(n)))


# 01
# 588 / 588 test cases passed.
# Status: Accepted
# Runtime: 172 ms
# Memory Usage: 14.6 MB

#02
# 588 / 588 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 13.4 MB
