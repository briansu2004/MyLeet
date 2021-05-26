"""
https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/
Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
Example 3:
Input: nums = [1,1]
Output: 1
Example 4:
Input: nums = [1,1,2]
Output: 1

Constraints:
2 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 
Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
"""


class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) < 2:
            return None

        slow = 0
        fast = 0
        while True:
            fast = nums[nums[fast]]
            slow = nums[slow]
            if slow == fast:
                break
        slow = 0
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        return slow


if __name__ == "__main__":
    nums = [1, 3, 4, 2, 2]
    print("findDuplicate({0}): {1}".format(
        nums, Solution.findDuplicate(Solution, nums)))

    nums = [3, 1, 3, 4, 2]
    print("findDuplicate({0}): {1}".format(
        nums, Solution.findDuplicate(Solution, nums)))

    nums = [1, 1]
    print("findDuplicate({0}): {1}".format(
        nums, Solution.findDuplicate(Solution, nums)))

    nums = [1, 1, 2]
    print("findDuplicate({0}): {1}".format(
        nums, Solution.findDuplicate(Solution, nums)))

    nums = []
    print("findDuplicate({0}): {1}".format(
        nums, Solution.findDuplicate(Solution, nums)))

    nums = [3]
    print("findDuplicate({0}): {1}".format(
        nums, Solution.findDuplicate(Solution, nums)))

# 01
# 58 / 58 test cases passed.
# Status: Accepted
# Runtime: 600 ms
# Memory Usage: 25.2 MB
