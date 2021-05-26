"""
https://leetcode.com/explore/learn/card/binary-search/125/template-i/951/
Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
You call a pre-defined API int guess(int num), which returns 3 possible results:
-1: The number I picked is lower than your guess (i.e. pick < num).
1: The number I picked is higher than your guess (i.e. pick > num).
0: The number I picked is equal to your guess (i.e. pick == num).
Return the number that I picked.

Example 1:
Input: n = 10, pick = 6
Output: 6
Example 2:
Input: n = 1, pick = 1
Output: 1
Example 3:
Input: n = 2, pick = 1
Output: 1
Example 4:
Input: n = 2, pick = 2
Output: 2

Constraints:
1 <= n <= 231 - 1
1 <= pick <= n
"""

# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

class Solution:
    pick = 1

    def guess(num: int) -> int:
        if num < Solution.pick:
            return 1
        elif num > Solution.pick:
            return -1
        
        return 0

    def guessNumber(self, n: int) -> int:
        s=1
        e=n+1
        num=1
        while s<e:
            num=(s+e)>>1
            res=Solution.guess(num)
            if res==0:
                return num  
            elif res<0:
                e=num
            else:
                s=num+1
        return s
        

if __name__ == "__main__":
    #pick = 1
    
    n = 1
    print("guessNumber({0}): {1}".format(n, Solution.guessNumber(Solution, n)))

    n = 2
    print("guessNumber({0}): {1}".format(n, Solution.guessNumber(Solution, n)))



# 01
# 25 / 25 test cases passed.
# Status: Accepted
# Runtime: 28 ms
# Memory Usage: 14.3 MB

