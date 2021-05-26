"""
https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1173/
Remove Duplicates from Sorted Array

Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
Clarification:
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.

Constraints:
0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in ascending order.

Hint #1  
In this problem, the key point to focus on is the input array being sorted. As far as duplicate elements are concerned, what is their positioning in the array when the given array is sorted? Look at the image above for the answer. If we know the position of one of the elements, do we also know the positioning of all the duplicate elements?

Hint #2  
We need to modify the array in-place and the size of the final array would potentially be smaller than the size of the input array. So, we ought to use a two-pointer approach here. One, that would keep track of the current element in the original array and another one for just the unique elements.

Hint #3  
Essentially, once an element is encountered, you simply need to bypass its duplicates and move on to the next unique element.
"""


from typing import List


class Solution:
    # 02
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums):
            try:
                while nums[i] == nums[i + 1]:
                    del nums[i]
            except IndexError:
                break
            i += 1
        return i + 1

    # 01
    def removeDuplicates1(self, nums: List[int]) -> int:
        x = 1
        for i in range(len(nums)-1):
            if(nums[i] != nums[i+1]):
                nums[x] = nums[i+1]
                x += 1
        return(x)


if __name__ == "__main__":
    sol = Solution()

    nums = [1, 1, 2]
    print(nums)
    print("removeDuplicates({0}): {1}".format(
        nums, sol.removeDuplicates(nums)))
    print(nums)

    nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    print(nums)
    print("removeDuplicates({0}): {1}".format(
        nums, sol.removeDuplicates(nums)))
    print(nums)


# 01
# 162 / 162 test cases passed.
# Status: Accepted
# Runtime: 80 ms
# Memory Usage: 15.9 MB

# 02
# 162 / 162 test cases passed.
# Status: Accepted
# Runtime: 100 ms
# Memory Usage: 16 MB
