/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/827/
 * Product of Array Except Self
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 
Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/

import java.util.Arrays;

class Solution {
   // 01
   public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] res = new int[n];
      res[0] = 1;
      for (int i = 1; i < n; i++) {
         res[i] = res[i - 1] * nums[i - 1];
      }
      int right = 1;
      for (int i = n - 1; i >= 0; i--) {
         res[i] *= right;
         right *= nums[i];
      }
      return res;
   }// -1, 1, 0, -3, 3

   //Mine
   public int[] productExceptSelf0(int[] nums) {
      int cntZero = 0;
      int p = 1;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == 0) {
            cntZero++;
            if (cntZero > 1) {
               p = 0;
               break;
            } else {
               continue;
            }
         } else {
            p *= nums[i];
         }
      }
      System.out.println(String.format("p: %s; cntZero: %s", p, cntZero));

      for (int i = 0; i < nums.length; i++) {
         if (cntZero > 1) {
            nums[i] = 0;
         } else if (cntZero == 0) {
            nums[i] = p / nums[i];
         } else if (nums[i] == 0) {
            nums[i] = p;
         } else {
            nums[i] = 0;
         }
      }

      return nums;
   }

   public void test(int[] nums, int[] expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("productExceptSelf(%s): %s", Arrays.toString(nums),
            Arrays.toString(productExceptSelf(nums))));
      System.out.println(String.format("Expect: %s", Arrays.toString(expect)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 1, 2, 3, 4 };
      int[] expect = { 24, 12, 8, 6 };
      sol.test(nums, expect);

      nums = new int[] { -1, 1, 0, -3, 3 };
      expect = new int[] { 0, 0, 9, 0, 0 };
      sol.test(nums, expect);

      nums = new int[] { 1, 0, 0, 4 };
      expect = new int[] { 0, 0, 0, 0 };
      sol.test(nums, expect);

      nums = new int[] { -3, 2, -12, 40 };
      expect = new int[] { -960, 1440, -240, 72 };
      sol.test(nums, expect);

      nums = new int[] { -1,1,0,-3,3 };
      expect = new int[] { 0,0,9,0,0 };
      sol.test(nums, expect);
   }
}

/*
Mine
20 / 20 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 47.5 MB
Your runtime beats 27.32 % of java submissions.
Your memory usage beats 97.41 % of java submissions.
*/

/*
*01
20 / 20 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 49.8 MB
Your runtime beats 100.00 % of java submissions.
Your memory usage beats 55.20 % of java submissions.
*/

