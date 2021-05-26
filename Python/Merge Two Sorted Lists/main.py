"""
https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/
Merge Two Sorted Lists
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:
Input: l1 = [], l2 = []
Output: []
Example 3:
Input: l1 = [], l2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.

"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    def print(self):
        if self:
            if self.val:
                print("val: {0}; next: ".format(self.val))
            if next == None:
                print("None")
            else:
                print(self.next)
        else:
            print("None")

class Solution(object):
    #02
    def mergeTwoLists(self, l1, l2):
        if not l1 or l2 and l1.val > l2.val:
            l1, l2 = l2, l1
        if l1:
            l1.next = self.mergeTwoLists(self, l1.next, l2)
        return l1

    #01
    def mergeTwoLists1(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 and l2:
            if l1.val > l2.val:
                l1, l2 = l2, l1
            l1.next = self.mergeTwoLists(self, l1.next, l2)
        return l1 or l2

if __name__ == "__main__":
   l1 = ListNode()
   l2 = ListNode()
   print("mergeTwoLists({0}, {1}) is: {2}".format(print(l1), print(l2), print(Solution.mergeTwoLists(Solution, l1, l2))))

   l1 = ListNode()
   l2 = ListNode(2)
   print("mergeTwoLists({0}, {1}) is: {2}".format(print(l1), print(l2), print(Solution.mergeTwoLists(Solution, l1, l2))))



#https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/discuss/9771/Simple-5-lines-Python?page=4
#this StefanPochmann guy is too good

# 01
# 208 / 208 test cases passed.
# Status: Accepted
# Runtime: 28 ms
# Memory Usage: 13.5 MB

# 02
# 208 / 208 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.5 MB
