"""
https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/
Combinations

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:
Input: n = 1, k = 1
Output: [[1]]

Constraints:
1 <= n <= 20
1 <= k <= n
"""


from typing import List
import itertools

class Solution:
    #02
    def combine(self, n: int, k: int) -> List[List[int]]:
        return itertools.combinations(list(range(1, n+1)), k)

    #01
    def combine1(self, n: int, k: int) -> List[List[int]]:
        result = []

        def gen_comb(n, k, start, cur_comb):
            if k == len(cur_comb):
                # base case, also known as stop condition
                result.append(cur_comb[::])
                return
            else:
                # general case:
                # solve in DFS
                for i in range(start, n+1):
                    cur_comb.append(i)
                    gen_comb(n, k, i+1, cur_comb)
                    cur_comb.pop()
                return

        gen_comb(n, k, start=1, cur_comb=[])
        return result

    def printWell(l: List[List[int]]) -> None:
        for i in l:
            print(" ".join(map(str, i)))


if __name__ == "__main__":
    n = 1
    k = 1
    #print("combine({0}, {1}): {2}".format(n, k, Solution.combine(Solution, n, k)))
    #print("combine({0}, {1}): {2}".format(n, k, Solution.printWell(Solution.combine(Solution, n, k))))
    print("combine({0}, {1}): ".format(n, k))
    Solution.printWell(Solution.combine(Solution, n, k))

    n = 4
    k = 2
    #print("combine({0}, {1}): {2}".format(n, k, Solution.combine(Solution, n, k)))
    #print("combine({0}, {1}): {2}".format(n, k, Solution.printWell(Solution.combine(Solution, n, k))))
    print("combine({0}, {1}): ".format(n, k))
    Solution.printWell(Solution.combine(Solution, n, k))

    n = 6
    k = 3
    #print("combine({0}, {1}): {2}".format(n, k, Solution.combine(Solution, n, k)))
    #print("combine({0}, {1}): {2}".format(n, k, Solution.printWell(Solution.combine(Solution, n, k))))
    print("combine({0}, {1}): ".format(n, k))
    Solution.printWell(Solution.combine(Solution, n, k))

# 01
# 27 / 27 test cases passed.
# Status: Accepted
# Runtime: 440 ms
# Memory Usage: 15.7 MB

# 02
# 27 / 27 test cases passed.
# Status: Accepted
# Runtime: 60 ms
# Memory Usage: 14.9 MB
