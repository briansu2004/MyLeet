"""
https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:
Input: n = 1, bad = 1
Output: 1

Constraints:
1 <= bad <= n <= 231 - 1
"""

# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):

import bisect

class Solution:
    firstV = 4

    def isBadVersion(version: int) -> bool:
        if version < Solution.firstV:
            return False

        return True

    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        return bisect.bisect(type('', (), {'__getitem__': lambda self, i: Solution.isBadVersion(i)})(), False, 0, n)


if __name__ == "__main__":
    firstV = 4
    for n in range(10):
        print("firstBadVersion({0}, {1}): {2}".format(firstV, n, Solution.firstBadVersion(Solution, n)))


#01
# 22 / 22 test cases passed.
# Status: Accepted
# Runtime: 36 ms
# Memory Usage: 14.2 MB
