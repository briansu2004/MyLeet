"""
https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/
Target Sum

You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:
Input: nums = [1], target = 1
Output: 1

Constraints:
1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
"""



import collections


class Solution(object):
    def findTargetSumWays(self, A, S):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        count = collections.Counter({0: 1})
        for x in A:
            step = collections.Counter()
            for y in count:
                step[y + x] += count[y]
                step[y - x] += count[y]
            count = step
        return count[S]


if __name__ == "__main__":
    sol = Solution()

    nums = [1, 1, 1, 1, 1]
    target = 3
    print("findTargetSumWays({0}, {1}): {2}".format(
        nums, target, sol.findTargetSumWays(nums, target)))


# 01
# 138 / 138 test cases passed.
# Status: Accepted
# Runtime: 360 ms
# Memory Usage: 13.5 MB

# 02
