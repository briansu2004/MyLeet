/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/120/sorting-and-searching/858/
 * Kth Smallest Element in a Sorted Matrix
 * 
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:
Input: matrix = [[-5]], k = 1
Output: -5

Constraints:
n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
*/

import java.util.Arrays;

class Solution {
   //02
   public int kthSmallest(int[][] matrix, int k) {
      for (int i = 0; i < k - 1; i++) {
         helper(matrix, 0, 0);
      }

      return matrix[0][0];
   }

   public void helper(int[][] matrix, int x, int y) {
      if (x == matrix.length - 1 && y == matrix[0].length - 1) {
         matrix[x][y] = Integer.MAX_VALUE;
         return;
      }

      Integer first = null;
      Integer second = null;

      if (y < matrix[0].length - 1)
         first = matrix[x][y + 1];

      if (x < matrix.length - 1)
         second = matrix[x + 1][y];

      if (first == null) {
         matrix[x][y] = second;
         helper(matrix, x + 1, y);
         return;
      }

      if (second == null) {
         matrix[x][y] = first;
         helper(matrix, x, y + 1);
         return;
      }

      if (first < second) {
         matrix[x][y] = first;
         helper(matrix, x, y + 1);
      } else {
         matrix[x][y] = second;
         helper(matrix, x + 1, y);
      }
   }

   //01
   //Main loop is binary search of max - min.
   //Swap from left-bottom to right-top can get count <= mid in O(n) time instead of O(nlogn), total complexity will be O(nlogm) while m = max - min.
   public int kthSmallest1(int[][] matrix, int k) {
      int n = matrix.length;
      int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
      while (lo <= hi) {
         int mid = lo + (hi - lo) / 2;
         int count = getLessEqual(matrix, mid);
         if (count < k)
            lo = mid + 1;
         else
            hi = mid - 1;
      }
      return lo;
   }

   private int getLessEqual(int[][] matrix, int val) {
      int res = 0;
      int n = matrix.length, i = n - 1, j = 0;
      while (i >= 0 && j < n) {
         if (matrix[i][j] > val)
            i--;
         else {
            res += i + 1;
            j++;
         }
      }
      return res;
   }

   public void test(int[][] matrix, int k, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out
            .println(String.format("kthSmallest(%s, %s): %s", Arrays.deepToString(matrix), k, kthSmallest(matrix, k)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
      int k = 8;
      int expect = 13;
      sol.test(matrix, k, expect);

      matrix = new int[][] { { -5 } };
      k = 1;
      expect = -5;
      sol.test(matrix, k, expect);
   }
}

/*
01
85 / 85 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 44.6 MB
Your runtime beats 100.00 % of java submissions.

02
85 / 85 test cases passed.
Status: Accepted
Runtime: 415 ms
Memory Usage: 41.1 MB
*/
