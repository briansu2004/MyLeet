"""
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176/
Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
"""

from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            res ^= num
        return res

if __name__ == "__main__":
    sol = Solution()

    nums = [2,2,1]
    print(f"nums:", nums)
    print(f"singleNumber(nums):", sol.singleNumber(nums))

    nums = [4,1,2,1,2]
    print(f"nums:", nums)
    print(f"singleNumber(nums):", sol.singleNumber(nums))

    nums = [1]
    print(f"nums:", nums)
    print(f"singleNumber(nums):", sol.singleNumber(nums))



#01
# 61 / 61 test cases passed.
# Status: Accepted
# Runtime: 132 ms
# Memory Usage: 16.7 MB



# def singleNumber1(self, nums):
#     dic = {}
#     for num in nums:
#         dic[num] = dic.get(num, 0)+1
#     for key, val in dic.items():
#         if val == 1:
#             return key

# def singleNumber2(self, nums):
#     res = 0
#     for num in nums:
#         res ^= num
#     return res
    
# def singleNumber3(self, nums):
#     return 2*sum(set(nums))-sum(nums)
    
# def singleNumber4(self, nums):
#     return reduce(lambda x, y: x ^ y, nums)
    
# def singleNumber(self, nums):
#     return reduce(operator.xor, nums)
