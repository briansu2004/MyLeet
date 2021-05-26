"""
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/
Implement Queue using Stacks

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:
You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

Example 1:
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

Constraints:
1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.

"""

#from typing import Collection
from collections import deque

#02
class MyQueue(object):
    def __init__(self):
        self._queue = deque()

    def push(self, x):
        q = self._queue
        q.append(x)
        for _ in range(len(q) - 1):
            q.append(q.popleft())
        
    def pop(self):
        return self._queue.popleft()

    def top(self):
        return self._queue[0]
    
    def empty(self):
        return not len(self._queue)

    def peek(self):
        """
        Get the front element.
        """
        return

#01
class MyQueue1(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        n = len(self.stack1) - 1
        for i in range(n):
            self.stack2.append(self.stack1.pop())
        res = self.stack1.pop()
        for i in range(n):
            self.stack1.append(self.stack2.pop())
        return res

    def peek(self) -> int:
        """
        Get the front element.
        """
        n = len(self.stack1) - 1
        for i in range(n):
            self.stack2.append(self.stack1.pop())
        res = self.stack1[0]
        for i in range(n):
            self.stack1.append(self.stack2.pop())
        return res

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.stack1) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

if __name__ == "__main__":
    myQueue = MyQueue()
    myQueue.push(1)  # queue is: [1]
    myQueue.push(2)  # queue is: [1, 2] (leftmost is front of the queue)
    print(myQueue.peek())  # return 1
    print(myQueue.pop())  # return 1, queue is [2]
    print(myQueue.empty())  # return false

# 02
# 16 / 16 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.5 MB


