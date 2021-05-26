"""
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/
01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
"""


from collections import deque

class Solution(object):
    #02
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if not matrix[i][j]:
                    continue
                matrix[i][j] = float("inf")
                if i > 0:
                    matrix[i][j] = min(matrix[i][j], matrix[i-1][j]+1)
                if j > 0:
                    matrix[i][j] = min(matrix[i][j], matrix[i][j-1]+1)
        for i in reversed(range(len(matrix))):
            for j in reversed(range(len(matrix[i]))):
                if not matrix[i][j]:
                    continue
                if i < len(matrix)-1:
                    matrix[i][j] = min(matrix[i][j], matrix[i+1][j]+1)
                if j < len(matrix[i])-1:
                    matrix[i][j] = min(matrix[i][j], matrix[i][j+1]+1)
        return matrix

    #01
    def updateMatrix1(self, A):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        R, C = len(A), len(A[0])
        def neighbors(r, c):
            for cr, cc in ((r-1,c),(r+1,c),(r,c-1),(r,c+1)):
                if 0 <= cr < R and 0 <= cc < C:
                    yield cr, cc
                    
        q = deque([((r, c), 0) 
                for r in range(R) 
                for c in range(C) 
                if A[r][c] == 0])
        seen = {x for x,_ in q}
        ans = [[0]*C for _ in A]
        while q:
            (r, c), depth = q.popleft()
            ans[r][c] = depth
            for nei in neighbors(r, c):
                if nei not in seen:
                    seen.add(nei)
                    q.append((nei, depth + 1))
        
        return ans
        
if __name__ == "__main__":
    sol = Solution()

    mat = [[0,0,0],[0,1,0],[1,1,1]]
    print("updateMatrix({0}): {1}".format(mat, sol.updateMatrix(mat)))

    mat = [[0,0,0],[0,1,0],[0,0,0]]
    print("updateMatrix({0}): {1}".format(mat, sol.updateMatrix(mat)))



# 01
# 48 / 48 test cases passed.
# Status: Accepted
# Runtime: 712 ms
# Memory Usage: 18.3 MB

# 02
# 48 / 48 test cases passed.
# Status: Accepted
# Runtime: 504 ms
# Memory Usage: 15.8 MB
