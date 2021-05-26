"""
https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1680/
Recursion Function

For a problem, if there exists a recursive solution, we can follow the guidelines below to implement it. 
For instance, we define the problem as the function {F(X)}F(X) to implement, where {X}X is the input of the function which also defines the scope of the problem.
Then, in the function {F(X)}F(X), we will:
 
Example
To showcase the above guidelines, we give another example on how to solve a problem recursively. 

Given a linked list, swap every two adjacent nodes and return its head.
e.g.  for a list 1-> 2 -> 3 -> 4, one should return the head of list as 2 -> 1 -> 4 -> 3.

We define the function to implement as swap(head), where the input parameter head refers to the head of a linked list. The function should return the head of the new linked list that has any adjacent nodes swapped.

Following the guidelines we lay out above, we can implement the function as follows:

First, we swap the first two nodes in the list, i.e. head and head.next;
Then, we call the function self as swap(head.next.next) to swap the rest of the list following the first two nodes.
Finally, we attach the returned head of the sub-list in step (2) with the two nodes swapped in step (1) to form a new linked list.
As an exercise, you can try to implement the solution using the steps we provided above. Click on "Swap Nodes in Pairs" to try to implement the solution yourself. 


https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
"""

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def print(self):
        while self:
            print(self.val)
            self = self.next
        print()


class Solution:
    # def swapPairs(self, head: ListNode) -> ListNode:
    #     t = head.next
    #     head.next = head
    #     head = t

    #     head.next.next = swapPairs(self, head.next.next)

    # 02
    def swapPairs1(self, head: ListNode) -> ListNode:
        dummy = head
        while head and head.next:
            head.val, head.next.val = head.next.val, head.val
            head = head.next.next
        return dummy

    # 01
    def swapPairs1(self, head: ListNode) -> ListNode:
        # if list is not empty
        if head:
            # if there's only one element
            if not head.next:
                return head

            next_node = head.next

            # Swapping!!
            temp = head.val
            head.val = head.next.val
            head.next.val = temp

            if next_node.next:
                self.swapPairs(self, next_node.next)

            return head


if __name__ == "__main__":
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    head.print()

    Solution.swapPairs(Solution, head)
    head.print()

# 01
# 55 / 55 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.3 MB

# 02
# 55 / 55 test cases passed.
# Status: Accepted
# Runtime: 28 ms
# Memory Usage: 14.4 MB
