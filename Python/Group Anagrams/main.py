"""
https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1124/
Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.

"""


class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        def convert(s):
            res = [0]*26
            for char in s:
                res[ord(char)-ord('a')] += 1
            return tuple(res)
        rec = {}
        res = []
        for s in strs:
            t = convert(s)
            if t in rec:
                res[rec[t]].append(s)
            else:
                res.append([s])
                rec[t] = len(res)-1
        return res


if __name__ == "__main__":
    sol = Solution()

    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    print(f"strs:", strs)
    print(f"groupAnagrams(strs):", sol.groupAnagrams(strs))

    strs = [""]
    print(f"strs:", strs)
    print(f"groupAnagrams(strs):", sol.groupAnagrams(strs))

    strs = ["a"]
    print(f"strs:", strs)
    print(f"groupAnagrams(strs):", sol.groupAnagrams(strs))


# 01
