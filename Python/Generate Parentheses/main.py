"""
https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2772/
Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:
Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8
"""

from typing import List


class Solution:
    #03
    def generateParenthesis(self, n):
        def generate(p, left, right, parens=[]):
            if left:         generate(p + '(', left-1, right)
            if right > left: generate(p + ')', left, right-1)
            if not right:    parens += p,
            return parens
        return generate('', n, n)

    #02
    def generateParenthesis2(self, n):
        def generate(p, left, right):
            if right >= left >= 0:
                if not right:
                    yield p
                for q in generate(p + '(', left-1, right): yield q
                for q in generate(p + ')', left, right-1): yield q
        return list(generate('', n, n))

    #01
    def generateParenthesis1(self, n: int, open=0) -> List[str]:
        if n > 0 <= open:
            return ['(' + p for p in self.generateParenthesis(self, n-1, open+1)] + \
                [')' + p for p in self.generateParenthesis(self, n, open-1)]
        return [')' * open] * (not n)


if __name__ == "__main__":
    for n in range(6):
        print("generateParenthesis({0}): {1}".format(n, Solution.generateParenthesis(Solution, n)))



# 01
# 8 / 8 test cases passed.
# Status: Accepted
# Runtime: 36 ms
# Memory Usage: 14.5 MB

#02
# 8 / 8 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.5 MB

#03
# 8 / 8 test cases passed.
# Status: Accepted
# Runtime: 36 ms
# Memory Usage: 14.7 MB
