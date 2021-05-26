"""
https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
Search a 2D Matrix II

Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
"""

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or len(matrix) < 1 or len(matrix[0]) < 1:
            return False
        
        row, col = 0, len(matrix[0]) - 1
        while col >= 0 and row <= len(matrix) - 1:
            if target == matrix[row][col]:
                return True
            if target < matrix[row][col]:
                col -= 1
            else:
                row += 1
        return False

if __name__ == "__main__":
    matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
    target = 5
    print("searchMatrix({0}, {1}) is: {2}".format(matrix, target, Solution.searchMatrix(Solution, matrix, target)))

# 01
# 129 / 129 test cases passed.
# Status: Accepted
# Runtime: 124 ms
# Memory Usage: 19.4 MB
