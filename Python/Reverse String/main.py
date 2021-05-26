"""
https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
 
Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Hide Hint #1  
The entire logic for reversing a string is based on using the opposite directional two-pointer approach!

Self is always pointing to Current Object.

"""


from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
    #def reverseString(self, s):
        """
        Do not return anything, modify s in-place instead.
        """
        # 01
        #s[:] = s[::-1]

        # 02
        # s=s.reverse()

        # 03
        start = 0
        end = len(s)-1
        while start < end:
            temp = s[start]
            s[start] = s[end]
            s[end] = temp
            start += 1
            end -= 1


# 01
# 477 / 477 test cases passed.
# Status: Accepted
# Runtime: 176 ms
# Memory Usage: 18.7 MB

# 02
# 477 / 477 test cases passed.
# Status: Accepted
# Runtime: 188 ms
# Memory Usage: 18.7 MB

# 03
# 477 / 477 test cases passed.
# Status: Accepted
# Runtime: 192 ms
# Memory Usage: 18.8 MB


class car():

    # init method or constructor
    def __init__(self, model, color):
        self.model = model
        self.color = color

    def show(self):
        print("Model is", self.model)
        print("color is", self.color)


if __name__ == "__main__":
    # both objects have different self which
    # contain their attributes
    audi = car("audi a4", "blue")
    ferrari = car("ferrari 488", "green")

    audi.show()     # same output as car.show(audi)
    ferrari.show()  # same output as car.show(ferrari)

    car.show(audi)
    car.show(ferrari)

    # Behind the scene, in every instance method
    # call, python sends the instances also with
    # that method call like car.show(audi)

    s = ["h", "e", "l", "l", "o"]
    print(s)

    Solution.reverseString(Solution, s)
    print(s)
    
    