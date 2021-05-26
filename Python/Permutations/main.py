"""
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2903/
Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
"""

from functools import reduce
import itertools

class Solution(object):
    #04
    def permute(self, nums):
        #return map(list, itertools.permutations(nums))
        return list(itertools.permutations(nums))

    #03
    def permute3(self, nums):
        return reduce(lambda P, n: [p[:i] + [n] + p[i:] for p in P for i in range(len(p)+1)], nums, [[]])

    #02
    def permute2(self, nums):
        return nums and [p[:i] + [nums[0]] + p[i:]
            for p in self.permute(self, nums[1:])
            for i in range(len(nums))] or [[]]

    #01
    def permute1(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return [[n] + p for i, n in enumerate(nums) for p in self.permute(self, nums[:i] + nums[i+1:])] or [[]]

if __name__ == "__main__":
    h = [0]
    print("permute({0}): {1}".format(h, Solution.permute(Solution, h)))

    h = [8,9]
    print("permute({0}): {1}".format(h, Solution.permute(Solution, h)))

    h = [1,2,3]
    print("permute({0}): {1}".format(h, Solution.permute(Solution, h)))



# 01
# 25 / 25 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 13.7 MB

# 02
# 25 / 25 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 13.6 MB

# 03
# has diffs

#04
# 25 / 25 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 13.4 MB
