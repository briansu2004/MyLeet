"""
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
Example 4:
Input: s = "([)]"
Output: false
Example 5:
Input: s = "{[]}"
Output: true

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

Hint #1
An interesting property about a valid parenthesis expression is that a sub-expression of a valid expression should also be a valid expression. (Not every sub-expression) e.g.
{ { } [ ] [ [ [ ] ] ] } is VALID expression
          [ [ [ ] ] ]    is VALID sub-expression
  { } [ ]                is VALID sub-expression
Can we exploit this recursive structure somehow?
Hint #2
What if whenever we encounter a matching pair of parenthesis in the expression, we simply remove it from the expression? This would keep on shortening the expression. e.g.
{ { ( { } ) } }
      |_|

{ { (      ) } }
    |______|

{ {          } }
  |__________|

{                }
|________________|

VALID EXPRESSION!
Hint #3
The stack data structure can come in handy here in representing this recursive structure of the problem. We can't really process this from the inside out because we don't have an idea about the overall structure. But, the stack can help us process this recursively i.e. from outside to inwards.

"""

# 02
class Solution:
     # @param {string} s
     # @return {boolean}
    def isValid(self, s):
        stack = []
        for i in s:
            if i in ['(', '[', '{']:
                stack.append(i)
            else:
                if not stack or {')': '(', ']': '[', '}': '{'}[i] != stack[-1]:
                    return False
                stack.pop()
        return not stack

# 01


class Solution1(object):
    def isValid1(self, s):
        """
        :type s: str
        :rtype: bool
        """
        d = {'{': '}', '(': ')', '[': ']'}
        stack = []
        for c in s:
            if c in d:
                stack.append(c)
            elif not stack or c != d[stack.pop()]:
                return False
        return not stack


if __name__ == "__main__":
    sol = Solution()

    s = "()"
    print("sol.isValid({0}): {1}".format(s, sol.isValid(s)))

    s = "()[]{}"
    print("sol.isValid({0}): {1}".format(s, sol.isValid(s)))

    s = "(]"
    print("sol.isValid({0}): {1}".format(s, sol.isValid(s)))

    s = "([)]"
    print("sol.isValid({0}): {1}".format(s, sol.isValid(s)))

    s = "{[]}"
    print("sol.isValid({0}): {1}".format(s, sol.isValid(s)))

# 01
# 91 / 91 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.5 MB

# 02
# 91 / 91 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 13.5 MB
