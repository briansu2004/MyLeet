"""
https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
K-th Symbol in Grammar

On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
Given row n and index k, return the kth indexed symbol in row n. (The values of k are 1-indexed.) (1 indexed).

Examples:
Input: n = 1, k = 1
Output: 0
Input: n = 2, k = 1
Output: 0
Input: n = 2, k = 2
Output: 1
Input: n = 4, k = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
Note:
n will be an integer in the range [1, 30].
k will be an integer in the range [1, 2n-1].

Hint #1  
Try to represent the current (N, K) in terms of some (N-1, prevK). What is prevK ?
"""

class Solution(object):
    #2
    def kthGrammar(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        return bin(k - 1).count('1') & 1

    #01
    def kthGrammar1(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        return bin(k-1).count('1')%2

if __name__ == "__main__":
   n = 1
   k = 1
   print("kthGrammar({0}, {1}) is: {2}".format(n, k, Solution.kthGrammar(Solution, n, k)))

   n = 2
   k = 1
   print("kthGrammar({0}, {1}) is: {2}".format(n, k, Solution.kthGrammar(Solution, n, k)))

   n = 2
   k = 2
   print("kthGrammar({0}, {1}) is: {2}".format(n, k, Solution.kthGrammar(Solution, n, k)))

   n = 4
   k = 5
   print("kthGrammar({0}, {1}) is: {2}".format(n, k, Solution.kthGrammar(Solution, n, k)))

# 01
# 55 / 55 test cases passed.
# Status: Accepted
# Runtime: 12 ms
# Memory Usage: 13.5 MB

# 02
# 55 / 55 test cases passed.
# Status: Accepted
# Runtime: 20 ms
# Memory Usage: 13.4 MB
