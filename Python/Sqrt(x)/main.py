"""
https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
Sqrt(x)

Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Example 1:
Input: x = 4
Output: 2
Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

Constraints:
0 <= x <= 231 - 1
   Hide Hint #1  
Try exploring all integers. (Credits: @annujoshi)
   Hide Hint #2  
Use the sorted property of integers to reduced the search space. (Credits: @annujoshi)
"""

class Solution:
    def mySqrt(self, x):
        left, right = 0, x
        
        while left <= right:
            mid = left + (right - left) // 2
            square = mid ** 2
            
            if square <= x:
                left = mid + 1
            
            elif square > x :
                right = mid -1

        return left - 1
        

if __name__ == "__main__":
    x = 9
    print("mySqrt({0}): {1}".format(x, Solution.mySqrt(Solution, x)))
    
    x = 0
    print("mySqrt({0}): {1}".format(x, Solution.mySqrt(Solution, x)))

    x = 6
    print("mySqrt({0}): {1}".format(x, Solution.mySqrt(Solution, x)))

# 01
# 1017 / 1017 test cases passed.
# Status: Accepted
# Runtime: 44 ms
# Memory Usage: 14 MB
