"""
https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
Find Pivot Index

Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

Constraints:
1 <= nums.length <= 104
-1000 <= nums[i] <= 1000

We can precompute prefix sums P[i] = nums[0] + nums[1] + ... + nums[i-1]. Then for each index, the left sum is P[i], and the right sum is P[P.length - 1] - P[i] - nums[i].
"""

from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return -1
        elif len(nums) == 1:
            return 0
        if sum(nums[1:]) == 0:
            return 0
        pivot = 1
        lsum = nums[0]
        rsum = sum(nums[pivot+1:])
        if lsum == rsum:
            return 1
        while pivot < len(nums)-1:
            lsum += nums[pivot]
            rsum -= nums[pivot+1]
            pivot += 1
            if lsum == rsum:
                return pivot
        return -1


if __name__ == "__main__":
    sol = Solution()

    nums = [1, 7, 3, 6, 5, 6]
    print(f"nums:", nums)
    print(f"pivotIndex(nums):", sol.pivotIndex(nums))

    nums = [1,2,3]
    print(f"nums:", nums)
    print(f"pivotIndex(nums):", sol.pivotIndex(nums))

    nums = [2,1,-1]
    print(f"nums:", nums)
    print(f"pivotIndex(nums):", sol.pivotIndex(nums))


# 01
# 742 / 742 test cases passed.
# Status: Accepted
# Runtime: 160 ms
# Memory Usage: 15.4 MB
