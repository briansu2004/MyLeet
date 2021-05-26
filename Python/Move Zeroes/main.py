"""
https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1174/
Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?

Hint #1  
In-place means we should not be allocating any space for extra array. But we are allowed to modify the existing array. However, as a first step, try coming up with a solution that makes use of additional space. For this problem as well, first apply the idea discussed using an additional array and the in-place solution will pop up eventually.
Hint #2  
A two-pointer approach could be helpful here. The idea would be to have one pointer for iterating the array and another pointer that just works on the non-zero elements of the array.
"""


from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        for j in range(len(nums)):
            if nums[j] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1


if __name__ == "__main__":
    sol = Solution()

    nums = [0, 1, 0, 3, 12]
    print(nums)
    print("moveZeroes({0}): {1}".format(
        nums, sol.moveZeroes(nums)))
    print(nums)

    nums = [0]
    print(nums)
    print("moveZeroes({0}): {1}".format(
        nums, sol.moveZeroes(nums)))
    print(nums)


# 01
# 21 / 21 test cases passed.
# Status: Accepted
# Runtime: 40 ms
# Memory Usage: 15.5 MB
