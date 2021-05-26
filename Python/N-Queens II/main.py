"""
https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/
N-Queens II

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1

Constraints:
1 <= n <= 9
"""


class Solution(object):
    #02
    def totalNQueens(self, n):
        self.res = 0
        self.solve(self, n, 0, [-1]*n)
        return self.res
        
    def solve(self, n, row, board):
        if row == n:
            self.res += 1
            return
        for col in range(n):
            valid = True
            for r in range(row):
                if board[r] == col or abs(board[r]-col) == row - r:
                    valid = False
                    break
            if valid:
                board[row] = col
                self.solve(self, n, row + 1, board)

    #01
    def totalNQueens1(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.res = 0
        self.dfs(self, [-1]*n, 0)
        return self.res
        
    def dfs(self, nums, index):
        if index == len(nums):
            self.res += 1
            return #backtracking
        for i in range(len(nums)):
            nums[index] = i
            if self.valid(self, nums, index):
                self.dfs(self, nums, index+1)
        
    def valid(self, nums, n):
        for i in range(n):
            if nums[i] == nums[n] or abs(nums[n]-nums[i]) == n-i:
                return False
        return True


if __name__ == "__main__":
    for n in range(10):
        print("totalNQueens({0}) is: {1}".format(
            n, Solution.totalNQueens(Solution, n)))


# 02
# 9 / 9 test cases passed.
# Status: Accepted
# Runtime: 64 ms
# Memory Usage: 13.4 MB

# 01
# 9 / 9 test cases passed.
# Status: Accepted
# Runtime: 92 ms
# Memory Usage: 13.4 MB
