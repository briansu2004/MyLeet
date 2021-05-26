"""
https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 
Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 
Constraints:
1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
"""

from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        lo, hi = 0, n
        while lo < hi:
            mid = lo + hi >> 1
            if arr[mid] < x:
                lo = mid + 1
            else:
                hi = mid
        left, right = lo - 1, lo
        while k:
            leftElem = arr[left] if left >= 0 else float('-inf')
            rightElem = arr[right] if right < n else float('inf')
            if x - leftElem <= rightElem - x:
                left -= 1
            else:
                right += 1
            k -= 1
        return arr[left+1:right]


if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5]
    k = 4
    x = 3
    print("findClosestElements({0}, {1}, {2}): {3}".format(
        arr, k, x, Solution.findClosestElements(Solution, arr, k, x)))

    arr = [1, 2, 3, 4, 5]
    k = 4
    x = -1
    print("findClosestElements({0}, {1}, {2}): {3}".format(
        arr, k, x, Solution.findClosestElements(Solution, arr, k, x)))


# 01
# 62 / 62 test cases passed.
# Status: Accepted
# Runtime: 500 ms
# Memory Usage: 15.4 MB
