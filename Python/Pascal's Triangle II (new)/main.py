"""
https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1171/
Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:
Input: rowIndex = 0
Output: [1]
Example 3:
Input: rowIndex = 1
Output: [1,1]

Constraints:
0 <= rowIndex <= 33
 
Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
"""

from typing import List


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        res = [1]*(rowIndex+1)
        for i in range(2, rowIndex+1):
            prev = res[0]
            for j in range(1,i):
                tmp = res[j]
                res[j] = prev+res[j]
                prev = tmp
        return res

if __name__ == "__main__":
    sol = Solution()

    for rowIndex in range(5):
        print("getRow({0}): {1}".format(rowIndex, sol.getRow(rowIndex)))
        




# 01
# 34 / 34 test cases passed.
# Status: Accepted
# Runtime: 28 ms
# Memory Usage: 14.1 MB
