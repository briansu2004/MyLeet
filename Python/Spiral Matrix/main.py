"""
https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

Hint #1  
Well for some problems, the best way really is to come up with some algorithms for simulation. Basically, you need to simulate what the problem asks us to do.

Hint #2  
We go boundary by boundary and move inwards. That is the essential operation. First row, last column, last row, first column and then we move inwards by 1 and then repeat. That's all, that is all the simulation that we need.

Hint #3  
Think about when you want to switch the progress on one of the indexes. If you progress on
i
out of
[i, j]
, you'd be shifting in the same column. Similarly, by changing values for
j
, you'd be shifting in the same row. Also, keep track of the end of a boundary so that you can move inwards and then keep repeating. It's always best to run the simulation on edge cases like a single column or a single row to see if anything breaks or not.

"""

from typing import List

# #02
# class Solution(object):
#     def spiralOrder(self, matrix):
#         """
#         :type matrix: List[List[int]]
#         :rtype: List[int]
#         """
#         return matrix and list(matrix.pop(0)) + self.spiralOrder(zip(*matrix)[::-1])


class Solution:
    #03
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if not matrix or not matrix[0]:
            return []
        res = []
        y0 = 0
        y1 = len(matrix)
        x0 = 0
        x1 = len(matrix[0])
        while y1 > y0 and x1 > x0:
            for i in range(x0, x1):
                res.append(matrix[y0][i])
            for j in range(y0+1, y1-1):
                res.append(matrix[j][x1-1])
            if y1 != y0+1:
                for i in range(x1-1, x0-1, -1):
                    res.append(matrix[y1-1][i])
            if x0 != x1-1:
                for j in range(y1-2, y0, -1):
                    res.append(matrix[j][x0])
            y0 += 1
            y1 -= 1
            x0 += 1
            x1 -= 1
        return res

    #01
    def spiralOrder1(self, matrix: List[List[int]]) -> List[int]:
        return matrix and [*matrix.pop(0)] + self.spiralOrder([*zip(*matrix)][::-1])

if __name__ == "__main__":
    sol = Solution()

    nums = [[1,2,3],[4,5,6],[7,8,9]]
    print(f"nums:", nums)
    print(f"spiralOrder(nums):", sol.spiralOrder(nums))




# 01
# 22 / 22 test cases passed.
# Status: Accepted
# Runtime: 28 ms
# Memory Usage: 14 MB

# 02
# 22 / 22 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.4 MB

# 03
# 22 / 22 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.4 MB
