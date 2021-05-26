"""
https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1138/
Palindrome Pairs

Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

Example 1:
Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:
Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
Example 3:
Input: words = ["a",""]
Output: [[0,1],[1,0]]

Constraints:
1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] consists of lower-case English letters.
"""

from typing import List


class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        wordict = {}
        res = [] 
        for i in range(len(words)):
            wordict[words[i]] = i
        for i in range(len(words)):
            for j in range(len(words[i])+1):
                tmp1 = words[i][:j]
                tmp2 = words[i][j:]
                if tmp1[::-1] in wordict and wordict[tmp1[::-1]]!=i and tmp2 == tmp2[::-1]:
                    res.append([i,wordict[tmp1[::-1]]])
                if j!=0 and tmp2[::-1] in wordict and wordict[tmp2[::-1]]!=i and tmp1 == tmp1[::-1]:
                    res.append([wordict[tmp2[::-1]],i])
                    
        return res
        

if __name__ == "__main__":
    sol = Solution()

    words = ["abcd","dcba","lls","s","sssll"]
    print(f"words:", words)
    print(f"sol.palindromePairs(words):", sol.palindromePairs(words))
    print()

    words = ["bat","tab","cat"]
    print(f"words:", words)
    print(f"sol.palindromePairs(words):", sol.palindromePairs(words))
    print()

    words = ["a",""]
    print(f"words:", words)
    print(f"sol.palindromePairs(words):", sol.palindromePairs(words))
    print()


# 01
# 134 / 134 test cases passed.
# Status: Accepted
# Runtime: 540 ms
# Memory Usage: 15.5 MB
