
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/
 * Merge Intervals
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution {
   //01
   public int[][] merge(int[][] intervals) {
      if (intervals.length <= 1)
         return intervals;

      // Sort by ascending starting point
      Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

      List<int[]> result = new ArrayList<>();
      int[] newInterval = intervals[0];
      result.add(newInterval);
      for (int[] interval : intervals) {
         if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
            newInterval[1] = Math.max(newInterval[1], interval[1]);
         else { // Disjoint intervals, add the new interval to the list
            newInterval = interval;
            result.add(newInterval);
         }
      }

      return result.toArray(new int[result.size()][]);
   }

   // Mine has issues
   public int[][] mergeMine(int[][] intervals) {
      if (intervals.length < 2) {
         return intervals;
      }

      for (int i = 0; i < intervals.length - 1; i++) {
         for (int j = i + 1; j < intervals.length; j++) {
            if (intervals[i][1] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
               intervals[i][1] = intervals[j][1];

               if (intervals[i][0] > intervals[j][0]) {
                  intervals[i][0] = intervals[j][0];
               } else {
                  intervals[j][0] = intervals[i][0];
               }
               i++;
               continue;
            }

         }
      }

      Integer[][] i2 = Arrays.stream(intervals).map(row -> Arrays.stream(row).boxed().toArray(Integer[]::new))
            .toArray(Integer[][]::new);

      Set<Integer> n2dSet = new TreeSet<>(); // or LinkedHashSet if you need a similar order than the array
      for (Integer[] inner : i2) {
         for (Integer item : inner) {
            n2dSet.add(item);
         }
      }

      int[][] array = new int[n2dSet.size() / 2][];
      Object[] all = n2dSet.toArray();
      for (int i = 0; i < array.length; i++) {
         array[i] = new int[] { (int) all[i * 2], (int) all[i * 2 + 1] };
      }

      return array;
   }

   public void test(int[][] intervals, int[][] expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(
            String.format("merge(%s): %s", Arrays.deepToString(intervals), Arrays.deepToString(merge(intervals))));
      System.out.println(String.format("Expect: %s", Arrays.deepToString(expect)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      // [[1,4],[4,5]]
      // [[1,5]]
      int[][] intervals = { { 1, 4 }, { 4, 5 } };
      int[][] expect = { { 1, 5 } };
      sol.test(intervals, expect);

      intervals = new int[][] { { 1, 4 }, { 4, 5 }, { 8, 9 } };
      expect = new int[][] { { 1, 5 }, { 8, 9 } };
      sol.test(intervals, expect);

      // [[1,3],[2,6],[8,10],[15,18]]
      // [[1,6],[8,10],[15,18]]
      intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
      expect = new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } };
      sol.test(intervals, expect);

      // [[1,4],[0,1]]
      // [[0,4]]
      intervals = new int[][] { { 1, 4 }, { 0, 1 } };
      expect = new int[][] { { 0, 4 } };
      sol.test(intervals, expect);
   }
}

/*
 * Mine
 * Wrong Answer
Input:
[[1,4],[0,1]]
Output:
[[0,1]]
Expected:
[[0,4]]
 */

/*
01
168 / 168 test cases passed.
Status: Accepted
Runtime: 5 ms
Memory Usage: 41.7 MB
 */