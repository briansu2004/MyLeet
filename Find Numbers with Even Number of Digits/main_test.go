/*
https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
Find Numbers with Even Number of Digits

Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.

Example 2:
Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.

Constraints:
1 <= nums.length <= 500
1 <= nums[i] <= 10^5

Hide Hint #1
How to compute the number of digits of a number ?
Hide Hint #2
Divide the number by 10 again and again to get the number of digits.
*/

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestFindNumbers(t *testing.T) {
	var n []int

	assert.Equal(t, findNumbers(n), 0)

	n = []int{0}
	assert.Equal(t, findNumbers(n), 0)

	n = []int{1}
	assert.Equal(t, findNumbers(n), 0)

	n = []int{49, 2}
	assert.Equal(t, findNumbers(n), 1)

	n = []int{234, 20, 2230, 210}
	assert.Equal(t, findNumbers(n), 2)

	n = []int{12, 345, 2, 6, 7896}
	assert.Equal(t, findNumbers(n), 2)

	n = []int{555, 901, 482, 1771}
	assert.Equal(t, findNumbers(n), 1)

	n = []int{36, 27, 8, 12, 5068, 42}
	assert.Equal(t, findNumbers(n), 5)
}
