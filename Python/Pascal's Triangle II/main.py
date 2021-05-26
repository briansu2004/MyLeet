"""
https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
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
    # 02
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]
        Tri = [[1], [1, 1]]
        for i in range(1, rowIndex):
            current = [1, 1]
            j = 0
            k = 1
            while k < len(Tri[-1]):
                current.insert(k, Tri[-1][k]+Tri[-1][j])
                k += 1
                j += 1
            Tri.append(current)
        return Tri[-1]

    # 01
    def getRow1(self, rowIndex: 'int') -> 'List[int]':
        if rowIndex == 0:
            return [1]
        elif(rowIndex == 1):
            return [1, 1]
        tmp = [1, 1]
        for i in range(rowIndex - 1):
            tmp = self.getNextRow(tmp)
        return tmp

    def getNextRow(self, s):
        tmp = [1]
        for i in range(len(s) - 1):
            tmp.append(s[i] + s[i + 1])
        tmp.append(1)
        return tmp


if __name__ == "__main__":
    for n in range(10):
        print("{0}: {1}".format(n, Solution.getRow(Solution, n)))


# 01
# 34 / 34 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.3 MB
