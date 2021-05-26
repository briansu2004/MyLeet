"""
https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1031/
Find Minimum in Rotated Sorted Array II

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

Example 1:
Input: nums = [1,3,5]
Output: 1
Example 2:
Input: nums = [2,2,2,0,1]
Output: 0

Constraints:
n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums is sorted and rotated between 1 and n times.

Follow up: This is the same as Find Minimum in Rotated Sorted Array but with duplicates. Would allow duplicates affect the run-time complexity? How and why?
"""


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low,high = 0,len(nums)-1
        while low < high:
            mid = low + int((high-low)/2)
            if nums[mid] > nums[high]:
                low = mid + 1
            elif nums[mid] < nums[high]:
                high = mid
            else: # nums[mid] == nums[high]
                if nums[mid] == nums[low]:
                    low, high = low + 1, high - 1
                else:
                    high = mid
        return nums[low]

if __name__ == "__main__":
    nums = [2,2,2,0,1]
    print("findMin({0}): {1}".format(nums, Solution.findMin(Solution, nums)))

    nums = [2,2,2,0,1]
    print("findMin({0}): {1}".format(nums, Solution.findMin(Solution, nums)))

    nums = [1]
    print("findMin({0}): {1}".format(nums, Solution.findMin(Solution, nums)))


# 01
