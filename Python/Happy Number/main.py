"""
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131/
Happy Number

Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:
Input: n = 2
Output: false

Constraints:
1 <= n <= 231 - 1
"""


class Solution(object):
    # 02
    def isHappy(self, n):
        cycle = set()
        while n != 1 and n not in cycle:
            cycle.add(n)
            n = sum(int(i)**2 for i in str(n))
        return n == 1


class Solution1(object):
    # 01 has issues
    def isHappy1(self, n):
        """
        :type n: int
        :rtype: bool
        """
        def sqsum(num):
            res = 0
            while num > 0:
                r = num % 10
                res += r * r
                num /= 10
            return res

        rec = set()
        while sqsum(n) not in rec:
            summ = sqsum(n)
            if summ == 1:
                return True
            else:
                rec.add(summ)
                n = summ
        return False


if __name__ == "__main__":
    sol = Solution()

    n = 19
    print(f"n:", n)
    print(f"isHappy(n):", sol.isHappy(n))

    n = 2
    print(f"n:", n)
    print(f"isHappy(n):", sol.isHappy(n))

    n = 3
    print(f"n:", n)
    print(f"isHappy(n):", sol.isHappy(n))

# 01
# 402 / 402 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 13.4 MB
