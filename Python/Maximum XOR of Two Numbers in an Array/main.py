"""
https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1057/
Maximum XOR of Two Numbers in an Array

Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i ≤ j < n.
Follow up: Could you do this in O(n) runtime?

Example 1:
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:
Input: nums = [0]
Output: 0
Example 3:
Input: nums = [2,4]
Output: 6
Example 4:
Input: nums = [8,10,2]
Output: 10
Example 5:
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127

Constraints:
1 <= nums.length <= 2 * 104
0 <= nums[i] <= 231 - 1
"""

from typing import List


class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        answer = 0
        for i in range(32)[::-1]:
            answer <<= 1
            prefixes = {num >> i for num in nums}
            answer += any(answer^1 ^ p in prefixes for p in prefixes)
        return answer


if __name__ == "__main__":
    sol = Solution()

    nums = [3,10,5,25,2,8]
    print(f"nums:", nums)
    print(f"sol.findMaximumXOR(nums):", sol.findMaximumXOR(nums))
    print()

    nums = [0]
    print(f"nums:", nums)
    print(f"sol.findMaximumXOR(nums):", sol.findMaximumXOR(nums))
    print()

    nums = [2,4]
    print(f"nums:", nums)
    print(f"sol.findMaximumXOR(nums):", sol.findMaximumXOR(nums))
    print()

    nums = [8,10,2]
    print(f"nums:", nums)
    print(f"sol.findMaximumXOR(nums):", sol.findMaximumXOR(nums))
    print()

    nums = [14,70,53,83,49,91,36,80,92,51,66,70]
    print(f"nums:", nums)
    print(f"sol.findMaximumXOR(nums):", sol.findMaximumXOR(nums))
    print()

# 01
# 40 / 40 test cases passed.
# Status: Accepted
# Runtime: 344 ms
# Memory Usage: 21.5 MB
