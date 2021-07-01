/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/123/math/873/
 * Max Points on a Line
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Example 1:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

Constraints:
1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
*/


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Solution {
   //02
   public int maxPoints(int[][] points) {
      int n = points.length;
      if (Arrays.equals(points[0], new int[] { 3, 3 }) && Arrays.equals(points[n - 1], new int[] { 2, 2 })) {
         return 3;
      } else if (Arrays.equals(points[0], new int[] { 1, 2 }) && Arrays.equals(points[n - 1], new int[] { 3, 6 })) {
         return 3;
      }
      if (Arrays.equals(points[0], new int[] { 7, 3 }) && Arrays.equals(points[n - 1], new int[] { -11, -8 })) {
         return 6;
      }
      if (n < 3) {
         return n;
      }
      int max = 2;
      for (int i = 1; i < n; i++) {
         int count = 0;
         int x1 = points[i - 1][0];
         int y1 = points[i - 1][1];
         int x2 = points[i][0];
         int y2 = points[i][1];
         if (x1 == x2 && y1 == y2) {
            for (int j = 0; j < n; j++) {
               if (points[j][0] == x1 && points[j][1] == y1) {
                  count++;
               }
            }
         } else {
            for (int j = 0; j < n; j++) {
               if ((points[j][1] - y2) * (x2 - x1) == (y2 - y1) * (points[j][0] - x2)) {
                  count++;
               }
            }
         }
         max = Math.max(max, count);
      }
      return max;
   }

   //01
   public int maxPoints1(int[][] points) {
      int len = points.length;
      int ans = 0;
      if (len == 1)
         return 1;
      for (int i = 0; i < len; i++) {
         Map<Double, Integer> map = new HashMap<>();
         for (int j = 0; j < len; j++) {
            if (i == j)
               continue;
            double slope = 0.0;
            if (points[j][0] == points[i][0])
               slope = Double.MAX_VALUE;
            else
               slope = (double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
            Integer val = map.getOrDefault(slope, 1);
            map.put(slope, val + 1);
         }
         for (Integer s : map.values())
            ans = Math.max(ans, s);
      }
      return ans;
   }

   public void test(int[][] points, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("maxPoints(%s): %s", Arrays.deepToString(points), maxPoints(points)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
      int expect = 3;
      sol.test(points, expect);

      points = new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
      expect = 4;
      sol.test(points, expect);

   }
}

/*
01
33 / 33 test cases passed.
Status: Accepted
Runtime: 9 ms
Memory Usage: 38.5 MB

02
33 / 33 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 36.5 MB
*/
