"""
https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/
Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:
Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:
Input: nums1 = [2], nums2 = []
Output: 2.00000

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
"""


from typing import List


class Solution(object):
    # 02
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        a, b = sorted((nums1, nums2), key=len)
        m, n = len(a), len(b)
        after = int((m + n - 1) / 2)
        lo, hi = 0, m
        while lo < hi:
            i = int((lo + hi) / 2)
            if after-i-1 < 0 or a[i] >= b[after-i-1]:
                hi = i
            else:
                lo = i + 1
        i = lo
        nextfew = sorted(a[i:i+2] + b[after-i:after-i+2])
        return (nextfew[0] + nextfew[1 - (m+n) % 2]) / 2.0

    # 01
    def findMedianSortedArrays1(self, A, B):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        l = len(A)+len(B)
        return self.findKth(A, B, l//2) if l % 2 == 1 else (self.findKth(A, B, l//2-1)+self.findKth(A, B, l//2))/2.0

    def findKth(self, A, B, k):
        if len(A) > len(B):
            A, B = B, A
        if not A:
            return B[k]
        if k == len(A)+len(B)-1:
            return max(A[-1], B[-1])
        i = len(A)//2
        j = k-i
        if A[i] > B[j]:
            # Here I assume it is O(1) to get A[:i] and B[j:]. In python, it's not but in cpp it is.
            return self.findKth(A[:i], B[j:], i)
        else:
            return self.findKth(A[i:], B[:j], j)


if __name__ == "__main__":
    nums1 = [1, 3]
    nums2 = [2]
    print("findMedianSortedArrays({0}, {1}): {2}".format(
        nums1, nums2, Solution.findMedianSortedArrays(Solution, nums1, nums2)))

    nums1 = [1, 2]
    nums2 = [3, 4]
    print("findMedianSortedArrays({0}, {1}): {2}".format(
        nums1, nums2, Solution.findMedianSortedArrays(Solution, nums1, nums2)))

    nums1 = [0, 0]
    nums2 = [0, 0]
    print("findMedianSortedArrays({0}, {1}): {2}".format(
        nums1, nums2, Solution.findMedianSortedArrays(Solution, nums1, nums2)))

    nums1 = []
    nums2 = [1]
    print("findMedianSortedArrays({0}, {1}): {2}".format(
        nums1, nums2, Solution.findMedianSortedArrays(Solution, nums1, nums2)))

    nums1 = [2]
    nums2 = []
    print("findMedianSortedArrays({0}, {1}): {2}".format(
        nums1, nums2, Solution.findMedianSortedArrays(Solution, nums1, nums2)))

# 01

# 02
# 2094 / 2094 test cases passed.
# Status: Accepted
# Runtime: 108 ms
# Memory Usage: 14.4 MB