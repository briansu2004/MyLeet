"""
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2905/
Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:
Input: digits = ""
Output: []
Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
"""

from typing import List


class Solution(object):
    #02
    keypad = ['abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
    def letterCombinations(self, digits: str) -> List[str]:

        if not digits:
            return []
        
        result = ['']
        
        for index in digits:
            temp = []
            for x in Solution.keypad[int(index)-2]:
                for y in result:
                    temp.append(y+x)
            result = temp[:]
            
        return result    
                

    #01
    def letterCombinations1(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        d = {"1":"1", "2":"abc", "3":"def", "4":"ghi", "5":"jkl", "6":"mno", "7":"pqrs", "8":"tuv", "9":"wxyz"}
        if not digits:
            return []
        
        res = []
        def dfs(res, index, path):
            if len(path)==len(digits):
                res.append(path)
                return
            else:
                for c in d[digits[index]]:
                    dfs(res, index+1, path + c)

        dfs(res, 0, "")
        return res

if __name__ == "__main__":
    h = ""
    print("letterCombinations({0}): {1}".format(h, Solution.letterCombinations(Solution, h)))

    # h = "1"
    # print("letterCombinations({0}): {1}".format(h, Solution.letterCombinations(Solution, h)))

    h = "2"
    print("letterCombinations({0}): {1}".format(h, Solution.letterCombinations(Solution, h)))

    h = "34"
    print("letterCombinations({0}): {1}".format(h, Solution.letterCombinations(Solution, h)))


# 01
# 25 / 25 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.2 MB

# 02
# 25 / 25 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.2 MB
