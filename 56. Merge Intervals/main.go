/*
https://leetcode.com/problems/merge-intervals/
56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 10 power 4
intervals[i].length == 2
0 <= starti <= endi <= 10 power 4
*/

package main

import (
	"fmt"
	"sort"
)

func merge(intervals [][]int) [][]int {
	if len(intervals) < 2 {
		return intervals
	}

	//sort it first
	sort.Slice(intervals[:], func(i, j int) bool {
		for x := range intervals[i] {
			if intervals[i][x] == intervals[j][x] {
				continue
			}
			return intervals[i][x] < intervals[j][x]
		}
		return false
	})

	var i int
	var r [][]int

	n := intervals[0]
	r = append(r, n)

	for i = 1; i < len(intervals); i++ {
		var m = intervals[i]
		if m[0] >= n[0] && m[0] <= n[1] {
			//merge scenario #1
			if n[1] < m[1] {
				n[1] = m[1]
			}
		} else if n[0] >= m[0] && n[0] <= m[1] {
			//merge scenario #2
			n[0] = m[0]
			if n[1] < m[1] {
				n[1] = m[1]
			}
		} else {
			//add a new element to the array
			r = append(r, m)
			n = m
		}
	}

	return r
}

func main() {
	n := [][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}
	fmt.Println(merge(n))

	n = [][]int{{1, 4}, {4, 5}}
	fmt.Println(merge(n))

	n = [][]int{{1, 9}, {2, 6}, {0, 10}, {-10, -3}, {15, 18}}
	fmt.Println(merge(n))

	n = [][]int{{2, 6}, {2, 6}, {1, 9}, {1, 9}}
	fmt.Println(merge(n))
}

// Runtime: 8 ms, faster than 92.99% of Go online submissions for Merge Intervals.
// Memory Usage: 4.7 MB, less than 85.97% of Go online submissions for Merge Intervals.
