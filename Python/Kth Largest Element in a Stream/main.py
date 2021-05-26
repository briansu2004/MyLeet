"""
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1018/
kth Largest Element in a Stream

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Returns the element representing the kth largest element in the stream.

Example 1:
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]
Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8

Constraints:
1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.
"""

from typing import List
from heapq import heapify, heappop, heappush, heappushpop

class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.arr = nums

        heapify(self.arr)

        # Keep popping smaller elemnts till size = k
        while len(self.arr) > self.k:
            heappop(self.arr)

    def add(self, val: int) -> int:
        heap_top = 0

        # Always keep heap size = k
        # Top element = kth largest element
        if len(self.arr) < self.k:
            heappush(self.arr, val)
        else:
            heappushpop(self.arr, val)

        return self.arr[heap_top]

    def print(self) -> str:
        return "0"


# if __name__ == "__main__":
#     nums = [5, 3, 6, 2, 4, None, 7]
#     k = 3

#     obj = KthLargest(k, nums)
#     print("KthLargest({0}, {1}): {2}".format(nums, k, obj.print()))

#     param_1 = obj.add(3)
#     print("KthLargest({0}, {1}): {2}".format(nums, k, obj.print()))


# 01
# 10 / 10 test cases passed.
# Status: Accepted
# Runtime: 100 ms
# Memory Usage: 18.1 MB
