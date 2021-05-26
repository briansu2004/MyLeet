"""
https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1033/

https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

Constraints:
n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.

Hint #1  
Array was originally in ascending order. Now that the array is rotated, there would be a point in the array where there is a small deflection from the increasing sequence. eg. The array would be something like [4, 5, 6, 7, 0, 1, 2].
Hint #2  
You can divide the search space into two and see which direction to go. Can you think of an algorithm which has O(logN) search complexity?
Hint #3  
All the elements to the left of inflection point > first element of the array.
All the elements to the right of inflection point < first element of the array.
"""

from typing import List
#import bisect

class Solution:
    #02
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low,high = 0, len(nums)-1
        if nums[low] <= nums[high]:
            return nums[low]
        while high-low != 1:
            mid = low + (high-low)//2
            if nums[low] < nums[mid]:
                low = mid
            else:
                high = mid
        return nums[high]
    
    #01
    def findMin1(self, nums: List[int]) -> int:
        # self.__getitem__ = lambda i: nums[i] <= nums[-1]
        # return nums[bisect.bisect(self, False, 0, len(nums))]
        first, last = 0, len(nums) - 1
        while first < last:
            midpoint = (first + last) // 2
            if nums[midpoint] > nums[last]:
                first = midpoint + 1
            else:
                last = midpoint
        return nums[first]

if __name__ == "__main__":
    nums = [3,4,5,1,2]
    print("findMin({0}): {1}".format(nums, Solution.findMin(Solution, nums)))

    nums = [4,5,6,7,0,1,2]
    print("findMin({0}): {1}".format(nums, Solution.findMin(Solution, nums)))

    nums = [11,13,15,17]
    print("findMin({0}): {1}".format(nums, Solution.findMin(Solution, nums)))



#01
# 150 / 150 test cases passed.
# Status: Accepted
# Runtime: 72 ms
# Memory Usage: 14.7 MB

#02
# 150 / 150 test cases passed.
# Status: Accepted
# Runtime: 36 ms
# Memory Usage: 13.7 MB
