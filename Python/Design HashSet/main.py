"""
https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:
void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

Example 1:
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1)  # set = [1]
myHashSet.add(2)  # set = [1, 2]
myHashSet.contains(1)  # return True
myHashSet.contains(3)  # return False, (not found)
myHashSet.add(2)  # set = [1, 2]
myHashSet.contains(2)  # return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2)  # return False, (already removed)

Constraints:
0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.
"""


class ListNode(object):
    def __init__(self, key, next):
        self.key = key
        self.next = next


class MyHashSet(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.buckets = [None]*self.size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucketCode = key % self.size
        cur = self.buckets[bucketCode]
        if not cur:
            self.buckets[bucketCode] = ListNode(key, None)
            return
        if cur.key == key:
            return
        while cur:
            if cur.key == key:
                return
            if not cur.next:
                cur.next = ListNode(key, None)
                return
            if cur.next:
                cur = cur.next
        return

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucketCode = key % self.size
        cur = self.buckets[bucketCode]
        if not cur:
            return
        if cur.key == key:
            self.buckets[bucketCode] = cur.next
        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next
        return

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bucketCode = key % self.size
        cur = self.buckets[bucketCode]
        while cur:
            if cur.key == key:
                return True
            cur = cur.next
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
if __name__ == "__main__":
    myHashSet = MyHashSet()
    myHashSet.add(1)  # set = [1]
    myHashSet.add(2)  # set = [1, 2]
    print(myHashSet.contains(1))  # return True
    print(myHashSet.contains(3))  # return False, (not found)
    myHashSet.add(2)  # set = [1, 2]
    print(myHashSet.contains(2))  # return True
    myHashSet.remove(2)  # set = [1]
    print(myHashSet.contains(2))  # return False, (already removed)


# 01
# 32 / 32 test cases passed.
# Status: Accepted
# Runtime: 204 ms
# Memory Usage: 19.8 MB
