"""
https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/
Max Consecutive Ones

Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.

Hint #1  
You need to think about two things as far as any window is concerned. One is the starting point for the window. How do you detect that a new window of 1s has started? The next part is detecting the ending point for this window. How do you detect the ending point for an existing window? If you figure these two things out, you will be able to detect the windows of consecutive ones. All that remains afterward is to find the longest such window and return the size.

"""

from itertools import groupby


class Solution(object):
    #02
    def findMaxConsecutiveOnes(self, nums):
        return max(map(len, ''.join(map(str, nums)).split('0')))

    #01
    def findMaxConsecutiveOnes1(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return max(sum(g) for _, g in groupby(nums))


if __name__ == "__main__":
    sol = Solution()

    nums = [1, 1, 0, 1, 1, 1]
    print("findMaxConsecutiveOnes({0}): {1}".format(
        nums, sol.findMaxConsecutiveOnes(nums)))


# 01
# 42 / 42 test cases passed.
# Status: Accepted
# Runtime: 492 ms
# Memory Usage: 13.5 MB

# 02
# 42 / 42 test cases passed.
# Status: Accepted
# Runtime: 432 ms
# Memory Usage: 14 MB
