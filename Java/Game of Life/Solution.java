/**
 * 
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/831/
 *  * Game of Life

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.

Follow up:
Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
*/

import java.util.Arrays;

class Solution {
   // 01
   public void gameOfLife(int[][] board) {
      if (board == null || board.length == 0)
         return;
      int m = board.length, n = board[0].length;

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            int lives = liveNeighbors(board, m, n, i, j);

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when will the 2nd bit become 1.
            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
               board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
            }
            if (board[i][j] == 0 && lives == 3) {
               board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
         }
      }

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            board[i][j] >>= 1; // Get the 2nd state.
         }
      }
   }

   public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
      int lives = 0;
      for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
         for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
            lives += board[x][y] & 1;
         }
      }
      lives -= board[i][j] & 1;
      return lives;
   }

   public void test(int[][] board, int[][] expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("Before: %s", Arrays.deepToString(board)));
      gameOfLife(board);
      System.out.println(String.format("After: %s", Arrays.deepToString(board)));
      System.out.println(String.format("Expect: %s", Arrays.deepToString(expect)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
      int[][] expect = { { 0, 0, 0 }, { 1, 0, 1 }, { 0, 1, 1 }, { 0, 1, 0 } };
      sol.test(board, expect);

      board = new int[][] { { 1, 1 }, { 1, 0 } };
      expect = new int[][] { { 1, 1 }, { 1, 1 } };
      sol.test(board, expect);

   }
}

/*
01
To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)  
- 10  live (next) <- dead (current)  
- 11  live (next) <- live (current) 
In the beginning, every cell is either 00 or 01.
Notice that 1st state is independent of 2nd state.
Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
Let's count # of neighbors from 1st state and set 2nd state bit.
Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
In the end, delete every cell's 1st state by doing >> 1.
For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
Transition 00 -> 10: when board == 0 and lives == 3.
To get the current state, simply do

board[i][j] & 1
To get the next state, simply do

board[i][j] >> 1

22 / 22 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 37.1 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 86.75 % of java submissions.
*/