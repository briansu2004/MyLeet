"""
https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1151/
Remove Element

Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Clarification:
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
Internally you can think of this:
// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);
// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3]
Explanation: Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary. It doesn't matter what values are set beyond the returned length.

Constraints:
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100

Hint #1  
The problem statement clearly asks us to modify the array in-place and it also says that the element beyond the new length of the array can be anything. Given an element, we need to remove all the occurrences of it from the array. We don't technically need to remove that element per-say, right?
Hint #2  
We can move all the occurrences of this element to the end of the array. Use two pointers!
Hint #3  
Yet another direction of thought is to consider the elements to be removed as non-existent. In a single pass, if we keep copying the visible elements in-place, that should also solve this problem for us.

"""

class Solution(object):
    #02
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        
        index = 0
        for x in range(len(nums)):
            if nums[x] != val:
                nums[index] = nums[x]
                index += 1
        
        return index

    #01
    def removeElement1(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        while val in nums: nums.remove(val)


if __name__ == "__main__":
    sol = Solution()

    nums = [3,2,2,3]
    val = 3
    print(nums)
    print("sol.removeElement({0}, {1}): {2}".format(nums, val, sol.removeElement(nums, val)))
    print(nums)



#01
# 113 / 113 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 13.4 MB

# 02
# 113 / 113 test cases passed.
# Status: Accepted
# Runtime: 36 ms
# Memory Usage: 13.3 MB
