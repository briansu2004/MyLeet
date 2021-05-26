"""
https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/
Design Circular Queue

Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
Implementation the MyCircularQueue class:
MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language. 

Example 1:
Input
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 3, true, true, true, 4]

Explanation
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4

Constraints:
1 <= k <= 1000
0 <= value <= 1000
At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.

"""


class MyCircularQueue:
    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the queue to be k.
        :type k: int
        """
        self.queue = [-1]*k
        self.size = k
        self.num = 0
        self.head = 0

    def enQueue(self, value):
        """
        Insert an element into the circular queue. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.num < self.size:
            self.queue[(self.head+self.num) % self.size] = value
            self.num += 1
            return True
        else:
            return False

    def deQueue(self):
        """
        Delete an element from the circular queue. Return true if the operation is successful.
        :rtype: bool
        """
        if self.num == 0:
            return False
        else:
            self.queue[self.head] = -1
            self.head = (self.head+1) % self.size
            self.num -= 1
            return True

    def Front(self):
        """
        Get the front item from the queue.
        :rtype: int
        """
        if self.num == 0:
            return -1
        else:
            return self.queue[self.head]

    def Rear(self):
        """
        Get the last item from the queue.
        :rtype: int
        """
        if self.num == 0:
            return -1
        else:
            return self.queue[(self.head+self.num-1) % self.size]

    def isEmpty(self):
        """
        Checks whether the circular queue is empty or not.
        :rtype: bool
        """
        return self.num == 0

    def isFull(self):
        """
        Checks whether the circular queue is full or not.
        :rtype: bool
        """
        return self.num == self.size


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()

if __name__ == "__main__":
    myCircularQueue = MyCircularQueue(3)
    print(myCircularQueue.enQueue(1))  # return True
    print(myCircularQueue.enQueue(2))  # return True
    print(myCircularQueue.enQueue(3))  # return True
    print(myCircularQueue.enQueue(4))  # return False
    print(myCircularQueue.Rear())  # return 3
    print(myCircularQueue.isFull())  # return True
    print(myCircularQueue.deQueue())  # return True
    print(myCircularQueue.enQueue(4))  # return True
    print(myCircularQueue.Rear())  # return 4



# 01
# 57 / 57 test cases passed.
# Status: Accepted
# Runtime: 68 ms
# Memory Usage: 14.9 MB
