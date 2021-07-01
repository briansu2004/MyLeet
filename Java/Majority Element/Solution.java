/**
 * 
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/824/
 * Majority Element

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1
Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.Arrays;
import java.util.HashMap;

class Solution {
   //02
   public int majorityElement(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int n = nums.length;
      for (int num : nums) {
         map.put(num, map.getOrDefault(num, 0) + 1);
         //System.out.println(map.get(num));
         if (map.get(num) > n / 2) {
            return num;
         }
      }
      return 0;
   }

   // 01
   public int majorityElement1(int[] nums) {
      Arrays.sort(nums);

      return nums[nums.length / 2];
   }

   public void test(int[] nums, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("majorityElement(%s): %s", Arrays.toString(nums), majorityElement(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 3, 2, 3 };
      int expect = 3;
      sol.test(nums, expect);

      nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
      expect = 2;
      sol.test(nums, expect);
   }
}

/*
01
47 / 47 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 44.7 MB
Your runtime beats 99.91 % of java submissions.
*/

/*
02
47 / 47 test cases passed.
Status: Accepted
Runtime: 12 ms
Memory Usage: 44.3 MB
*/

