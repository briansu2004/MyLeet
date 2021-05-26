/*
https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
Third Maximum Number

Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:
Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.

Example 2:
Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Can you find an O(n) solution?
*/

package main

import "math"

// 2
func itof(arr []int) []float64 {
	new := make([]float64, len(arr))
	for i, v := range arr {
		new[i] = float64(v)
	}
	return new
}

func thirdMax(nums []int) int {
	arr := itof(nums)
	m1, m2, m3 := math.Inf(-1), math.Inf(-1), math.Inf(-1)
	for _, v := range arr {
		if v > m1 {
			m3 = m2
			m2 = m1
			m1 = v
		} else if v > m2 && v < m1 {
			m3 = m2
			m2 = v
		} else if v > m3 && v < m2 {
			m3 = v
		}
	}
	if m3 != math.Inf(-1) {
		return int(m3)
	} else {
		return int(m1)
	}
}

// 1
func thirdMax1(nums []int) int {
	max, second, third := math.MinInt64, math.MinInt64, math.MinInt64

	for _, v := range nums {
		if v == max || v == second || v == third {
			continue
		}

		switch {
		case v > max:
			max, second, third = v, max, second
		case v > second:
			second, third = v, second
		case v > third:
			third = v
		}
	}

	if third == math.MinInt64 {
		return max
	}

	return third
}

// 27 / 27 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 3.1 MB

// 27 / 27 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 3.3 MB
