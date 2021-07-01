/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/843/
 * Surrounded Regions

Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
Example 2:
Input: board = [["X"]]
Output: [["X"]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 * 
 * 
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
   //03
   int mapping(int x, int y) {
      return x * 200 + y;// you need make sure it's large enough
   }

   int[] ds = new int[40000 + 40000];// where 1000 * 1000 = 1000000

   int find(int x) {
      if (ds[x] != x) {
         return ds[x] = find(ds[x]);
      }
      return x;
   }

   void union(int x, int y) {
      x = find(x);
      y = find(y);
      if (x < y) {
         ds[y] = x;
      } else {
         ds[x] = y;
      }
   }

   // disjoin set
   public void solve(char[][] board) {
      if (board == null || board.length == 0) {
         return;
      }
      int m = board.length;
      int n = board[0].length;

      int outside = mapping(m + 1, n + 1);
      // init disjoint sets
      for (int i = 0; i < outside + 1; ++i) {
         ds[i] = i;
      }

      for (int i = 0; i < m; ++i) {
         for (int j = 0; j < n; ++j) {
            if (board[i][j] == 'X') {
               continue;
            }
            if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {// ken: connect to outside
               union(mapping(i, j), outside);
               continue;
            }

            if (board[i - 1][j] == 'O') {
               union(mapping(i, j), mapping(i - 1, j));
            }
            if (board[i + 1][j] == 'O') {
               union(mapping(i, j), mapping(i + 1, j));
            }
            if (board[i][j - 1] == 'O') {
               union(mapping(i, j), mapping(i, j - 1));
            }
            if (board[i][j + 1] == 'O') {
               union(mapping(i, j), mapping(i, j + 1));
            }
         }
      }
      for (int i = 0; i < m; ++i) {
         for (int j = 0; j < n; ++j) {
            if (board[i][j] == 'O' && find(mapping(i, j)) != find(outside)) {
               board[i][j] = 'X';
            }
         }
      }
   }

   //02
   public void solve2(char[][] board) {
      // marking all the islands as ' ' (visited) if 'O' at corners(firt and last row
      // and column) as then they can't be captured

      for (int i = 0; i < board.length; i++) {
         if (board[i][0] == 'O')
            dfs(board, i, 0);
         if (board[i][board[0].length - 1] == 'O')
            dfs(board, i, board[0].length - 1);
      }
      for (int j = 0; j < board[0].length; j++) {
         if (board[0][j] == 'O')
            dfs(board, 0, j);
         if (board[board.length - 1][j] == 'O')
            dfs(board, board.length - 1, j);
      }

      // covert 'O' -> 'X' for rest all Os
      restore(board, 'O', 'X');
      // convert visited ' ' to O as they can't be captured (since lie at corner
      // row/colm)
      restore(board, ' ', 'O');
      // return board;
   }

   // dfs run
   void dfs(char[][] surface, int i, int j) {

      if (i < 0 || i >= surface.length || j < 0 || j >= surface[0].length || surface[i][j] != 'O') {
         return;
      }

      surface[i][j] = ' '; // marked visited

      dfs(surface, i + 1, j);
      dfs(surface, i, j + 1);
      dfs(surface, i - 1, j);
      dfs(surface, i, j - 1);
   }

   void restore(char[][] board, char c1, char c2) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == c1)
               board[i][j] = c2;
         }
      }
   }

   // 01
   public static void solve1(char[][] board) {
      if (board == null || board.length == 0)
         return;
      int rows = board.length, columns = board[0].length;
      int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
      for (int i = 0; i < rows; i++)
         for (int j = 0; j < columns; j++) {
            if ((i == 0 || i == rows - 1 || j == 0 || j == columns - 1) && board[i][j] == 'O') {
               Queue<Point> queue = new LinkedList<>();
               board[i][j] = 'B';
               queue.offer(new Point(i, j));
               while (!queue.isEmpty()) {
                  Point point = queue.poll();
                  for (int k = 0; k < 4; k++) {
                     int x = direction[k][0] + point.x;
                     int y = direction[k][1] + point.y;
                     if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O') {
                        board[x][y] = 'B';
                        queue.offer(new Point(x, y));
                     }
                  }
               }
            }
         }
      for (int i = 0; i < rows; i++)
         for (int j = 0; j < columns; j++) {
            if (board[i][j] == 'B')
               board[i][j] = 'O';
            else if (board[i][j] == 'O')
               board[i][j] = 'X';
         }

   }

   public void test(char[][] board, char[][] expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("Before: %s", Arrays.deepToString(board)));
      solve(board);
      System.out.println(String.format("After: %s", Arrays.deepToString(board)));
      System.out.println(String.format("Expect: %s", Arrays.deepToString(expect)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
            { 'X', 'O', 'X', 'X' } };
      char[][] expect = { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
            { 'X', 'O', 'X', 'X' } };
      sol.test(board, expect);

      board = new char[][] { { 'X' } };
      expect = new char[][] { { 'X' } };
      sol.test(board, expect);

   }
}

/*
01
58 / 58 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 41.1 MB
*/

/*
02
58 / 58 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 48.8 MB
*/

/*
03
58 / 58 test cases passed.
Status: Accepted
Runtime: 11 ms
Memory Usage: 55.6 MB
*/
