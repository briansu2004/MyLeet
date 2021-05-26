"""
https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/2378/
Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
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
    def printAll(prev: ListNode, cur: ListNode, next: ListNode) -> None:
        if prev == None:
            prev = ListNode("")
        if cur == None:
            cur = ListNode("")
        if next == None:
            next = ListNode("")
        print("prev: {0}, cur: {1}; next: {2}".format(prev.val, cur.val, next.val))

    # 02
    def reverseList(self, head: ListNode) -> ListNode:
        # <- prev     cur -> next
        #    prev  <- cur -> next

        # prev <- prev -> cur -> next

        prev = None
        cur = head
        while cur:  # important node if None than something broken
            next = cur.next  # get next node
            # prev     cur -> next
            # connect  cur -> prev -> .....
            cur.next = prev
            prev = cur
            cur = next
            self.printAll(prev, cur, next)
            prev.print()

        return prev

    # 01
    def reverseList1(self, head: ListNode) -> ListNode:
        if head == None:
            return None

        head.print()
        list = ListNode(head.val)  # First Node Value
        head = head.next
        while head:
            newNode = ListNode(head.val)  # Temporary Node Created
            newNode.next = list
            list = newNode
            head = head.next
            head.print()

        return list


if __name__ == "__main__":
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    head.print()

    head = Solution.reverseList(Solution, head)
    head.print()

# 01
# 28 / 28 test cases passed.
# Status: Accepted
# Runtime: 44 ms
# Memory Usage: 16.4 MB

# 02
# 28 / 28 test cases passed.
# Status: Accepted
# Runtime: 40 ms
# Memory Usage: 15.7 MB
