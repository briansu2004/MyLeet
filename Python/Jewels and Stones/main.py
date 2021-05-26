"""
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1136/
Jewels and Stones

You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0
 
Constraints:
1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.

Hint #1  
For each stone, check if it is a jewel.
"""


class Solution:
    #03
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        return sum(map(jewels.count, stones))

    #02
    def numJewelsInStones2(self, jewels: str, stones: str) -> int:
        return sum(map(stones.count, jewels))

    #01
    def numJewelsInStones1(self, jewels: str, stones: str) -> int:
        return sum(s in jewels for s in stones)


if __name__ == "__main__":
    sol = Solution()

    jewels = "aA"
    stones = "aAAbbbb"
    print(f"jewels:", jewels)
    print(f"stones:", stones)
    print(f"numJewelsInStones(jewels, stones):",
          sol.numJewelsInStones(jewels, stones))


# 02
# 255 / 255 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.1 MB

# 01
# 255 / 255 test cases passed.
# Status: Accepted
# Runtime: 20 ms
# Memory Usage: 14.4 MB
