
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/
 * Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

Follow up: Could you use search pruning to make your solution faster with a larger board?
 * 
 */

import java.util.Arrays;

class Solution {
   //01
   static boolean[][] visited;

   public boolean exist(char[][] board, String word) {
      visited = new boolean[board.length][board[0].length];

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean search(char[][] board, String word, int i, int j, int index) {
      if (index == word.length()) {
         return true;
      }

      if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)
            || visited[i][j]) {
         return false;
      }

      visited[i][j] = true;
      if (search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1)
            || search(board, word, i, j - 1, index + 1) || search(board, word, i, j + 1, index + 1)) {
         return true;
      }

      visited[i][j] = false;
      return false;
   }

   public void test(char[][] board, String word, boolean expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("exist(%s, %s): %s", Arrays.deepToString(board), word, exist(board, word)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
      char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
      String word = "ABCCED";
      boolean expect = true;
      sol.test(board, word, expect);

      // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
      board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
      word = "SEE";
      expect = true;
      sol.test(board, word, expect);

      // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
      board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
      word = "ABCB";
      expect = false;
      sol.test(board, word, expect);
   }
}

/*
* 01
50 / 50 test cases passed.
Status: Accepted
Runtime: 71 ms
Memory Usage: 37 MB
*/
