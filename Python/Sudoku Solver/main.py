"""
https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2796/
Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:

Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
"""

from typing import List

class Solution:
    #02
    def solveSudoku(self, board: List[List[str]]) -> None:
        def isValid(x,y):
            tmp=board[x][y]; board[x][y]='D'
            for i in range(9):
                if board[i][y]==tmp: return False
            for i in range(9):
                if board[x][i]==tmp: return False
            for i in range(3):
                for j in range(3):
                    if board[int(x/3)*3+i][int(y/3)*3+j]==tmp: return False
            board[x][y]=tmp
            return True
        def dfs(board):
            for i in range(9):
                for j in range(9):
                    if board[i][j]=='.':
                        for k in '123456789':
                            board[i][j]=k
                            if isValid(i,j) and dfs(board):
                                return True
                            board[i][j]='.'
                        return False
            return True
        dfs(board)

    #01
    def solveSudoku1(self, board: 'List[List[str]]') -> 'None':
        self.board = board
        self.solve(self)

    def findUnassigned(self):
        for row in range(9):
            for col in range(9):
                if self.board[row][col] == '.':
                    return row, col
        return -1, -1

    def solve(self):
        row, col = self.findUnassigned(self)
        if (row, col) == (-1, -1):
            return True

        for num in map(str, range(1, 10)):
            if self.isSafe(self, row, col, num):
                self.board[row][col] = num
                if self.solve(self):
                    return True
                self.board[row][col] = '.'

    def isSafe(self, row, col, ch):
        rowSafe = all(self.board[row][_] != ch for _ in range(9))
        colSafe = all(self.board[_][col] != ch for _ in range(9))
        squareSafe = all(self.board[r][c] != ch for r in self.getRange(self, row) for c in self.getRange(self, col))
        return rowSafe and colSafe and squareSafe

    def getRange(self, x):
        x -= x % 3
        return range(x, x + 3)

    def printWell(self, board: 'List[List[str]]'):
        for i in board:
            # print(i)
            print(' '.join(map(str, i)))
            #print(map(str, i))


if __name__ == "__main__":
    board = [["5", "3", ".", ".", "7", ".", ".", ".", "."], ["6", ".", ".", "1", "9", "5", ".", ".", "."], [".", "9", "8", ".", ".", ".", ".", "6", "."], ["8", ".", ".", ".", "6", ".", ".", ".", "3"], ["4", ".", ".", "8",
                                                                                                                                                                                                          ".", "3", ".", ".", "1"], ["7", ".", ".", ".", "2", ".", ".", ".", "6"], [".", "6", ".", ".", ".", ".", "2", "8", "."], [".", ".", ".", "4", "1", "9", ".", ".", "5"], [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    print("Before:")
    Solution.printWell(Solution, board)

    Solution.solveSudoku(Solution, board)

    print("After:")
    Solution.printWell(Solution, board)

    #for x in range(0, 10):
    #    print("getRange({0}): {1}".format(x, Solution.getRange(Solution, x)))


# 01
# 6 / 6 test cases passed.
# Status: Accepted
# Runtime: 2088 ms
# Memory Usage: 14.4 MB

# 02
# 6 / 6 test cases passed.
# Status: Accepted
# Runtime: 2088 ms
# Memory Usage: 14.4 MB
