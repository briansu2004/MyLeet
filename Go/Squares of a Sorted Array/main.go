/*
https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
*/

package main

import "sort"

//nums is sorted in non-decreasing order!!!
func sortedSquares(nums []int) []int {
	l, r := 0, len(nums)-1
	res := make([]int, len(nums))
	for i := len(nums) - 1; i >= 0; i-- {
		if abs(nums[l]) > abs(nums[r]) {
			res[i] = nums[l] * nums[l]
			l++
		} else {
			res[i] = nums[r] * nums[r]
			r--
		}
	}
	return res
}

func abs(n int) int {
	if n > 0 {
		return n
	}
	return -n
}

func sortedSquares0(nums []int) (res []int) {
	for _, v := range nums {
		res = append(res, v*v)
	}

	sort.Ints(res)

	return res
}

//137 / 137 test cases passed.
// Status: Accepted
// Runtime: 32 ms
// Memory Usage: 6.6 MB
//
// =>
//137 / 137 test cases passed.
// Status: Accepted
// Runtime: 28 ms
// Memory Usage: 6.6 MB
// Your runtime beats 92.02 % of golang submission
// Your memory usage beats 74.47 % of golang submissions
