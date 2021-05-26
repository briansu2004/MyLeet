"""
https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
Largest Number At Least Twice of Others

You are given an integer array nums where the largest integer is unique.
Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.

Example 1:
Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
Example 2:
Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.
Example 3:
Input: nums = [1]
Output: 0
Explanation: 1 is trivially at least twice the value as any other number because there are no other numbers.

Constraints:
1 <= nums.length <= 50
0 <= nums[i] <= 100
The largest element in nums is unique.

Hint #1  
Scan through the array to find the unique largest element `m`, keeping track of it's index `maxIndex`. Scan through the array again. If we find some `x != m` with `m < 2*x`, we should return `-1`. Otherwise, we should return `maxIndex`.

"""

from typing import List


class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        largest = nums[0]
        second_largest = -float('inf')
        largest_index = 0
        
        for idx in range(1,len(nums)):
            if nums[idx]>largest:
                second_largest = largest
                largest = nums[idx]
                largest_index = idx
            elif nums[idx]>second_largest:
                second_largest = nums[idx]
        return largest_index if largest >= second_largest*2 else -1

if __name__ == "__main__":
    sol = Solution()

    nums = [3,6,1,0]
    print(f"nums:", nums)
    print(f"dominantIndex(nums):", sol.dominantIndex(nums))

    nums = [1,2,3,4]
    print(f"nums:", nums)
    print(f"dominantIndex(nums):", sol.dominantIndex(nums))

    nums = [1]
    print(f"nums:", nums)
    print(f"dominantIndex(nums):", sol.dominantIndex(nums))


# 01
