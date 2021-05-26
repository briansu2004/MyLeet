"""
https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1034/
Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
"""


class Solution(object):
    #02
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        return list(set(nums1).intersection(set(nums2)))

    #01
    def intersection1(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        return list(set(nums1) & set(nums2))

if __name__ == "__main__":
    nums1 = [1,2,2,1]
    nums2 = [2,2]
    print("intersection({0}, {1}): {2}".format(nums1, nums2, Solution.intersection(Solution, nums1, nums2)))

    nums1 = [4,9,5]
    nums2 = [9,4,9,8,4]
    print("intersection({0}, {1}): {2}".format(nums1, nums2, Solution.intersection(Solution, nums1, nums2)))



# 01
# 55 / 55 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 13.7 MB

# 02
# 55 / 55 test cases passed.
# Status: Accepted
# Runtime: 48 ms
# Memory Usage: 13.7 MB
