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

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestSortedSquares(t *testing.T) {
	var n []int

	//assert.Equal(t, sortedSquares(n), nil)

	n = []int{0}
	assert.Equal(t, sortedSquares(n), []int{0})

	n = []int{1}
	assert.Equal(t, sortedSquares(n), []int{1})

	n = []int{-1}
	assert.Equal(t, sortedSquares(n), []int{1})

	n = []int{-2, 0, 3}
	assert.Equal(t, sortedSquares(n), []int{0, 4, 9})

	n = []int{-4, -1, 0, 3, 10}
	assert.Equal(t, sortedSquares(n), []int{0, 1, 9, 16, 100})

	n = []int{-7, -3, 2, 3, 11}
	assert.Equal(t, sortedSquares(n), []int{4, 9, 9, 49, 121})
}
