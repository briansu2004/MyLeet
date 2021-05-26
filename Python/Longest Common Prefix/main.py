"""
https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

"""

from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
            
        for i, letter_group in enumerate(zip(*strs)):
            if len(set(letter_group)) > 1:
                return strs[0][:i]
        else:
            return min(strs)

if __name__ == "__main__":
    sol = Solution()

    strs = ["flower","flow","flight"]
    print("longestCommonPrefix({0}): {1}".format(strs, sol.longestCommonPrefix(strs)))

    strs = ["dog","racecar","car"]
    print("longestCommonPrefix({0}): {1}".format(strs, sol.longestCommonPrefix(strs)))

#01
# 123 / 123 test cases passed.
# Status: Accepted
# Runtime: 36 ms
# Memory Usage: 14.5 MB
