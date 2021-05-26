"""
https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
Implement strStr()

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:
Input: haystack = "", needle = ""
Output: 0

Constraints:
0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
"""


class RabinKarp:
    def __init__(self, pat):
        self.pat = pat
        self.M = len(pat)
        self.Q = 10 ** 50001
        self.RM = 1
        self.R = 256
        for i in range(1, self.M):
            self.RM = (self.RM * self.R) % self.Q
        self.pat_hash = self.hash(self.pat, self.M)

    def hash(self, key, M):
        h = 0
        for i in range(M):
            h = (h * self.R + ord(key[i])) % self.Q
        return h

    def search(self, s):
        N = len(s)
        txt_hash = self.hash(s, self.M)
        if txt_hash == self.pat_hash:
            return 0
        for i in range(self.M, N):
            txt_hash = (txt_hash + self.Q -
                        ord(s[i-self.M]) * self.RM % self.Q) % self.Q
            txt_hash = (txt_hash * self.R + ord(s[i])) % self.Q
            if txt_hash == self.pat_hash:
                return i - self.M + 1
        return -1


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0
        if haystack == "" or len(needle) > len(haystack):
            return -1
        rk = RabinKarp(needle)
        return rk.search(haystack)


class Solution1:
    # 01
    def strStr1(self, haystack: str, needle: str) -> int:
        nl, ml = len(needle), len(haystack)
        if nl == 0:
            return nl
        if ml < nl:
            return -1
        for i in range(ml - nl + 1):
            if haystack[i:i+nl] == needle:
                return i
        return -1


if __name__ == "__main__":
    sol = Solution()

    a = "hello"
    b = "ll"
    print(f"a:", a)
    print(f"b:", b)
    print(f"strStr(a, b):", sol.strStr(a, b))

    a = "aaaaa"
    b = "bba"
    print(f"a:", a)
    print(f"b:", b)
    print(f"strStr(a, b):", sol.strStr(a, b))

    a = ""
    b = ""
    print(f"a:", a)
    print(f"b:", b)
    print(f"strStr(a, b):", sol.strStr(a, b))

# 01
# 79 / 79 test cases passed.
# Status: Accepted
# Runtime: 40 ms
# Memory Usage: 14.5 MB

# 02
# 79 / 79 test cases passed.
# Status: Accepted
# Runtime: 1320 ms
# Memory Usage: 14.8 MB
