"""
https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
 
Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Hint #1  
The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
"""

from typing import List


class Solution:
    #02
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        start=0
        end=len(s)-1
        while start<end:
            temp=s[start]
            s[start]=s[end]
            s[end]=temp
            start+=1
            end-=1

    #01
    def reverseString1(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        s = s[::-1]


if __name__ == "__main__":
    sol = Solution()

    s = ["h","e","l","l","o"]
    print(s)
    sol.reverseString(s)
    print(s)

    s = ["H","a","n","n","a","h"]
    print(s)
    sol.reverseString(s)
    print(s)


#01
# 477 / 477 test cases passed.
# Status: Accepted
# Runtime: 244 ms
# Memory Usage: 18.7 MB

# 02
# 477 / 477 test cases passed.
# Status: Accepted
# Runtime: 292 ms
# Memory Usage: 18.7 MB
