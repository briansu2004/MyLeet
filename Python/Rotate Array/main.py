"""
https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/
Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 
Follow up:
Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

Hint #1  
The easiest solution would use additional memory and that is perfectly fine.
Hint #2  
The actual trick comes when trying to solve this problem without using any additional memory. This means you need to use the original array somehow to move the elements around. Now, we can place each element in its original location and shift all the elements around it to adjust as that would be too costly and most likely will time out on larger input arrays.
Hint #3  
One line of thought is based on reversing the array (or parts of it) to obtain the desired result. Think about how reversal might potentially help us out by using an example.
Hint #4  
The other line of thought is a tad bit complicated but essentially it builds on the idea of placing each element in its original position while keeping track of the element originally in that position. Basically, at every step, we place an element in its rightful position and keep track of the element already there or the one being overwritten in an additional variable. We can't do this in one linear pass and the idea here is based on cyclic-dependencies between elements.

"""

class Solution(object):
    #02
    def rotate(self, nums, k):
        k %= len(nums)
        nums[:] = nums[-k:] + nums[:-k]

    #01
    def rotate1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        nums[:] = nums[-k%len(nums):] + nums[:-k%len(nums)]
        

if __name__ == "__main__":
    sol = Solution()

    nums = [-1,-100,3,99]
    k = 2
    print(nums)
    sol.rotate(nums, k)
    print(nums)

    nums = [1,2,3,4,5,6,7]
    k = 3
    print(nums)
    sol.rotate(nums, k)
    print(nums)


# 01
# 37 / 37 test cases passed.
# Status: Accepted
# Runtime: 260 ms
# Memory Usage: 24.9 MB

# 02
# 37 / 37 test cases passed.
# Status: Accepted
# Runtime: 268 ms
# Memory Usage: 24.9 MB
