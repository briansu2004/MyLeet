
/**
 * 
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/
 * 
 * Set Matrix Zeroes

Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1

   Show Hint #1  
If any cell of the matrix has a zero we can record its row and column number using additional memory. But if you don't want to use extra memory then you can manipulate the array instead. i.e. simulating exactly what the question says.
   Hide Hint #2  
Setting cell values to zero on the fly while iterating might lead to discrepancies. What if you use some other integer value as your marker? There is still a better approach for this problem with 0(1) space.
   Hide Hint #3  
We could have used 2 sets to keep a record of rows/columns which need to be set to zero. But for an O(1) space solution, you can use one of the rows and and one of the columns to keep track of this information.
   Hide Hint #4  
We can use the first cell of every row and column as a flag. This flag would determine whether a row or column has been set to zero.
 * 
 */

import java.util.Arrays;

class Solution {
   //04
   public void setZeroes(int[][] matrix) {
      int col0 = 1, rows = matrix.length, cols = matrix[0].length;

      for (int i = 0; i < rows; i++) {
         if (matrix[i][0] == 0)
            col0 = 0;
         for (int j = 1; j < cols; j++)
            if (matrix[i][j] == 0)
               matrix[i][0] = matrix[0][j] = 0;
      }

      for (int i = rows - 1; i >= 0; i--) {
         for (int j = cols - 1; j >= 1; j--)
            if (matrix[i][0] == 0 || matrix[0][j] == 0)
               matrix[i][j] = 0;
         if (col0 == 0)
            matrix[i][0] = 0;
      }
   }

   //03
   public void setZeroes3(int[][] matrix) {
      int row = matrix.length;
      int col = matrix[0].length;
      boolean a[][] = new boolean[row][col];
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
            if (matrix[i][j] == 0)
               a[i][j] = true;
         }
      }
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
            if (a[i][j] == true)
               set(matrix, i, j);
         }
      }
      // for (int i = 0; i < row; i++) {
      //    for (int j = 0; j < col; j++) {
      //       System.out.print(matrix[i][j] + " ");
      //    }
      //    System.out.println();
      // }
   }

   public static void set(int matrix[][], int row, int col) {
      for (int j = 0; j < matrix[0].length; j++)
         matrix[row][j] = 0;
      for (int i = 0; i < matrix.length; i++)
         matrix[i][col] = 0;
   }
  
   //02
   public void nullifyRow(int[][] A, int r) {
       int col = A[r].length;
       for(int i = 0; i < col; i++)
           A[r][i] = 0;
   }

   public void nullifyCol(int[][] A, int c) {
       int row = A.length;
       for(int i = 0; i < row; i++)
           A[i][c] = 0;
   }

   public void setZeroes2(int[][] A) {
       if(A == null)
           return;
       
       boolean rowHasZero = false;
       boolean colHasZero = false;
       
       int row = A.length;
       int col = A[0].length;
       
       for(int i = 0; i < row; i++)
       {
           if(A[i][0] == 0)
           {
               colHasZero = true;
               break;
           }
       }
       
       for(int j = 0; j < col; j++)
       {
           if(A[0][j] == 0)
           {
               rowHasZero = true;
               break;
           }
       }
       
       for(int i = 1; i < row; i++)
       {
           for(int j = 1; j < col; j++)
           {
               if(A[i][j] == 0)
               {
                   A[i][0] = 0;
                   A[0][j] = 0;
               }
           }
       }
       
       for(int i = 1; i < row; i++)
       {
           if(A[i][0] == 0)
               nullifyRow(A, i);
       }
       
       for(int j = 1; j < col; j++)
       {
           if(A[0][j] == 0)
               nullifyCol(A, j);
       }
       
       if(colHasZero)
       {
           nullifyCol(A, 0);
       }
       
       if(rowHasZero)
       {
           nullifyRow(A, 0);
       }
   }

   //01
   public void setZeroes1(int[][] matrix) {
      int m = matrix.length, n = matrix[0].length, k = 0;
      // First row has zero?
      while (k < n && matrix[0][k] != 0)
         ++k;
      // Use first row/column as marker, scan the matrix
      for (int i = 1; i < m; ++i)
         for (int j = 0; j < n; ++j)
            if (matrix[i][j] == 0)
               matrix[0][j] = matrix[i][0] = 0;
      // Set the zeros
      for (int i = 1; i < m; ++i)
         for (int j = n - 1; j >= 0; --j)
            if (matrix[0][j] == 0 || matrix[i][0] == 0)
               matrix[i][j] = 0;
      // Set the zeros for the first row
      if (k < n)
         Arrays.fill(matrix[0], 0);
   }

   public void test(int[][] nums) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("Before: %s", Arrays.deepToString(nums)));
      setZeroes(nums);
      System.out.println(String.format("After: %s", Arrays.deepToString(nums)));
      // System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      // [[1,1,1],[1,0,1],[1,1,1]]
      // expect: [[1,0,1],[0,0,0],[1,0,1]]
      int[][] nums = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
      sol.test(nums);

   }
}


/*
04
164 / 164 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 50.8 MB
*/

/*
03
164 / 164 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 52.4 MB
*/

/* 
02
164 / 164 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 50.6 MB
*/

/*
01
164 / 164 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 50.7 MB
*/

