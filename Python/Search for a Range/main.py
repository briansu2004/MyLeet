"""
https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
Search for a Range

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
"""

from typing import List
import bisect

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """            
        if not nums:
            return [-1, -1]
        left = bisect.bisect_left(nums, target)
        if left >= len(nums) or nums[left] != target:
            return [-1, -1]
        right = bisect.bisect_right(nums, target)
        return [left, right-1]

if __name__ == "__main__":
    nums = []
    target = 0
    print("searchRange({0}, {1}): {2}".format(nums, target, Solution.searchRange(Solution, nums, target)))

    nums = [8]
    target = 8
    print("searchRange({0}, {1}): {2}".format(nums, target, Solution.searchRange(Solution, nums, target)))

    nums = [5,7,7,8,8,10]
    target = 8
    print("searchRange({0}, {1}): {2}".format(nums, target, Solution.searchRange(Solution, nums, target)))

    nums = [5,7,7,8,8,10]
    target = 6
    print("searchRange({0}, {1}): {2}".format(nums, target, Solution.searchRange(Solution, nums, target)))

#01
# 88 / 88 test cases passed.
# Status: Accepted
# Runtime: 220 ms
# Memory Usage: 15.4 MB
