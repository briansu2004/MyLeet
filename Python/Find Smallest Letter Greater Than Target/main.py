"""
https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
Find Smallest Letter Greater Than Target

Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"
Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"
Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"
Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"
Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"
Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"

Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.

Hint #1  
Try to find whether each of 26 next letters are in the given string array.
"""


import heapq

class Solution(object):
    #02
    def nextGreatestLetter(self, letters, target):
        """
        :type letters: List[str]
        :type target: str
        :rtype: str
        """
        
        first = None
        heapq.heapify(letters)
        while len(letters) !=0:
            source = heapq.heappop(letters)
            if source > target:
                return source
            if first is None:
                first = source
        return  first

    #01
    def nextGreatestLetter1(self, letters, target):
        """
        :type letters: List[str]
        :type target: str
        :rtype: str
        """
        for letter in letters:
            if letter > target:
                return letter
        return letters[0] # If not found

if __name__ == "__main__":
    letters = ["c", "f", "j"]
    target = "a"
    print("nextGreatestLetter({0}, {1}): {2}".format(
        letters, target, Solution.nextGreatestLetter(Solution, letters, target)))

    letters = ["c", "f", "j"]
    target = "c"
    print("nextGreatestLetter({0}, {1}): {2}".format(
        letters, target, Solution.nextGreatestLetter(Solution, letters, target)))

    letters = ["c", "f", "j"]
    target = "d"
    print("nextGreatestLetter({0}, {1}): {2}".format(
        letters, target, Solution.nextGreatestLetter(Solution, letters, target)))

    letters = ["c", "f", "j"]
    target = "g"
    print("nextGreatestLetter({0}, {1}): {2}".format(
        letters, target, Solution.nextGreatestLetter(Solution, letters, target)))

    letters = ["c", "f", "j"]
    target = "j"
    print("nextGreatestLetter({0}, {1}): {2}".format(
        letters, target, Solution.nextGreatestLetter(Solution, letters, target)))

    letters = ["c", "f", "j"]
    target = "k"
    print("nextGreatestLetter({0}, {1}): {2}".format(
        letters, target, Solution.nextGreatestLetter(Solution, letters, target)))


# 01
# 165 / 165 test cases passed.
# Status: Accepted
# Runtime: 140 ms
# Memory Usage: 15.4 MB

# 02
# 165 / 165 test cases passed.
# Status: Accepted
# Runtime: 124 ms
# Memory Usage: 15.1 MB
