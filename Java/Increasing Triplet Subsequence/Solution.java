
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/
 * Increasing Triplet Subsequence

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

Constraints:
1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
 
Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 * 
 * 
 */

import java.util.Arrays;

class Solution {


   //02
   public boolean increasingTriplet(int[] nums) {
      if (nums.length <= 2) return false;
      
      int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
      for(int n : nums) {
          if (n <= a) a=n;
          else if (n <= b) b=n;
          else return true;
      }     
      return false;
   }
 
   // 01
   public boolean increasingTriplet1(int[] nums) {
      // start with two largest values, as soon as we find a number bigger than both,
      // while both have been updated, return true.
      int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
      for (int n : nums) {
         if (n <= small) {
            small = n;
         } // update small if n is smaller than both
         else if (n <= big) {
            big = n;
         } // update big only if greater than small but smaller than big
         else {
            return true; // return if you find a number bigger than both
         }
      }
      return false;
   }

   // Mine
   public boolean increasingTripletMine(int[] nums) {
      if (nums == null || nums.length < 3) {
         return false;
      }

      for (int i = 0; i < nums.length - 2; i++) {
         for (int j = i + 1, k = nums.length - 1; j < k;) {
            while (nums[i] >= nums[j] && j < k) {
               j++;
            }

            while ((nums[i] >= nums[k] || nums[j] >= nums[k]) && j < k - 1) {
               k--;
            }

            if (nums[i] < nums[j] && nums[j] < nums[k]) {
               return true;
            }
         }
      }

      return false;
   }

   public void test(int[] nums, boolean expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("increasingTriplet(%s): %s", Arrays.toString(nums), increasingTriplet(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = new int[] { 1, 2, 3, 4, 5 };
      sol.test(nums, true);

      nums = new int[] { 5, 4, 3, 2, 1 };
      sol.test(nums, false);

      nums = new int[] { 2, 1, 5, 0, 4, 6 };
      sol.test(nums, true);

      nums = new int[] { 2 };
      sol.test(nums, false);
   }
}


/*
* Mine
Time Limit Exceeded 
*/

/*
01
76 / 76 test cases passed.
Status: Accepted
Memory Usage: 80712000
*/

/*
*02
76 / 76 test cases passed.
Status: Accepted
Runtime: 4 ms
Memory Usage: 88.5 MB
*/
