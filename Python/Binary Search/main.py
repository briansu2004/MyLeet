"""
https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 104
-9999 <= nums[i], target <= 9999
All the integers in nums are unique.
nums is sorted in an ascending order.
"""

from typing import List
import bisect

class Solution:
    #02
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            m = (l + r) // 2
            if nums[m] == target:
                return m
            elif nums[m] < target:
                l = m + 1
            else:
                r = m - 1
        return -1

    #01
    def search1(self, nums: List[int], target: int) -> int:
        i = bisect_left(nums, target) 
        return i if i != len(nums) and nums[i] == target else -1   
        

if __name__ == "__main__":
    nums = []
    target = 9
    print("search({0}, {1}): {2}".format(nums, target, Solution.search(Solution, nums, target)))
    
    nums = [1]
    target = 1
    print("search({0}, {1}): {2}".format(nums, target, Solution.search(Solution, nums, target)))
    
    nums = [-1,0,3,5,9,12]
    target = 9
    print("search({0}, {1}): {2}".format(nums, target, Solution.search(Solution, nums, target)))
    


# 01

#02
# 46 / 46 test cases passed.
# Status: Accepted
# Runtime: 268 ms
# Memory Usage: 15.6 MB
