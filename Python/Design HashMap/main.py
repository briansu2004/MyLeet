"""
https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1140/
Design HashMap

Design a HashMap without using any built-in hash table libraries.
Implement the MyHashMap class:
MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

Example 1:
Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 
Constraints:
0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.
"""

import math


#03 
class MyHashMap(object):
    def __init__(self):
        self.map = [[] for i in range(1024)]

    def put(self, key, value):
        self.remove(key)
        self.map[key & 1023].append((key, value))
        
    def get(self, key):
        values = [x[1] for x in self.map[key & 1023] if x[0] == key]
        return -1 if len(values) == 0 else values[0]   

    def remove(self, key):
        self.map[key & 1023] = [x for x in self.map[key & 1023] if x[0] != key]


#02 not working
class MyHashMap2:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.nums=[-1]*1000000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.nums[key]=value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        return self.nums[key]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.nums[key]=-1


#01 not working
class MyHashMap1(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.golden_ratio = 1.618
        self.table_size = 65536
        self.table = [[] for _ in range(self.table_size)]
        self.hash = lambda i: i * \
            math.ceil(self.golden_ratio*self.table_size) % self.table_size

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        self.remove(key)  # use the function you wrote already!
        hkey = self.hash(key)
        self.table[hkey].append((key, value))

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        hkey = self.hash(key)
        ix = -1
        for i, x in enumerate(self.table[hkey]):
            if x[0] == key:
                ix = i
        return -1 if ix == -1 else self.table[hkey][ix][1]

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        hkey = self.hash(key)
        ix = -1
        for i, x in enumerate(self.table[hkey]):
            if x[0] == key:
                ix = i
        if ix >= 0:
            del self.table[hkey][ix]


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

if __name__ == "__main__":
    myHashMap = MyHashMap()
    myHashMap.put(1, 1)  # The map is now [[1,1]]
    myHashMap.put(2, 2)  # The map is now [[1,1], [2,2]]
    print(myHashMap.get(1))  # return 1, The map is now [[1,1], [2,2]]
    print(myHashMap.get(3)) # return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.put(2, 1) # The map is now [[1,1], [2,1]] (i.e., update the existing value)
    print(myHashMap.get(2))  # return 1, The map is now [[1,1], [2,1]]
    myHashMap.remove(2)  # remove the mapping for 2, The map is now [[1,1]]
    print(myHashMap.get(2)) # return -1 (i.e., not found), The map is now [[1,1]]

# 03
# 36 / 36 test cases passed.
# Status: Accepted
# Runtime: 248 ms
# Memory Usage: 17.5 MB
