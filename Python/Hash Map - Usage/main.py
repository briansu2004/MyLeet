"""
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1129/
Hash Map - Usage
The hash map is one of the implementations of a map which is used to store (key, value) pairs.
We provide an example of using the hash map in Java, C++ and Python. If you are not familiar with the usage of the hash map, it will be helpful to go through the example.
"""

# 1. initialize a hash map
hashmap = {0 : 0, 2 : 3}
# 2. insert a new (key, value) pair or update the value of existed key
hashmap[1] = 1
hashmap[1] = 2
# 3. get the value of a key
print("The value of key 1 is: " + str(hashmap[1]))
# 4. delete a key
del hashmap[2]
# 5. check if a key is in the hash map
if 2 not in hashmap:
    print("Key 2 is not in the hash map.")
# 6. both key and value can have different type in a hash map
hashmap["pi"] = 3.1415
# 7. get the size of the hash map
print("The size of hash map is: " + str(len(hashmap)))
# 8. iterate the hash map
for key in hashmap:
    print("(" + str(key) + "," + str(hashmap[key]) + ")", end=" ")
print("are in the hash map.")
# 9. get all keys in hash map
print(hashmap.keys())
# 10. clear the hash map
hashmap.clear();
print("The size of hash map is: " + str(len(hashmap)))
