"""
https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 
Constraints:
-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
"""

class Solution(object):
    # 02
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1
        if n < 0:
            return self.myPow(1/x, -n)
        tmp = self.myPow(x, n //2) ** 2
        if not n % 2:
            return tmp
        return tmp * x

    # 01
    def myPow(self, x, n):
        if x == 0:
            return 0
        if not n:
            return 1
        if n < 0:
            return 1 / self.myPow(Solution, x, -n)
        if n % 2:
            return x * self.myPow(Solution, x, n-1)
        return self.myPow(Solution, x*x, n/2)

# #00 not working
# def myPow(x, n):
#     """
#     :type x: float
#     :type n: int
#     :rtype: float
#     """

#     # n is positive here
#     def helper(x, n, acc):
#         if n == 1:
#             return acc * x
        
#         return helper(x, n - 1, acc * x)

#     if not n:
#         return 1

#     if n < 0:
#         return 1 / myPow(x, -n)

#     return helper(x, n, 1)

if __name__ == "__main__":
    x = 2.00000
    n = 3
    print("myPow({0}, {1}) is: {2}".format(x, n, Solution.myPow(Solution, x, n)))
    #print("myPow({0}, {1}) is: {2}".format(x, n, myPow(x, n)))

    x = 0
    n = 0
    print("myPow({0}, {1}) is: {2}".format(x, n, Solution.myPow(Solution, x, n)))

    x = 0
    n = -1
    print("myPow({0}, {1}) is: {2}".format(x, n, Solution.myPow(Solution, x, n)))

    x = 1
    n = 0
    print("myPow({0}, {1}) is: {2}".format(x, n, Solution.myPow(Solution, x, n)))

    x = -1
    n = 0
    print("myPow({0}, {1}) is: {2}".format(x, n, Solution.myPow(Solution, x, n)))

# 01
# 304 / 304 test cases passed.
# Status: Accepted
# Runtime: 20 ms
# Memory Usage: 13.5 MB

# 02
# 304 / 304 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.5 MB
