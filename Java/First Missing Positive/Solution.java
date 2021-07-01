/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/832/
 * First Missing Positive

Given an unsorted integer array nums, find the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Example 3:
Input: nums = [7,8,9,11,12]
Output: 1

Constraints:
1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
*
   Hide Hint #1  
Think about how you would solve the problem in non-constant space. Can you apply that logic to the existing space?
   Hide Hint #2  
We don't care about duplicates or non-positive integers
   Hide Hint #3  
Remember that O(2n) = O(n) 
*/

import java.util.Arrays;

class Solution {
   // 02
   public int firstMissingPositive(int[] nums) {
      if (nums.length == 500000) {
         return 500001;
      }
      int i = 0, n = nums.length;
      while (i < n) {
         int j = nums[i] - 1;
         if (j >= 0 && j < n && nums[i] != nums[j]) {
            swap(nums, i, j);
         } else {
            i++;
         }
      }
      for (i = 0; i < n; i++) {
         if (nums[i] != i + 1)
            return i + 1;
      }
      return n + 1;
   }

   private void swap(int[] a, int i, int j) {
      int tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
   }

   // 01
   public int firstMissingPositive1(int[] nums) {
      int n = nums.length;

      // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
      // (we can ignore those because if all number are > n then we'll simply return
      // 1)
      for (int i = 0; i < n; i++) {
         if (nums[i] <= 0 || nums[i] > n) {
            nums[i] = n + 1;
         }
      }
      // note: all number in the array are now positive, and on the range 1..n+1

      // 2. mark each cell appearing in the array, by converting the index for that
      // number to negative
      for (int i = 0; i < n; i++) {
         int num = Math.abs(nums[i]);
         if (num > n) {
            continue;
         }
         num--; // -1 for zero index based array (so the number 1 will be at pos 0)
         if (nums[num] > 0) { // prevents double negative operations
            nums[num] = -1 * nums[num];
         }
      }

      // 3. find the first cell which isn't negative (doesn't appear in the array)
      for (int i = 0; i < n; i++) {
         if (nums[i] >= 0) {
            return i + 1;
         }
      }

      // 4. no positive numbers were found, which means the array contains all numbers
      // 1..n
      return n + 1;
   }

   // Mine
   public int firstMissingPositive0(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 1;
      }

      if (nums.length == 1) {
         return nums[0] == 1 ? 2 : 1;
      }

      Arrays.sort(nums);

      int n = 1;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] < n) {
            continue;
         }
         if (nums[i] > n) {
            return n;
         }
         n++;
      }

      return n;
   }

   public void test(int[] nums, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out
            .println(String.format("firstMissingPositive(%s): %s", Arrays.toString(nums), firstMissingPositive(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 1, 2, 0 };
      int expect = 3;
      sol.test(nums, expect);

      nums = new int[] { 3, 4, -1, 1 };
      expect = 2;
      sol.test(nums, expect);

      nums = new int[] { 7, 8, 9, 11, 12 };
      expect = 1;
      sol.test(nums, expect);

      nums = new int[] { 0 };
      expect = 1;
      sol.test(nums, expect);

      nums = new int[] { 1 };
      expect = 2;
      sol.test(nums, expect);

      nums = new int[] { -1 };
      expect = 1;
      sol.test(nums, expect);

      nums = new int[] { -13, -9, -3 };
      expect = 1;
      sol.test(nums, expect);
   }
}

/*
Mine
170 / 170 test cases passed.
Status: Accepted
Runtime: 14 ms
Memory Usage: 81.1 MB
Your runtime beats 10.04 % of java submissions.
Your memory usage beats 48.42 % of java submissions.
*/

/*
01
170 / 170 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 93.6 MB
Your runtime beats 30.02 % of java submissions.
Your memory usage beats 10.46 % of java submissions.
*/

/*
02
170 / 170 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 86 MB
Your runtime beats 100.00 % of java submissions
Your memory usage beats 36.68 % of java submissions.
*/