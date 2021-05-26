"""
https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1053/
Replace Words

In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. 
For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. 
If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
Return the sentence after the replacement.

Example 1:
Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:
Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
Example 3:
Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
Output: "a a a a a a a a bbb baba a"
Example 4:
Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 5:
Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
Output: "it is ab that this solution is ac"

Constraints:
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 10^6
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Each two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.
"""

from typing import List


class TreeNode:
    def __init__(self, v):
        self.val = v
        self.children = {}
        self.endhere = False

class Trie:
    def __init__(self):
        self.root = TreeNode(None)

    def insert(self, word):
        trav = self.root
        for i, char in enumerate(word):
            if char not in trav.children:
                trav.children[char] = TreeNode(char)
            trav = trav.children[char]
            if i == len(word)-1:
                trav.endhere = True

    def search(self, word):
        trav = self.root
        chars = []
        for char in word:
            if char not in trav.children:
                return word
            chars.append(char)
            trav = trav.children[char]
            if trav.endhere:
                return "".join(chars)
        return word

class Solution:
    #02
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        d = set(dictionary)
        sen = sentence.split()
        for i in range(len(sen)):
            word = sen[i]
            temp = ''
            for letter in word:
                temp += letter
                if temp in d:
                    sen[i] = temp
                    break
        return ' '.join(sen)

    #01
    def replaceWords1(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        trie = Trie()
        for root in dict:
            trie.insert(root)
        words_list = sentence.split()
        for i, word in enumerate(words_list):
            words_list[i] = trie.search(word)
        return " ".join(words_list)


if __name__ == "__main__":
    sol = Solution()

    dictionary = ["cat", "bat", "rat"]
    sentence = "the cattle was rattled by the battery"
    print(f"dictionary", dictionary)
    print(f"sentence", sentence)
    print(f"replaceWords(dictionary, sentence)", sol.replaceWords(dictionary, sentence))
    print()

    dictionary = ["a","b","c"]
    sentence = "aadsfasf absbs bbab cadsfafs"
    print(f"dictionary", dictionary)
    print(f"sentence", sentence)
    print(f"replaceWords(dictionary, sentence)", sol.replaceWords(dictionary, sentence))
    print()

    dictionary = ["a", "aa", "aaa", "aaaa"]
    sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
    print(f"dictionary", dictionary)
    print(f"sentence", sentence)
    print(f"replaceWords(dictionary, sentence)", sol.replaceWords(dictionary, sentence))
    print()

    dictionary = ["catt","cat","bat","rat"]
    sentence = "the cattle was rattled by the battery"
    sentence = "the cattle was rattled by the battery"
    print(f"dictionary", dictionary)
    print(f"sentence", sentence)
    print(f"replaceWords(dictionary, sentence)", sol.replaceWords(dictionary, sentence))
    print()

    dictionary = ["ac","ab"]
    sentence = "it is abnormal that this solution is accepted"
    print(f"dictionary", dictionary)
    print(f"sentence", sentence)
    print(f"replaceWords(dictionary, sentence)", sol.replaceWords(dictionary, sentence))
    print()


# 01
# 126 / 126 test cases passed.
# Status: Accepted
# Runtime: 132 ms
# Memory Usage: 36 MB

# 02
# 126 / 126 test cases passed.
# Status: Accepted
# Runtime: 176 ms
# Memory Usage: 18.5 MB
