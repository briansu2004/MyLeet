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

import "math"

func findNumbers(nums []int) (cnt int) {
	for _, v := range nums {
		v = int(math.Log10(float64(v))) + 1

		if v%2 == 0 {
			cnt++
		}
	}
	return cnt
}

func findNumbers0(nums []int) int {
	cnt := 0

	for _, v := range nums {
		if totalDigits(v)%2 == 0 {
			cnt++
		}
	}

	return cnt
}

func totalDigits(n int) int {
	if n < 10 {
		return 1
	}
	return totalDigits(n/10) + 1
}

// 104 / 104 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 3.1 MB
