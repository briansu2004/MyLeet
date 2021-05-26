"""
https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1165/
Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:
Input: s = "God Ding"
Output: "doG gniD"

Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.

"""


class Solution:
    # 02
    def reverseWords(self, s: str) -> str:
        return ' '.join(s.split()[::-1])[::-1]

    # 01
    def reverseWords1(self, s: str) -> str:
        return ' '.join(x[::-1] for x in s.split())


if __name__ == "__main__":
    sol = Solution()

    s = "Let's take LeetCode contest"
    print("reverseWords({0}): {1}".format(s, sol.reverseWords(s)))

    s = "God Ding"
    print("reverseWords({0}): {1}".format(s, sol.reverseWords(s)))


# 01
# 29 / 29 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.9 MB
