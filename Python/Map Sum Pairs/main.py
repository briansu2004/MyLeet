"""
https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1058/
Map Sum Pairs

Implement the MapSum class:
MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
Output
[null, null, 3, null, 5]
Explanation
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)

Constraints:
1 <= key.length, prefix.length <= 50
key and prefix consist of only lowercase English letters.
1 <= val <= 1000
At most 50 calls will be made to insert and sum.
"""


class TrieNode():
    def __init__(self, count=0):
        self.count = count
        self.children = {}


class MapSum(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        self.keys = {}

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        # Time: O(k)
        curr = self.root
        delta = val - self.keys.get(key, 0)
        self.keys[key] = val

        curr = self.root
        curr.count += delta
        for char in key:
            if char not in curr.children:
                curr.children[char] = TrieNode()
            curr = curr.children[char]
            curr.count += delta

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        # Time: O(k)
        curr = self.root
        for char in prefix:
            if char not in curr.children:
                return 0
            curr = curr.children[char]
        return curr.count


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)

if __name__ == "__main__":
    mapSum = MapSum()
    mapSum.insert("apple", 3)
    print(mapSum.sum("ap"))   # return 3 (apple = 3)
    mapSum.insert("app", 2)
    print(mapSum.sum("ap"))  # return 5 (apple + app = 3 + 2 = 5)


# 01
# 34 / 34 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 14.4 MB

