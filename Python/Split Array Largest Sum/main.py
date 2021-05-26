"""
https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1042/
Split Array Largest Sum

Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m subarrays.

Example 1:
Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Example 2:
Input: nums = [1,2,3,4,5], m = 2
Output: 9
Example 3:
Input: nums = [1,4,4], m = 3
Output: 4

Constraints:
1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= m <= min(50, nums.length)
"""

from typing import List


class Solution(object):
    # 01
    def splitArray(self, nums, m):
        """
        :type nums: List[int]
        :type m: int
        :rtype: int
        """
        def cannot_split(max_sum, m):
            cuts, curr_sum = 0, 0
            for x in nums:
                curr_sum += x
                if curr_sum > max_sum:
                    cuts += 1
                    curr_sum = x
            subs = cuts + 1
            return (subs > m)

        low, high = max(nums), sum(nums)
        while low < high:
            guess = low + (high - low) // 2
            if cannot_split(guess, m):
                low = guess + 1
            else:
                high = guess
        return low


if __name__ == "__main__":
    nums = [1, 4, 4]
    k = 3
    print("splitArray({0}, {1}): {2}".format(
        nums, k, Solution.splitArray(Solution, nums, k)))

    nums = [1, 2, 3, 4, 5]
    k = 2
    print("splitArray({0}, {1}): {2}".format(
        nums, k, Solution.splitArray(Solution, nums, k)))

    nums = [1, 4, 4]
    k = 3
    print("splitArray({0}, {1}): {2}".format(
        nums, k, Solution.splitArray(Solution, nums, k)))


# 01
# 30 / 30 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 13.4 MB
