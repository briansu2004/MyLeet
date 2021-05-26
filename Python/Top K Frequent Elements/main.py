"""
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/
Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 
Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
"""


from typing import List
from collections import Counter
import heapq


class Solution:
    #02
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        dic = {}
        for n in nums:
            if n not in dic:
                dic[n] = 1
            else:
                dic[n] += 1
        
        maxFreq = 0
        freq2num = {}
        for key,val in dic.items():
            if val in freq2num:
                freq2num[val].append(key)
            else:
                freq2num[val] = [key]
            maxFreq = max(maxFreq,val)
        
        res = []
        for f in range(maxFreq,-1,-1):
            if f in freq2num:
                res += freq2num[f]
            if len(res) >= k:
                return res

    #01
    def topKFrequent1(self, nums: List[int], k: int) -> List[int]:
        res = []
        dic = Counter(nums)
        max_heap = [(-val, key) for key, val in dic.items()]
        heapq.heapify(max_heap)
        for i in range(k):
            res.append(heapq.heappop(max_heap)[1])
        return res


if __name__ == "__main__":
    sol = Solution()

    nums = [1, 1, 1, 2, 2, 3]
    k = 2
    print("topKFrequent({0}, {1}): {2}".format(
        nums, k, sol.topKFrequent(nums, k)))

    nums = [1]
    k = 1
    print("topKFrequent({0}, {1}): {2}".format(
        nums, k, sol.topKFrequent(nums, k)))


# 01
# 21 / 21 test cases passed.
# Status: Accepted
# Runtime: 88 ms
# Memory Usage: 18.9 MB

# 02
# 21 / 21 test cases passed.
# Status: Accepted
# Runtime: 104 ms
# Memory Usage: 18.6 MB
