"""
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
Daily Temperatures

Given a list of daily temperatures temperatures, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
For example, given the list of temperatures temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

Hint #1  
If the temperature is say, 70 today, then in the future a warmer temperature must be either 71, 72, 73, ..., 99, or 100. We could remember when all of them occur next.
"""


class Solution(object):
    # 02
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        result = []
        stack = []
        l = len(T)-1

        while l >= 0:
            cur = T[l]
            pos = l

            while stack:
                idx, prev = stack.pop()
                if prev > cur:
                    pos = idx
                    stack.append((idx, prev))
                    break
            result.append(pos-l)
            stack.append((l, cur))
            l -= 1
        return reversed(result)

    # 01

    def dailyTemperatures1(self, T):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        ans = [0] * len(T)
        stack = []
        for i, t in enumerate(T):
            while stack and T[stack[-1]] < t:
                cur = stack.pop()
                ans[cur] = i - cur
            stack.append(i)

        return ans


if __name__ == "__main__":
    sol = Solution()

    temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
    print("sol.dailyTemperatures({0}): {1}".format(
        temperatures, sol.dailyTemperatures(temperatures)))


# 01
# 38 / 38 test cases passed.
# Status: Accepted
# Runtime: 452 ms
# Memory Usage: 17.1 MB

# 02
# 38 / 38 test cases passed.
# Status: Accepted
# Runtime: 508 ms
# Memory Usage: 16.6 MB
