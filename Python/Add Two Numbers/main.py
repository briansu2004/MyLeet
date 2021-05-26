"""
https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/
Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
"""

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        # print(self.val)

    def print(self):
        if self:
            print("+ ", self.val)
            prefix = "  "
            while self.next:
                prefix += " "
                print(prefix, self.next.val)
                self = self.next


class Solution:
    # 04
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        res = 0
        carry = 0
        sentinel = ans = ListNode(0)

        while l1 or l2:
            if l1:
                res += l1.val

            if l2:
                res += l2.val
            res += carry
            carry = res//10
            ans.next = ListNode(res % 10)
            ans = ans.next

            res = 0
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        if carry != 0:
            ans.next = ListNode(carry)
        return sentinel.next

    # 03
    def addTwoNumbers3(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        res = 0
        trav1 = l1
        trav2 = l2
        head = ListNode(0)
        trav = head
        while trav1 and trav2:
            tmp = trav1.val + trav2.val + carry
            carry, r = divmod(tmp, 10)
            node = ListNode(r)
            trav.next = node
            trav = trav.next
            trav1 = trav1.next
            trav2 = trav2.next
        if trav1:
            trav3 = trav1
        elif trav2:
            trav3 = trav2
        else:
            if carry:
                node = ListNode(carry)
                trav.next = node
            return head.next
        while trav3:
            tmp = trav3.val + carry
            carry, r = divmod(tmp, 10)
            node = ListNode(r)
            trav.next = node
            trav = trav.next
            trav3 = trav3.next
        if carry:
            node = ListNode(carry)
            trav.next = node
        return head.next

    # def addTwoNumbers(self, l1, l2):
    #     addends = l1, l2
    #     dummy = end = ListNode(0)
    #     carry = 0
    #     while addends or carry:
    #         carry += sum(a.val for a in addends)
    #         addends = [a.next for a in addends if a.next]
    #         end.next = end = ListNode(carry % 10)
    #         carry /= 10
    #     return dummy.next

    # def addTwoNumbersBad2(self, l1, l2):
    #     def toint(node):
    #         return node.val + 10 * toint(node.next) if node else 0
    #     def tolist(n):
    #         node = ListNode(n % 10)
    #         if n > 9:
    #             node.next = tolist(n / 10)
    #         return node
    #     return tolist(toint(l1) + toint(l2))

    # # this one has issues!
    # def addTwoNumbersBad1(self, l1, l2):
    #     def toint(node):
    #         return node.val + 10 * toint(node.next) if node else 0
    #     n = toint(l1) + toint(l2)
    #     first = last = ListNode(n % 10)
    #     while n > 9:
    #         n = int((n - n % 10) / 10)
    #         last.next = last = ListNode(n % 10)
    #     return first

    # def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
    #     addends = l1, l2
    #     dummy = end = ListNode(0)
    #     carry = 0
    #     while addends or carry:
    #         carry += sum(a.val for a in addends)
    #         addends = [a.next for a in addends if a.next]
    #         end.next = end = ListNode(carry % 10)
    #         carry /= 10
    #     return dummy.next

    # 02

    def addTwoNumbers2(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 or not l2:
            return l1 or l2
        head, carry = l1, 0
        carry, l1.val = divmod(l1.val + l2.val + carry, 10)
        while l1.next and l2.next:
            l1, l2 = l1.next, l2.next
            carry, l1.val = divmod(l1.val + l2.val + carry, 10)
        l1.next = self.addTwoNumbers(l1.next or l2.next,
                                     ListNode(carry) if carry else None)
        return head

    # 01
    def addTwoNumbers1(self, l1, l2):
        dummy = cur = ListNode(0)
        carry = 0
        while l1 or l2 or carry:
            if l1:
                carry += l1.val
                l1 = l1.next
            if l2:
                carry += l2.val
                l2 = l2.next
            cur.next = ListNode(carry % 10)
            cur = cur.next
            carry //= 10
        return dummy.next


if __name__ == "__main__":
    sol = Solution()

    # l1 = ListNode(2, next=ListNode(4, next=ListNode(3)))
    # l2 = ListNode(5, next=ListNode(6, next=ListNode(4)))
    # l1.print()
    # l2.print()
    # l = sol.addTwoNumbers(l1, l2)
    # l.print()
    # print()

    # l1 = ListNode(8)
    # l2 = ListNode(7)
    # l1.print()
    # l2.print()
    # l = sol.addTwoNumbers(l1, l2)
    # l.print()
    # print()

# Input:
# [8,6]
# [6,4,8]
# Output:
# [4,1,9,0]
# Expected:
# [4,1,9]

# Input:
# [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
# [5,6,4]
# Output:
# [6,6,2,2,4,4,2,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
# Expected:
# [6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]

    l1 = ListNode(8, next=ListNode(6))
    l2 = ListNode(6, next=ListNode(4, next=ListNode(8)))
    l1.print()
    l2.print()
    l = sol.addTwoNumbers(l1, l2)
    l.print()
    print()

    # l1 = ListNode(0)
    # l2 = ListNode(0)
    # l1.print()
    # l2.print()
    # l = sol.addTwoNumbers(l1, l2)
    # l.print()
    # print()

    # l1 = ListNode(9, next=ListNode(9, next=ListNode(9, next=ListNode(
    #     9, next=ListNode(9, next=ListNode(9, next=ListNode(9)))))))
    # l2 = ListNode(9, next=ListNode(9, next=ListNode(9, next=ListNode(9))))
    # l1.print()
    # l2.print()
    # l = sol.addTwoNumbers(l1, l2)
    # l.print()
    # print()


# 01
# 1568 / 1568 test cases passed.
# Status: Accepted
# Runtime: 60 ms
# Memory Usage: 14.4 MB

# 02
# 1568 / 1568 test cases passed.
# Status: Accepted
# Runtime: 64 ms
# Memory Usage: 14.3 MB

# 03
# 1568 / 1568 test cases passed.
# Status: Accepted
# Runtime: 72 ms
# Memory Usage: 14.4 MB

# 04
# 1568 / 1568 test cases passed.
# Status: Accepted
# Runtime: 72 ms
# Memory Usage: 14.4 MB
