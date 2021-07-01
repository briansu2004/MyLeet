/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/833/
 * Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
   //02
   public int longestConsecutive(int[] nums) {
      if (nums.length == 0)
         return 0;
      Arrays.sort(nums);
      int target[] = new int[nums.length];
      int max = 0;
      Arrays.fill(target, 1);
      max = target[0];
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] == nums[i - 1] + 1) {
            target[i] = target[i - 1] + 1;
         }
         if (nums[i] == nums[i - 1]) {
            target[i] = target[i - 1];
         }
         max = Math.max(target[i], max);
      }
      return max;
   }

   //01
   private static final int MAX_ARRAY_LEN = 10000;

   public int longestConsecutive1(int[] nums) {
      return longestConsecutiveArray(nums);
      // return longestConsecutiveHashSet(nums);
      // return longestConsecutiveSorted(nums);
   }

   // O(n)
   // Only optimized for closely packed nums
   // Otherwise delegates to longestConsecutiveHashSet
   private static int longestConsecutiveArray(int[] nums) {
      if (nums.length == 0)
         return 0;

      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int num : nums) {
         min = Math.min(min, num);
         max = Math.max(max, num);
      }
      int length = max - min + 1;
      if (length > MAX_ARRAY_LEN) {
         return longestConsecutiveHashSet(nums);
      }

      boolean[] exists = new boolean[length];
      for (int num : nums) {
         exists[num - min] = true;
      }

      int maxLen = 0;
      int currLen = 0;
      for (boolean exist : exists) {
         if (exist) {
            currLen++;
         } else {
            maxLen = Math.max(maxLen, currLen);
            currLen = 0;
         }
      }
      return Math.max(maxLen, currLen);
   }

   // O(n)
   private static int longestConsecutiveHashSet(int[] nums) {
      if (nums.length == 0)
         return 0;

      Set<Integer> values = new HashSet<>();
      for (int i : nums) {
         values.add(i);
      }

      int maxLen = 1;
      for (int num : values) {
         // Look for the beginning of the sequence
         if (values.contains(num - 1))
            continue;

         int currNum = num + 1;
         while (values.contains(currNum)) {
            currNum++;
         }
         maxLen = Math.max(maxLen, currNum - num);
      }
      return maxLen;
   }

   // O(nlogn)
   private static int longestConsecutiveSorted(int[] nums) {
      if (nums.length == 0)
         return 0;

      Arrays.sort(nums);
      int maxLen = 1;
      int currLen = 1;
      int length = nums.length;
      for (int i = 1; i < length; i++) {
         // Seeing the same element does not increase the sequence
         if (nums[i] == nums[i - 1])
            continue;

         if (nums[i] == nums[i - 1] + 1) {
            currLen++;
         } else {
            maxLen = Math.max(maxLen, currLen);
            currLen = 1;
         }
      }
      return Math.max(maxLen, currLen);
   }

   //Mine
   public int longestConsecutive0(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      if (nums.length == 1) {
         return 1;
      }

      Arrays.sort(nums);

      int max = 1;
      int n = 1;
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] == nums[i - 1]) {
            continue;
         }
         if (nums[i] - nums[i - 1] > 1) {
            if (n > max) {
               max = n;
            }
            n = 1;
         } else {
            n++;
         }

      }

      return max > n ? max : n;
   }

   public void test(int[] nums, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("longestConsecutive(%s): %s", Arrays.toString(nums), longestConsecutive(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 100, 4, 200, 1, 3, 2 };
      int expect = 4;
      sol.test(nums, expect);

      nums = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
      expect = 9;
      sol.test(nums, expect);

      nums = new int[] {};
      expect = 0;
      sol.test(nums, expect);

      nums = new int[] { 1 };
      expect = 0;
      sol.test(nums, expect);

      nums = new int[] { 1, 2 };
      expect = 1;
      sol.test(nums, expect);

      nums = new int[] { 1, 3 };
      expect = 1;
      sol.test(nums, expect);

      nums = new int[] { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 }; //3 4 5 6 7 8 9
      expect = 7;
      sol.test(nums, expect);
   }
}

/*
Mine
70 / 70 test cases passed.
Status: Accepted
Runtime: 17 ms
Memory Usage: 58.6 MB
Your runtime beats 56.71 % of java submissions.
Your memory usage beats 29.77 % of java submissions.
*/

/*
01
70 / 70 test cases passed.
Status: Accepted
Runtime: 44 ms
Memory Usage: 54.4 MB
*/

