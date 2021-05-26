"""
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

Constraints:
1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
"""

class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = []
        for t in tokens:
            if t.strip("-").isnumeric():
                stack.append(t)
            else:
                a = int(stack.pop())
                b = int(stack.pop())
                if t == "+":
                    stack.append(b+a)
                elif t == "-":
                    stack.append(b-a)
                elif t == "*":
                    stack.append(b*a)
                else:
                    stack.append(int(float(b)/float(a)))
        return int(stack.pop())

if __name__ == "__main__":
    sol = Solution()

    tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    print("evalRPN({0}): {1}".format(tokens, sol.evalRPN(tokens)))

    tokens = ["4","13","5","/","+"]
    print("evalRPN({0}): {1}".format(tokens, sol.evalRPN(tokens)))
    
    tokens = ["2","1","+","3","*"]
    print("evalRPN({0}): {1}".format(tokens, sol.evalRPN(tokens)))
    
    tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    print("evalRPN({0}): {1}".format(tokens, sol.evalRPN(tokens)))




# 01
