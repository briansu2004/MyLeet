"""
https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1041/
Find K-th Smallest Pair Distance

Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

Hint #1  
Binary search for the answer. How can you check how many pairs have distance <= X?
"""


class Solution(object):
    # 02
    def smallestDistancePair(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        i = 0
        j = nums[-1] - nums[0]
        med = (i+j)//2
        rank = [-1, -1]
        closestDistance = 0
        flag = True
        while not rank[0] <= k <= rank[1]:
            rank, closestDistance = self.rank(self, nums, med)
            if rank[0] > k:
                j = med
            else:
                i = med
            med = (i+j)//2
            if j - i == 1:
                if flag:
                    med = i
                    flag = False
                else:
                    med = j
        return closestDistance

    def rank(self, nums, distance):
        rank = [0, 0]
        start = 0
        closestDistance = 2*(nums[-1] - nums[0])
        for i in range(len(nums)):
            target = nums[i] + distance
            a, b = self.findNode(self, nums, max(i, start), len(nums)-1, target)
            if b >= a:
                if nums[a] == target:
                    rank[0] += a - i - 1
                else:
                    rank[0] += b - i
                rank[1] += b - i
                start = b
                currentDistance = nums[a]-nums[i]
                if abs(currentDistance - distance) < abs(closestDistance - distance):
                    closestDistance = currentDistance
        rank[0] += 1
        return rank, closestDistance

    # find all nodes that are small than and closest to val
    def findNode(self, nums, a, b, val):
        i = a
        j = b
        med = (i+j) // 2
        while j - i > 1:
            if nums[med] > val:
                j = med
            elif nums[med] < val:
                i = med
            else:
                i = j = med
            med = (i+j) // 2
        res = i
        if nums[j] <= val:
            res = j
        i = j = res
        while i >= 0 and nums[i] == nums[res]:
            i -= 1
        while j < len(nums) and nums[j] == nums[res]:
            j += 1
        i += 1
        j -= 1
        return i, j

    # 01

    def smallestDistancePair1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
    # Return: Is there k or more pairs with distance <= guess? i.e. are
    # there enough?
        def possible(guess_dist):
            i = count = 0
            j = 1
            # Notice that we never decrement j or i.
            while i < len(nums):
                # If the distance calculated from j-i is less than the guess,
                # increase the window on `j` side.
                while (j < len(nums)) and ((nums[j] - nums[i]) <= guess_dist):
                    j += 1
                # Count all places between j and i
                count += j - i - 1
                i += 1
            return count >= k

        if not nums or len(nums) < 2:
            return 0

        nums.sort()
        lo = 0
        hi = nums[-1] - nums[0]

        while lo < hi:
            mid = (lo + hi) // 2
            # If `mid` produced `k` or more results we know it's the upper bound.
            if possible(mid):
                # We don't set to `mid - 1` because we found a number of distances
                # bigger than *or equal* to `k`. If this `mid` ends up being
                # actually equal to `k` then it's a correct guess, so let's leave it within
                # the guess space.
                hi = mid
            # If `mid` did not produce enouh results, let's increase  the guess
            # space and try a higher number.
            else:
                lo = mid + 1

        # `lo` ends up being an actual distance in the input, because
        # the binary search mechanism waits until the exact lo/hi combo where
        # 2nd to last `mid` did not produce enough results (k or more), but
        # the last `mid` did.
        return lo


if __name__ == "__main__":
    nums = [1, 3, 1]
    k = 1
    print("smallestDistancePair({0}, {1}): {2}".format(
        nums, k, Solution.smallestDistancePair(Solution, nums, k)))

    nums = [1, 3, 1]
    k = 2
    print("smallestDistancePair({0}, {1}): {2}".format(
        nums, k, Solution.smallestDistancePair(Solution, nums, k)))

    nums = [10, 24, 13, 9, 98, 1]
    k = 1
    print("smallestDistancePair({0}, {1}): {2}".format(
        nums, k, Solution.smallestDistancePair(Solution, nums, k)))

    nums = [10, 24, 13, 9, 98, 1]
    k = 2
    print("smallestDistancePair({0}, {1}): {2}".format(
        nums, k, Solution.smallestDistancePair(Solution, nums, k)))

    nums = [10, 24, 13, 9, 98, 1]
    k = 3
    print("smallestDistancePair({0}, {1}): {2}".format(
        nums, k, Solution.smallestDistancePair(Solution, nums, k)))

# 01
# 19 / 19 test cases passed.
# Status: Accepted
# Runtime: 180 ms
# Memory Usage: 14.4 MB

# 02
# 19 / 19 test cases passed.
# Status: Accepted
# Runtime: 5124 ms
# Memory Usage: 14.2 MB
