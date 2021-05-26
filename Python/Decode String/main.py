"""
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
Decode String

Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:
Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"

Constraints:
1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
"""

import re

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        while '[' in s:
            s = re.sub(r'(\d+)\[([a-z]*)\]', lambda m: int(m.group(1)) * m.group(2), s)
        return s

if __name__ == "__main__":
    sol = Solution()

    s = "3[a]2[bc]"
    print("decodeString({0}): {1}".format(s, sol.decodeString(s)))

    s = "3[a2[c]]"
    print("decodeString({0}): {1}".format(s, sol.decodeString(s)))

    s = "2[abc]3[cd]ef"
    print("decodeString({0}): {1}".format(s, sol.decodeString(s)))

    s = "abc3[cd]xyz"
    print("decodeString({0}): {1}".format(s, sol.decodeString(s)))




# 01
# 34 / 34 test cases passed.
# Status: Accepted
# Runtime: 20 ms
# Memory Usage: 13.3 MB
