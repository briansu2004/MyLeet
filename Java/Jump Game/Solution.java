
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/807/
 * Jump Game

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
 * 
 */

import java.util.Arrays;

class Solution {
   //02
   public boolean canJump(int[] nums) {
      int[] dp = new int[nums.length];
      dp[nums.length - 1] = 1;
      for (int i = nums.length - 2; i >= 0; i--) {
         int furtherestJump = Math.min(i + nums[i], nums.length - 1);
         for (int j = i + 1; j <= furtherestJump; j++) {
            if (dp[j] == 1) {
               dp[i] = 1;
               break;
            }
         }
      }
      return dp[0] == 1;
   }


   //The easiest way to think about this problem is to ask are the elements with a 0 value avoidable? 
   //this is the algorithm that I constructed to answer this question.
   //Starting from the second to last element in the array we continue to decrement towards the start of the array. 
   //Only stopping if we hit an element with a value of 0; 
   //in this case we evaluate if there exist an element somewhere at the start of the array which has a jump value large enough to jump over this 0 value element.

   // 01
   public boolean canJump1(int[] nums) {
      if (nums.length < 2)
         return true;

      for (int curr = nums.length - 2; curr >= 0; curr--) {
         if (nums[curr] == 0) {
            int neededJumps = 1;
            while (neededJumps > nums[curr]) {
               neededJumps++;
               curr--;
               if (curr < 0)
                  return false;
            }
         }
      }
      return true;
   }

   // Mine
   public boolean canJump0(int[] nums) {
      if (nums.length == 1) {
         return true;
      }

      for (int i = 0; i < nums.length - 1; i++) {
         if (nums[i] == 0) {
            return false;
         }
      }

      return true;
   }

   public void test(int[] nums, boolean expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("canJump(%s): %s", Arrays.toString(nums), canJump(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = new int[] { 2, 3, 1, 1, 4 };
      boolean expect = true;
      sol.test(nums, expect);

      nums = new int[] { 3, 2, 1, 0, 4 };
      expect = false;
      sol.test(nums, expect);

      nums = new int[] { 0 };
      expect = true;
      sol.test(nums, expect);

      nums = new int[] { 2, 0 };
      expect = true;
      sol.test(nums, expect);

      nums = new int[] { 2, 0, 0 };
      expect = true;
      sol.test(nums, expect);
   }
}

/*
*01
165 / 165 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 64.5 MB
*/

/*
02
165 / 165 test cases passed.
Status: Accepted
Runtime: 127 ms
Memory Usage: 65.5 MB
*/

