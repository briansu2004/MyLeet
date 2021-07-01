
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/566/
 * Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:
Input: nums = [1]
Output: 1
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23

Constraints:
1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

import java.util.Arrays;

class Solution {
    // 02
    public int maxSubArray(int[] nums) {
        int current_subarray = nums[0];
        int max_subarray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current_subarray += nums[i];
            if (current_subarray < nums[i]) {
                current_subarray = nums[i];
            }
            max_subarray = Math.max(max_subarray, current_subarray);
        }
        System.gc();

        return max_subarray;
    }

    // 01
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }

    public void test(int[] nums) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("maxSubArray(%s): %s", Arrays.toString(nums), maxSubArray(nums)));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        sol.test(nums);

        nums = new int[] { 1 };
        sol.test(nums);

        nums = new int[] { 5, 4, -1, 7, 8 };
        sol.test(nums);

        nums = new int[] { -3, -2, -1 };
        sol.test(nums);

        nums = new int[] { 0, 1 };
        sol.test(nums);

        nums = new int[] { 0 };
        sol.test(nums);
    }
}

/*
 * 01 203 / 203 test cases passed. Status: Accepted Runtime: 0 ms Memory Usage:
 * 39 MB Your runtime beats 100.00 % of java submissions.
 */

/*
 * 02 203 / 203 test cases passed. Status: Accepted Runtime: 2 ms Memory Usage:
 * 38.3 MB Your memory usage beats 99.23 % of java submissions
 */