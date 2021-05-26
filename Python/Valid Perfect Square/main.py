"""
https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.

Example 1:
Input: num = 16
Output: true
Example 2:
Input: num = 14
Output: false

Constraints:
1 <= num <= 2^31 - 1
"""


class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num < 0:
            return False
        x, i = 0, 1
        while x < num:
            x += i
            i += 2
        return x == num


if __name__ == "__main__":
    num = 16
    print("isPerfectSquare({0}): {1}".format(
        num, Solution.isPerfectSquare(Solution, num)))

    num = 14
    print("isPerfectSquare({0}): {1}".format(
        num, Solution.isPerfectSquare(Solution, num)))


# 01
# 70 / 70 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.3 MB
