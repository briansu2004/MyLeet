"""
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/
Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true

Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
"""


class Solution(object):
    # 02
    def isIsomorphic(self, s, t):
        # c --> last idx
        d1, d2 = [-1 for _ in range(256)], [-1 for _ in range(256)]
        for i in range(len(s)):
            if d1[ord(s[i])] != d2[ord(t[i])]:
                return False
            d1[ord(s[i])] = d2[ord(t[i])] = i
        return True

    # 01
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        n = len(s)
        m = len(t)
        if n != m:
            return False
        dic = {}
        for i in range(n):
            if s[i] in dic:
                if dic[s[i]] != t[i]:
                    return False
            elif t[i] in dic.values():
                return False
            else:
                dic[s[i]] = t[i]
        return True


if __name__ == "__main__":
    sol = Solution()

    s = "egg"
    t = "add"
    print(f"s:", s)
    print(f"t:", t)
    print(f"isIsomorphic(s, t):", sol.isIsomorphic(s, t))

    s = "foo"
    t = "bar"
    print(f"s:", s)
    print(f"t:", t)
    print(f"isIsomorphic(s, t):", sol.isIsomorphic(s, t))

    s = "paper"
    t = "title"
    print(f"s:", s)
    print(f"t:", t)
    print(f"isIsomorphic(s, t):", sol.isIsomorphic(s, t))


# 02
# 39 / 39 test cases passed.
# Status: Accepted
# Runtime: 56 ms
# Memory Usage: 14.9 MB

# 01
# 39 / 39 test cases passed.
# Status: Accepted
# Runtime: 44 ms
# Memory Usage: 14.8 MB
