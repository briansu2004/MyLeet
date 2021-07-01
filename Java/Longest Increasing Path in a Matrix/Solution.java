/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/849/
 * Longest Increasing Path in a Matrix
 * 
Given an m x n integers matrix, return the length of the longest increasing path in matrix.
From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Example 1:
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:
Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:
Input: matrix = [[1]]
Output: 1
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
*/

import java.util.Arrays;

class Solution {
   // 01
   // To get max length of increasing sequences:
   // Do DFS from every cell
   // Compare every 4 direction and skip cells that are out of boundary or smaller
   // Get matrix max from every cell's max
   // Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
   // The key is to cache the distance because it's highly possible to revisit a cell
   public static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

   public int longestIncreasingPath(int[][] matrix) {
      if (matrix.length == 0)
         return 0;
      int m = matrix.length, n = matrix[0].length;
      int[][] cache = new int[m][n];
      int max = 1;
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            int len = dfs(matrix, i, j, m, n, cache);
            max = Math.max(max, len);
         }
      }
      return max;
   }

   public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
      if (cache[i][j] != 0)
         return cache[i][j];
      int max = 1;
      for (int[] dir : dirs) {
         int x = i + dir[0], y = j + dir[1];
         if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j])
            continue;
         int len = 1 + dfs(matrix, x, y, m, n, cache);
         max = Math.max(max, len);
      }
      cache[i][j] = max;
      return max;
   }

   public void test(int[][] matrix, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(
            String.format("longestIncreasingPath(%s): %s", Arrays.deepToString(matrix), longestIncreasingPath(matrix)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
      int expect = 4;
      sol.test(matrix, expect);

      matrix = new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
      expect = 4;
      sol.test(matrix, expect);
   }
}

/*
01
138 / 138 test cases passed.
Status: Accepted
Runtime: 8 ms
Memory Usage: 38.9 MB
*/
