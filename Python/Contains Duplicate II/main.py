"""
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1121/
Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

"""

class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        dic = {}
        for i, v in enumerate(nums):
            if v in dic and i - dic[v] <= k:
                return True
            dic[v] = i
        return False

if __name__ == "__main__":
    sol = Solution()

    nums = [1,2,3,1,2,3]
    k = 2
    print(f"nums:", nums)
    print(f"k:", k)
    print(f"containsNearbyDuplicate(nums, k):", sol.containsNearbyDuplicate(nums, k))

    nums = [1,0,1,1]
    k = 1
    print(f"nums:", nums)
    print(f"k:", k)
    print(f"containsNearbyDuplicate(nums, k):", sol.containsNearbyDuplicate(nums, k))

    nums = [1,2,3,1]
    k = 3
    print(f"nums:", nums)
    print(f"k:", k)
    print(f"containsNearbyDuplicate(nums, k):", sol.containsNearbyDuplicate(nums, k))



# 01
# 23 / 23 test cases passed.
# Status: Accepted
# Runtime: 80 ms
# Memory Usage: 17.6 MB
