"""
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/
Flood Fill

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

Note:
The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

Hint #1  
Write a recursive function that paints the pixel if it's the correct color, then recurses on neighboring pixels.
"""

from typing import List
from collections import deque

class Solution(object):
    #02 BFS
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        h, w = len(image), len(image[0])
        
        src_color = image[sr][sc]
        
        visited = set()
        
        traversal_queue = deque( [(sr, sc)] )
        
        while traversal_queue:
            
            cur_r, cur_c = traversal_queue.popleft()
            
            if cur_r < 0 or cur_r >= h or cur_c < 0 or cur_c >= w or (cur_r, cur_c) in visited or image[cur_r][cur_c] != src_color:
                continue
            
            # update color
            image[cur_r][cur_c] = newColor
            
            # mark current coordinate as visited
            visited.add( (cur_r, cur_c) )
            
            # BFS to 4-connected neighbors
            traversal_queue.append( (cur_r-1, cur_c) )
            traversal_queue.append( (cur_r+1, cur_c) )
            traversal_queue.append( (cur_r, cur_c-1) )
            traversal_queue.append( (cur_r, cur_c+1) )
        
        return image

    #01 DFS
    def floodFill1(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        
        h, w = len(image), len(image[0])
        
        visited = set()
		
        def dfs( r, c, src_color, new_color):
            
            if r < 0 or c < 0 or r >= h or c >= w or (r,c) in visited or image[r][c] != src_color:
                # Reject for invalid coordination, repeated traversal, or different color
                return
            
            # update color
            image[r][c] = new_color
            
            # mark current coordination as visited
            visited.add( (r,c) )
            
            # DFS to 4-connected neighbors
            dfs( r-1, c, src_color, new_color )
            dfs( r+1, c, src_color, new_color )
            dfs( r, c-1, src_color, new_color )
            dfs( r, c+1, src_color, new_color )
            
        # ---------------------------------------------------------------------------
        
        dfs(sr, sc, src_color = image[sr][sc], new_color = newColor)
        
        return image

if __name__ == "__main__":
    sol = Solution()

    image = [[1,1,1],[1,1,0],[1,0,1]]
    sr = 1
    sc = 1
    newColor = 2
    print("floodFill({0}, {1}, {2}, {3}): {4}".format(image, sr, sc, newColor, sol.floodFill(image, sr, sc, newColor)))




# 01
# 277 / 277 test cases passed.
# Status: Accepted
# Runtime: 52 ms
# Memory Usage: 13.6 MB

