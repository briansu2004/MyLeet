"""
https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1056/
Word Search II

Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.

Hint #1  
You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
Hint #2  
If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
"""

from typing import List


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie, ans, m, n = {}, set(), len(board), len(board) and len(board[0])
        for word in words:
            node = trie
            for c in word: node = node.setdefault(c, {})
            node['$'] = None
        def dfs(i, j, node, word):
            if board[i][j] in node:
                board[i][j], c = '', board[i][j]
                node, word = node[c], word + c
                if '$' in node: ans.add(word)
                for x, y in ((i-1,j),(i+1,j),(i,j-1),(i,j+1)):
                    if 0 <= x < m and 0 <= y < n: 
                        dfs(x, y, node, word)
                board[i][j] = c
        for i in range(m):
            for j in range(n):
                dfs(i, j, trie, '')
        return list(ans)
        

if __name__ == "__main__":
    sol = Solution()

    board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
    words = ["oath","pea","eat","rain"]
    print(f"board:", board)
    print(f"words:", words)
    print(f"sol.findWords(nums):", sol.findWords(board, words))
    print()

    board = [["a","b"],["c","d"]]
    words = ["abcb"]
    print(f"board:", board)
    print(f"words:", words)
    print(f"sol.findWords(nums):", sol.findWords(board, words))
    print()
    

# 01
# 40 / 40 test cases passed.
# Status: Accepted
# Runtime: 6976 ms
# Memory Usage: 14.7 MB
