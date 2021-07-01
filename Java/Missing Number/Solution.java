
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/722/
 * Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Example 4:
Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.

Constraints:
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 * 
 */

import java.util.Arrays;

class Solution {
   // Mine
   public int missingNumber(int[] nums) {
      for (int i = 0; i <= nums.length; i++) {
         int j = i;
         if (!Arrays.stream(nums).anyMatch(x -> x == j)) {
            return i;
         }
      }
      return 0;
   }

   public void test(int [] nums, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("missingNumber(%s): %s", Arrays.toString(nums), missingNumber(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = new int[] { 0, 1 };
      sol.test(nums, 2);

      nums = new int[] { 0 };
      sol.test(nums, 1);

      nums = new int[] { 1 };
      sol.test(nums, 0);

      nums = new int[] { 3, 0, 1 };
      sol.test(nums, 2);

      nums = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
      sol.test(nums, 8);
   }
}

/*
Mine
122 / 122 test cases passed.
Status: Accepted
Runtime: 2347 ms
Memory Usage: 38.7 MB
Your memory usage beats 99.11 % of java submissions.
 */