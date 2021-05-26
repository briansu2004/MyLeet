"""
https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
Diagonal Traverse

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:
Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
"""

from typing import List


class Solution:
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        m, n = len(matrix), len(matrix and matrix[0])
        return [matrix[i][d-i]
                for d in range(m+n-1)
                for i in range(max(0, d-n+1), min(d+1, m))[::d%2*2-1]]


if __name__ == "__main__":
    sol = Solution()

    nums = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(f"nums:", nums)
    print(f"findDiagonalOrder(nums):", sol.findDiagonalOrder(nums))

    nums = [[1, 2], [3, 4]]
    print(f"nums:", nums)
    print(f"findDiagonalOrder(nums):", sol.findDiagonalOrder(nums))


# 01
# 32 / 32 test cases passed.
# Status: Accepted
# Runtime: 200 ms
# Memory Usage: 16.8 MB
