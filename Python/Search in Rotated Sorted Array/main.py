"""
https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/
Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
"""

from typing import List


class Solution:
    # 02
    def search(self, nums: List[int], target: int) -> int:
        # technically, it is same as binary search
        l = 0
        r = len(nums)
        while(l < r):
            m = (l+r)//2

            # set mid number as nums[m] is target and nums[m] are on the same side. otherwide set as -inf or inf
            if (nums[m] < nums[0]) == (target < nums[0]):       # if both are on the same side
                mid = nums[m]
            # both are not same side and target is on the right side, set mid as -inf
            elif (target < nums[0]):
                mid = float('-inf')
            else:
                mid = float('inf')

            if mid < target:
                l = m+1
            elif mid > target:
                r = m
            else:  # mid == target
                return m

        return -1  # if we couldn't find it

    # 01
    def search1(self, nums: List[int], target: int) -> int:
        if target in nums:
            return nums.index(target)
        else:
            return -1


if __name__ == "__main__":
    nums = [4, 5, 6, 7, 0, 1, 2]
    target = 0
    print("search({0}, {1}): {2}".format(
        nums, target, Solution.search(Solution, nums, target)))

    nums = [4, 5, 6, 7, 0, 1, 2]
    target = 3
    print("search({0}, {1}): {2}".format(
        nums, target, Solution.search(Solution, nums, target)))

    nums = [1]
    target = 0
    print("search({0}, {1}): {2}".format(
        nums, target, Solution.search(Solution, nums, target)))


#01
# 195 / 195 test cases passed.
# Status: Accepted
# Runtime: 44 ms
# Memory Usage: 14.7 MB

#02
# 195 / 195 test cases passed.
# Status: Accepted
# Runtime: 56 ms
# Memory Usage: 14.7 MB
