
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/576/
 * House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

import java.util.Arrays;

class Solution {
    // 01
    public int rob(int[] nums) {
        int pre = 0, cur = 0;
        for (int num : nums) {
            final int temp = Integer.max(pre + num, cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public void test(int[] nums) {
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("rob(%s): %s", Arrays.toString(nums), rob(nums)));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = new int[] { 1, 2, 3, 1 };
        sol.test(nums);

        nums = new int[] { 1 };
        sol.test(nums);

        nums = new int[] { 2, 7, 9, 3, 1 };
        sol.test(nums);

    }
}

/*
 * 01
 * 68 / 68 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 36 MB
 * Your memory usage beats 86.47 % of java submissions
 * 
 */
