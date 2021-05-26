"""
https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1052/
Add and Search Word - Data structure design

Solution
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary()
wordDictionary.addWord("bad")
wordDictionary.addWord("dad")
wordDictionary.addWord("mad")
wordDictionary.search("pad") # return False
wordDictionary.search("bad") # return True
wordDictionary.search(".ad") # return True
wordDictionary.search("b..") # return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.

Hine #1:
You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
"""


import collections
from collections import defaultdict

class WordDictionary(object):
    def __init__(self):
        self.word_dict = collections.defaultdict(list)

    def addWord(self, word):
        if word:
            self.word_dict[len(word)].append(word)

    def search(self, word):
        if not word:
            return False
        if '.' not in word:
            return word in self.word_dict[len(word)]
        for v in self.word_dict[len(word)]:
            # match xx.xx.x with yyyyyyy
            for i, ch in enumerate(word):
                if ch != v[i] and ch != '.':
                    break
            else:
                return True
        return False


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)


if __name__ == "__main__":
    wordDictionary = WordDictionary()

    wordDictionary.addWord("bad")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")
    print(wordDictionary.search("pad"))  # return False
    print(wordDictionary.search("bad"))  # return True
    print(wordDictionary.search(".ad"))  # return True
    print(wordDictionary.search("b.."))  # return True


# 01
# 13 / 13 test cases passed.
# Status: Accepted
# Runtime: 120 ms
# Memory Usage: 21.8 MB
