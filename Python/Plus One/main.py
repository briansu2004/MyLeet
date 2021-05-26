"""
https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
Plus One

Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:
Input: digits = [0]
Output: [1]
 
Constraints:
1 <= digits.length <= 100
0 <= digits[i] <= 9
"""


from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        for i in range(len(digits)-1, -1, -1):
            carry, digits[i] = divmod(digits[i]+carry, 10)
            if carry == 0:
                return digits
        return [1]+digits


if __name__ == "__main__":
    sol = Solution()

    nums = [1, 2, 3]
    print(f"nums:", nums)
    print(f"plusOne(nums):", sol.plusOne(nums))

    nums = [4, 3, 2, 1]
    print(f"nums:", nums)
    print(f"plusOne(nums):", sol.plusOne(nums))

    nums = [0]
    print(f"nums:", nums)
    print(f"plusOne(nums):", sol.plusOne(nums))


# 01
# 111 / 111 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.2 MB
