/*
https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
Merge Sorted Array

Solution
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109

You can easily solve this problem if you simply think about two elements at a time rather than two arrays. We know that each of the individual arrays is sorted. What we don't know is how they will intertwine. Can we take a local decision and arrive at an optimal solution?
If you simply consider one element each at a time from the two arrays and make a decision and proceed accordingly, you will arrive at the optimal solution.
*/

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMerge(t *testing.T) {
	var n1, n2 []int
	var m, n int

	n1 = []int{}
	n2 = []int{}
	m = 0
	n = 0
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{})

	n1 = []int{0}
	n2 = []int{1}
	m = 0
	n = 1
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{1})

	n1 = []int{1}
	n2 = []int{}
	m = 1
	n = 0
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{1})

	n1 = []int{-3, -2}
	n2 = []int{}
	m = 2
	n = 0
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{-3, -2})

	n1 = []int{-100, 0, 0}
	n2 = []int{10}
	m = 2
	n = 1
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{-100, 0, 10})

	n1 = []int{10, 0, 0}
	n2 = []int{3, 17}
	m = 1
	n = 2
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{3, 10, 17})

	n1 = []int{1, 0, 0}
	n2 = []int{23, 69}
	m = 1
	n = 2
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{1, 23, 69})

	n1 = []int{1, 2, 3, 0, 0, 0}
	n2 = []int{2, 5, 6}
	m = 3
	n = 3
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{1, 2, 2, 3, 5, 6})

	n1 = []int{2, 100, 300, 400, 0, 0, 0, 0}
	n2 = []int{1, 5, 12, 120}
	m = 4
	n = 4
	merge(n1, m, n2, n)
	assert.Equal(t, len(n1), m+n)
	assert.Equal(t, len(n2), n)
	assert.Equal(t, n1, []int{1, 2, 5, 12, 100, 120, 300, 400})
}
