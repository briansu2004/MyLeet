/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/121/dynamic-programming/860/
 * Maximum Product Subarray
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/

import java.util.Arrays;

class Solution {
   //02
   public int maxProduct(int[] nums) {
      if (nums.length == 1) {
         return nums[0];
      }
      int prev = 1;
      int max = 0;
      for (int i = 0; i < nums.length; i++) {
         prev *= nums[i];
         max = Math.max(max, prev);
         if (prev == 0) {
            prev = 1;
         }
      }
      prev = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
         prev *= nums[i];
         max = Math.max(max, prev);
         if (prev == 0) {
            prev = 1;
         }
      }
      return max;
   }

   // 01
   //Loop through the array, each time remember the max and min value for the previous product, the most important thing is to update the max and min value: we have to compare among max * A[i], min * A[i] as well as A[i], since this is product, a negative * negative could be positive.
   public int maxProduct1(int[] A) {
      if (A == null || A.length == 0) {
         return 0;
      }
      int max = A[0], min = A[0], result = A[0];
      for (int i = 1; i < A.length; i++) {
         int temp = max;
         max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
         min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
         if (max > result) {
            result = max;
         }
      }
      return result;
   }

   public void test(int[] nums, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("maxProduct(%s): %s", Arrays.toString(nums), maxProduct(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 2, 3, -2, 4 };
      int expect = 6;
      sol.test(nums, expect);

      nums = new int[] { -2, 0, -1 };
      expect = 0;
      sol.test(nums, expect);
   }
}

/*
01
187 / 187 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38.3 MB
Your runtime beats 91.83 % of java submissions.
Your memory usage beats 98.69 % of java submissions.

02
187 / 187 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 38.4 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 94.99 % of java submissions.
*/
