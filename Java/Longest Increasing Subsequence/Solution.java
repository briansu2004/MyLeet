/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/810/
 * Longest Increasing Subsequence
 * 
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */

import java.util.Arrays;

class Solution {
   // 02
   static void print1D(int[] arr) {
      for (int ele : arr)
         System.out.print(ele + " ");
      System.out.println();
   }

   public int lengthOfLIS(int[] arr) {
      int n = arr.length;
      int[] tailTable = new int[n + 1];

      tailTable[1] = arr[0];
      int len = 1;

      for (int i = 1; i < n; i++) {
         if (arr[i] <= tailTable[1]) {
            tailTable[1] = arr[i];
         } else if (tailTable[len] < arr[i]) {
            tailTable[++len] = arr[i];
         } else {
            tailTable[ceilIndex(tailTable, 1, len, arr[i])] = arr[i];
         }
      }
      print1D(tailTable);
      return len;
   }

   // Return the Ceil (Smallest Element Greater than tar) or Equal Index of tar { 10, 9, 2, 5, 3, 7, 101, 18 };
   public static int ceilIndex(int[] tailTable, int si, int ei, int tar) {
      while (si <= ei) {
         int mid = si + (ei - si) / 2;

         if (tailTable[mid] >= tar)
            ei = mid - 1;
         else
            si = mid + 1;
      }

      return si;
   }

   // 01
   public static int findPositionToReplace(int[] a, int low, int high, int x) {
      int mid;
      while (low <= high) {
         mid = low + (high - low) / 2;
         if (a[mid] == x)
            return mid;
         else if (a[mid] > x)
            high = mid - 1;
         else
            low = mid + 1;
      }
      return low;
   }

   public static int lengthOfLIS1(int[] nums) {
      if (nums == null | nums.length == 0)
         return 0;
      int n = nums.length, len = 0;
      int[] increasingSequence = new int[n];
      increasingSequence[len++] = nums[0];
      for (int i = 1; i < n; i++) {
         if (nums[i] > increasingSequence[len - 1])
            increasingSequence[len++] = nums[i];
         else {
            int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
            increasingSequence[position] = nums[i];
         }
      }
      return len;
   }

   public void test(int[] nums, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("lengthOfLIS(%s): %s", Arrays.toString(nums), lengthOfLIS(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
      int expect = 4;
      sol.test(nums, expect);

      nums = new int[] { 0, 1, 0, 3, 2, 3 };
      expect = 4;
      sol.test(nums, expect);

      nums = new int[] { 7, 7, 7, 7, 7, 7, 7 };
      expect = 1;
      sol.test(nums, expect);

      nums = new int[] { 6 };
      expect = 1;
      sol.test(nums, expect);
   }
}

/*
01
54 / 54 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 41.6 MB
Your runtime beats 81.79 % of java submissions.
*/
