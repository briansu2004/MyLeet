"""
https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
Add Binary

Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

"""

class Solution:
    def addBinary(self, a, b):
        return str(bin(int(a, 2) + int (b, 2)))[2:]

if __name__ == "__main__":
    sol = Solution()

    a = "11"
    b = "1"
    print(f"a:", a)
    print(f"b:", b)
    print(f"addBinary(a, b):", sol.addBinary(a, b))

    a = "1010"
    b = "1011"
    print(f"a:", a)
    print(f"b:", b)
    print(f"addBinary(a, b):", sol.addBinary(a, b))

# 01
# 294 / 294 test cases passed.
# Status: Accepted
# Runtime: 40 ms
# Memory Usage: 14.4 MB
