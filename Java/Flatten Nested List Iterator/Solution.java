/**
 *https://leetcode.com/explore/interview/card/top-interview-questions-hard/122/design/869/
 Flatten Nested List Iterator

You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
Implement the NestedIterator class:
NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
Your code will be tested with the following pseudocode:
initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
If res matches the expected flattened list, then your code will be judged as correct.

Example 1:
Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
Example 2:
Input: nestedList = [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

Constraints:
1 <= nestedList.length <= 500
The values of the integers in the nested list is in the range [-106, 106].
*/


class Solution {
   public static void main(String[] args) {
      LRUCache lRUCache = new LRUCache(2);

      lRUCache.put(1, 1); // cache is {1=1}
      System.out.println(lRUCache.toString());

      lRUCache.put(2, 2); // cache is {1=1, 2=2}
      System.out.println(lRUCache.toString());

      lRUCache.get(1); // return 1
      System.out.println(lRUCache.toString());

      lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
      System.out.println(lRUCache.toString());

      lRUCache.get(2); // returns -1 (not found)
      System.out.println(lRUCache.toString());

      lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
      System.out.println(lRUCache.toString());

      lRUCache.get(1); // return -1 (not found)
      System.out.println(lRUCache.toString());

      lRUCache.get(3); // return 3
      System.out.println(lRUCache.toString());

      lRUCache.get(4); // return 4
      System.out.println(lRUCache.toString());

   }
}

/*
01



*/


