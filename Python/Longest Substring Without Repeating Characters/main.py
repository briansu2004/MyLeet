"""
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:
Input: s = ""
Output: 0

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
"""

class Solution:
    #02
    def lengthOfLongestSubstring(self, s: str) -> int:
        index = {}
        result = 0
        start = 0
        for i in range (len(s)):
            if s[i] in index:
                start = max(start, index[s[i]]+ 1)
            result = max(result, i - start + 1)
            index[s[i]] = i
            
        return result
    
    #01
    def lengthOfLongestSubstring1(self, s: str) -> int:
        dic, res, start, = {}, 0, 0
        for i, ch in enumerate(s):
            if ch in dic:
                res = max(res, i-start) # update the res
                start = max(start, dic[ch]+1)  # here should be careful, like "abba"
            dic[ch] = i
        return max(res, len(s)-start)  # return should consider the last non-repeated substring

if __name__ == "__main__":
    sol = Solution()

    s = "abcabcbb"
    print(f"s:", s)
    print(f"lengthOfLongestSubstring(s):", sol.lengthOfLongestSubstring(s))

    s = "bbbbb"
    print(f"s:", s)
    print(f"lengthOfLongestSubstring(s):", sol.lengthOfLongestSubstring(s))

    s = "pwwkew"
    print(f"s:", s)
    print(f"lengthOfLongestSubstring(s):", sol.lengthOfLongestSubstring(s))

    s = ""
    print(f"s:", s)
    print(f"lengthOfLongestSubstring(s):", sol.lengthOfLongestSubstring(s))


# 01
# 987 / 987 test cases passed.
# Status: Accepted
# Runtime: 56 ms
# Memory Usage: 14 MB

# 02
# 987 / 987 test cases passed.
# Status: Accepted
# Runtime: 64 ms
# Memory Usage: 14.5 MB
