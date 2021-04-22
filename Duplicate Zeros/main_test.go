/*
https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
Duplicate Zeros

Solution
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place, do not return anything from your function.

Example 1:
Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

Example 2:
Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]

Note:
1 <= arr.length <= 10000
0 <= arr[i] <= 9

This is a great introductory problem for understanding and working with the concept of in-place operations. The problem statement clearly states that we are to modify the array in-place. That does not mean we cannot use another array. We just don't have to return anything.
A better way to solve this would be without using additional space. The only reason the problem statement allows you to make modifications in place is that it hints at avoiding any additional memory.
The main problem with not using additional memory is that we might override elements due to the zero duplication requirement of the problem statement. How do we get around that?
If we had enough space available, we would be able to accommodate all the elements properly. The new length would be the original length of the array plus the number of zeros. Can we use this information somehow to solve the problem?
*/

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestDuplicateZeros(t *testing.T) {
	var n []int

	n = []int{0}
	duplicateZeros(n)
	assert.Equal(t, n, []int{0})

	n = []int{1}
	duplicateZeros(n)
	assert.Equal(t, n, []int{1})

	n = []int{0, 1}
	duplicateZeros(n)
	assert.Equal(t, n, []int{0, 0})

	n = []int{0, 7, 9}
	duplicateZeros(n)
	assert.Equal(t, n, []int{0, 0, 7})

	n = []int{0, 0, 4}
	duplicateZeros(n)
	assert.Equal(t, n, []int{0, 0, 0})

	n = []int{-2, 0, 3}
	duplicateZeros(n)
	assert.Equal(t, n, []int{-2, 0, 0})

	n = []int{1, 2, 3}
	duplicateZeros(n)
	assert.Equal(t, n, []int{1, 2, 3})

	n = []int{1, 0, 2, 3, 0, 4, 5, 0}
	duplicateZeros(n)
	assert.Equal(t, n, []int{1, 0, 0, 2, 3, 0, 0, 4})

	n = []int{1, 0, 2, 3, 0, 4, 5, 1}
	duplicateZeros(n)
	assert.Equal(t, n, []int{1, 0, 0, 2, 3, 0, 0, 4})
}
