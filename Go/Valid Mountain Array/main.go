/*
https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
Valid Mountain Array

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:
Input: arr = [2,1]
Output: false

Example 2:
Input: arr = [3,5,5]
Output: false

Example 3:
Input: arr = [0,3,2,1]
Output: true

Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 104

It's very easy to keep track of a monotonically increasing or decreasing ordering of elements. You just need to be able to determine the start of the valley in the mountain and from that point onwards, it should be a valley i.e. no mini-hills after that. Use this information in regards to the values in the array and you will be able to come up with a straightforward solution.
*/

package main

// 2
func validMountainArray(arr []int) bool {
	if len(arr) < 3 {
		return false
	}

	left := 0
	right := 0
	top := 0

	for i := 1; i < len(arr); i++ {
		if arr[i-1] == arr[i] {
			return false
		}

		if arr[i-1] < arr[i] {
			top = i
		}

		if right != 0 && top > right {
			return false
		}

		if arr[i] < arr[i-1] {
			right = i
		}
	}

	return left == 0 && top > 0 && top < right && right == len(arr)-1
}

// 1
func validMountainArray1(arr []int) bool {
	if len(arr) < 3 {
		return false
	}

	i, j := 0, len(arr)-1
	for i != j {
		if arr[j-1] > arr[j] {
			j--
			continue
		}
		if arr[i+1] > arr[i] {
			i++
			continue
		}
		return false
	}
	if i == 0 || j == len(arr)-1 {
		return false
	}
	return true
}

// 53 / 53 test cases passed.
// Status: Accepted
// Runtime: 28 ms
// Memory Usage: 6.2 MB
// ==>
// 53 / 53 test cases passed.
// Status: Accepted
// Runtime: 24 ms
// Memory Usage: 6.2 MB
