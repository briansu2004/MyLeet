
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/
 * Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:
Input: nums = [0]
Output: [0]
Example 4:
Input: nums = [1]
Output: [1]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
   Hide Hint #1  
A rather straight forward solution is a two-pass algorithm using counting sort.
   Hide Hint #2  
Iterate the array counting number of 0's, 1's, and 2's.
   Hide Hint #3  
Overwrite array with the total number of 0's, then 1's and followed by 2's.
 * 
 */

import java.util.Arrays;

class Solution {
   // 03
   public void sortColors(int[] nums) {
      int left = 0;
      int mid = 0;
      int right = nums.length - 1;
      while (mid <= right) {
         switch (nums[mid]) {
            case 0:
               int temp = nums[left];
               nums[left] = nums[mid];
               nums[mid] = temp;
               left++;
               mid++;
               break;
            case 1:
               mid++;
               break;
            case 2:
               temp = nums[right];
               nums[right] = nums[mid];
               nums[mid] = temp;
               right--;
               break;
         }
      }
   }

   // 02
   public void sortColors2(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
         for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
            }
         }
      }
   }

   // Mine
   public void sortColorsMine(int[] nums) {
      int n0 = 0, n1 = 0;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == 0) {
            n0++;
         } else if (nums[i] == 1) {
            n1++;
         }
      }

      for (int i = 0; i < n0; i++) {
         nums[i] = 0;
      }
      for (int i = n0; i < n0 + n1; i++) {
         nums[i] = 1;
      }
      for (int i = n0 + n1; i < nums.length; i++) {
         nums[i] = 2;
      }
   }

   // 01
   private int[] nums;

   public void sortColors1(int[] nums) {
      // one pass
      this.nums = nums;
      int low = -1;
      int high = nums.length;
      int mid = 0;

      while (mid < high) {
         if (nums[mid] == 1) {
            mid++;
         } else if (nums[mid] == 0) {
            ++low;
            swap(mid, low);
            // skip one, must be 1 bcz you already go through it
            mid++;
         } else {
            high--;
            swap(mid, high);
         }
      }
   }

   private void swap(int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

   public void test(int[] nums) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("Before: %s", Arrays.toString(nums)));
      sortColors(nums);
      System.out.println(String.format("After: %s", Arrays.toString(nums)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = new int[] { 0 };
      sol.test(nums);

      nums = new int[] { 1 };
      sol.test(nums);

      nums = new int[] { 2, 0, 1 };
      sol.test(nums);

      nums = new int[] { 2, 0, 2, 1, 1, 0 };
      sol.test(nums);
   }
}

/*
* 01
87 / 87 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 39.2 MB
*/

/*
Mine
87 / 87 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 39.5 MB
*/

/*
02
87 / 87 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 37.3 MB
*/

/*
03
87 / 87 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 39 MB
*/
