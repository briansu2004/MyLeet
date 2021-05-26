"""
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 
Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:
-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

Hint #1  
Consider each node in the stack having a minimum value. (Credits to @aakarshmadhavan)
"""

#02
class MinStack:
    def __init__(self):
        self.q = []

    # @param x, an integer
    # @return an integer
    def push(self, x):
        curMin = self.getMin()
        if curMin == None or x < curMin:
            curMin = x
        self.q.append((x, curMin))

    # @return nothing
    def pop(self):
        self.q.pop()

    # @return an integer
    def top(self):
        if len(self.q) == 0:
            return None
        else:
            return self.q[len(self.q) - 1][0]

    # @return an integer
    def getMin(self):
        if len(self.q) == 0:
            return None
        else:
            return self.q[len(self.q) - 1][1]


#01
class MinStack1(object):
    def __init__(self):
        self.stack = [(-1, float('inf'))]

    def push(self, x):
        self.stack.append([x, min(x, self.stack[-1][1])])

    def pop(self):
        if len(self.stack) > 1:
            self.stack.pop()

    def top(self):
        if len(self.stack) == 1:
            return None
        return self.stack[-1][0]

    def getMin(self):
        return self.stack[-1][1]


if __name__ == "__main__":
    minStack = MinStack()
    minStack.push(10)
    minStack.push(-2)
    minStack.push(20)
    minStack.push(0)
    minStack.push(-3)
    minStack.push(6)
    print(minStack.q)
    print(minStack.getMin())  # return -3
    minStack.pop()
    minStack.pop()
    print(minStack.top())    # return 0
    print(minStack.q)
    print(minStack.getMin())  # return -2


# 02
# 31 / 31 test cases passed.
# Status: Accepted
# Runtime: 56 ms
# Memory Usage: 17.4 MB

