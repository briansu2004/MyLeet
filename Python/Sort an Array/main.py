"""
https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/
Sort an Array

Given an array of integers nums, sort the array in ascending order.

Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]

Constraints:
1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
"""

class Solution(object):
    #02
    def sortArray2(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums.sort()
        return nums

    #01
    def sortArray1(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # bottom cases: empty or list of a single element.
        if len(nums) <= 1:
            return nums

        pivot = int(len(nums) / 2)
        left_list = self.sortArray(self, nums[0:pivot])
        right_list = self.sortArray(self, nums[pivot:])
        return self.merge(self, left_list, right_list)


    def merge(self, left_list, right_list):
        left_cursor = right_cursor = 0
        ret = []
        while left_cursor < len(left_list) and right_cursor < len(right_list):
            if left_list[left_cursor] < right_list[right_cursor]:
                ret.append(left_list[left_cursor])
                left_cursor += 1
            else:
                ret.append(right_list[right_cursor])
                right_cursor += 1

        # append what is remained in either of the lists
        ret.extend(left_list[left_cursor:])
        ret.extend(right_list[right_cursor:])

        return ret


if __name__ == "__main__":
    nums = [11, 0, -1, 2, -7, 9]
    print("sortArray({0}) is: {1}".format(nums, Solution.sortArray(Solution, nums)))


# 01
# 13 / 13 test cases passed.
# Status: Accepted
# Runtime: 780 ms
# Memory Usage: 21.8 MB

# 02
# 13 / 13 test cases passed.
# Status: Accepted
# Runtime: 244 ms
# Memory Usage: 21.2 MB
