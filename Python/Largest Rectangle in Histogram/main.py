"""
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104
"""

class Solution(object):
    #02
    def largestRectangleArea(self, heights):
        heights.append(0)
        stack = [-1]
        ans = 0
        for i in range(len(heights)):
            while heights[i] < heights[stack[-1]]:
                h = heights[stack.pop()]
                w = i - stack[-1] - 1
                ans = max(ans, h * w)
            stack.append(i)
        heights.pop()
        return ans

    #01
    def largestRectangleArea1(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        max_area, st = 0, []
        for idx,x in enumerate(heights):
            if len(st) == 0:
                st.append(idx)
            elif x >= heights[st[-1]]:
                st.append(idx)
            else:
                while st and heights[st[-1]] > x:
                    # For min_height, the right index is idx and the left index is st[-1].
                    # Distance between them will be (right_index - left_index - 1). right & left index are not included in result.
                    # If the stack is empty, then no bar on left is smaller. So width of base is idx.
                    min_height = heights[st.pop()] 
                    max_area = max(max_area, min_height*(idx-1-st[-1])) if st else max(max_area, min_height*idx)
                st.append(idx)
        while st:
            min_height = heights[st.pop()] 
            max_area = max(max_area, min_height*(len(heights)-1-st[-1])) if st else max(max_area, min_height*len(heights))
        return max_area

if __name__ == "__main__":
    h = []
    print("largestRectangleArea({0}): {1}".format(h, Solution.largestRectangleArea(Solution, h)))

    h = [7]
    print("largestRectangleArea({0}): {1}".format(h, Solution.largestRectangleArea(Solution, h)))

    h = [2,4]
    print("largestRectangleArea({0}): {1}".format(h, Solution.largestRectangleArea(Solution, h)))

    h = [2,1,5,6,2,3]
    print("largestRectangleArea({0}): {1}".format(h, Solution.largestRectangleArea(Solution, h)))


# 01
# 96 / 96 test cases passed.
# Status: Accepted
# Runtime: 716 ms
# Memory Usage: 23 MB

# 02
# 96 / 96 test cases passed.
# Status: Accepted
# Runtime: 704 ms
# Memory Usage: 24.6 MB
