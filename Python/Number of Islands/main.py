"""
https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/
Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

"""


from typing import List


class Solution:
    def numIslands(self, grid):
        if not grid:
            return 0
            
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1
        return count

    def dfs(self, grid, i, j):
        if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j] != '1':
            return
        grid[i][j] = '#'
        self.dfs(grid, i+1, j)
        self.dfs(grid, i-1, j)
        self.dfs(grid, i, j+1)
        self.dfs(grid, i, j-1)

    #01
    def numIslands1(self, grid: List[List[str]]) -> int:
        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
                grid[i][j] = '0'
                #map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1))
                list(map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1)))
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))


if __name__ == "__main__":
    sol = Solution()

    grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]
    print("numIslands({0}): {1}".format(grid, sol.numIslands(grid)))

    grid = [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"]
    ]
    print("numIslands({0}): {1}".format(grid, sol.numIslands(grid)))

# 01
# 48 / 48 test cases passed.
# Status: Accepted
# Runtime: 160 ms
# Memory Usage: 15.7 MB

# 02
# 48 / 48 test cases passed.
# Status: Accepted
# Runtime: 128 ms
# Memory Usage: 21.1 MB
