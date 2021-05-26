"""
https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30
"""


from typing import List


class Solution:
    # 02
    def generate(self, numRows: int) -> List[List[int]]:
        ans = []

        for row_num in range(numRows):
            row = [1] * (row_num+1)

            for i in range(1, row_num):
                row[i] = ans[row_num-1][i-1] + ans[row_num-1][i]

            ans.append(row)

        return ans

    # 01
    def generate1(self, numRows: int) -> List[List[int]]:
        pascal = [[1]*(i+1) for i in range(numRows)]
        for i in range(numRows):
            for j in range(1, i):
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
        return pascal


if __name__ == "__main__":
    sol = Solution()

    for n in range(10):
        print(f"n:", n)
        print(f"generate(n):", sol.generate(n))


# 01
# 14 / 14 test cases passed.
# Status: Accepted
# Runtime: 28 ms
# Memory Usage: 14.4 MB

# 02
# 14 / 14 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.4 MB
