"""
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/
First Unique Character in a String

Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Example 2:
Input: s = "loveleetcode"
Output: 2
Example 3:
Input: s = "aabb"
Output: -1

Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.
"""

import collections

class Solution(object):
    def firstUniqChar(self, s):
        if not s: return -1

        d = collections.defaultdict(int)
                
        for char in s:
            d[char] += 1
                    
        for i, c in enumerate(s):
            if d[c] < 2:
                    return i
        return -1

class Solution1(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = {}
        seen = set()
        for idx, c in enumerate(s):
            if c not in seen:
                d[c] = idx
                seen.add(c)
            elif c in d:
                del d[c]
        return min(d.values()) if d else -1

if __name__ == "__main__":
    sol = Solution()

    s = "leetcode"
    print(f"s:", s)
    print(f"firstUniqChar(s):", sol.firstUniqChar(s))

    s = "loveleetcode"
    print(f"s:", s)
    print(f"firstUniqChar(s):", sol.firstUniqChar(s))

    s = "aabb"
    print(f"s:", s)
    print(f"firstUniqChar(s):", sol.firstUniqChar(s))



# 01
# 104 / 104 test cases passed.
# Status: Accepted
# Runtime: 88 ms
# Memory Usage: 13.7 MB
