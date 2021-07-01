
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/120/sorting-and-searching/857/
 * Wiggle Sort II
 * 
Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
You may assume the input array always has a valid answer.

Example 1:
Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.
Example 2:
Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]

Constraints:
1 <= nums.length <= 5 * 104
0 <= nums[i] <= 5000
It is guaranteed that there will be an answer for the given input nums.

Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

import java.util.Arrays;


class Solution {
   //02
   public void wiggleSort(int[] nums) {
      var count = new int[5001];
      for (int num : nums) {
         ++count[num];
      }
      boolean isLengthEven = nums.length % 2 == 0;
      var index = isLengthEven ? nums.length - 2 : nums.length - 1;

      for (int i = 0; i <= 5000; i++) {
         for (int j = 0; j < count[i]; j++) {
            nums[index] = i;

            if (index == 0) {
               index = isLengthEven ? nums.length - 1 : nums.length - 2;
            } else {
               index -= 2;
            }
         }
      }
   }

   //01
   public void wiggleSort1(int[] nums) {
      if (nums == null || nums.length == 0)
         return;
      int len = nums.length;
      int median = findMedian(0, len - 1, len / 2, nums);
      int left = 0, right = len - 1, i = 0;
      // map current index firstly
      while (i <= right) {
         int mappedCurIndex = newIndex(i, len);
         if (nums[mappedCurIndex] > median) {
            int mappedLeftIndex = newIndex(left, len);
            swap(mappedLeftIndex, mappedCurIndex, nums);
            left++;
            i++;
         } else if (nums[mappedCurIndex] < median) {
            int mappedRightIndex = newIndex(right, len);
            swap(mappedCurIndex, mappedRightIndex, nums);
            right--;
         } else {
            i++;
         }
      }
   }

   // {0,1,2,3,4,5} -> {1,3,5,0,2,4}
   // find mapped new inde
   public int newIndex(int index, int len) {
      return (1 + 2 * index) % (len | 1);
   }

   // use quicksort, average O(n) time
   public int findMedian(int start, int end, int k, int[] nums) {
      if (start > end)
         return Integer.MAX_VALUE;
      int pivot = nums[end];
      int indexOfWall = start;
      for (int i = start; i < end; i++) {
         if (nums[i] <= pivot) {
            swap(i, indexOfWall, nums);
            indexOfWall++;
         }
      }
      swap(indexOfWall, end, nums);
      if (indexOfWall == k) {
         return nums[indexOfWall];
      } else if (indexOfWall < k) {
         return findMedian(indexOfWall + 1, end, k, nums);
      } else {
         return findMedian(start, indexOfWall - 1, k, nums);
      }
   }

   public void swap(int i, int j, int[] nums) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

   public void test(int[] nums) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("Before: %s", Arrays.toString(nums)));
      wiggleSort(nums);
      System.out.println(String.format("After: %s", Arrays.toString(nums)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 1, 5, 1, 1, 6, 4 };
      sol.test(nums);

      nums = new int[] { 1, 3, 2, 2, 3, 1 };
      sol.test(nums);
   }
}

/*
01
47 / 47 test cases passed.
Status: Accepted
Runtime: 100 ms
Memory Usage: 42.9 MB

02
47 / 47 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 41.4 MB
Your runtime beats 100.00 % of java submissions

*/


