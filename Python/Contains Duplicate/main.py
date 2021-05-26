"""
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/
Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Example 2:
Input: nums = [1,2,3,4]
Output: false
Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
"""

from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(nums) != len(set(nums))

if __name__ == "__main__":
    sol = Solution()

    nums = [1,2,3,1]
    print(f"nums:", nums)
    print(f"containsDuplicate(nums):", sol.containsDuplicate(nums))

    nums = [1,2,3,4]
    print(f"nums:", nums)
    print(f"containsDuplicate(nums):", sol.containsDuplicate(nums))

    nums = [1,1,1,3,3,4,3,2,4,2]
    print(f"nums:", nums)
    print(f"containsDuplicate(nums):", sol.containsDuplicate(nums))


#01
# 16 / 16 test cases passed.
# Status: Accepted
# Runtime: 116 ms
# Memory Usage: 20.4 MB


# Method 1 -- Apply hashtable O(n)
# hashNum = {}
# for i in nums:
#     if i not in hashNum:
#         hashNum[i] = 1
#     else:
#         return True
# return False

# Method 2 -- Sorting
# l =  len(nums)
# if l < 2:
#     return False
# nums.sort()
# for i in range(l-1):
#     if nums[i] == nums[i+1]:
#         return True
# return False

# Method 3 -- Set solution for python
# numsSet =  set(nums)
# if len(nums) == len(numsSet):
#     return False
# return True