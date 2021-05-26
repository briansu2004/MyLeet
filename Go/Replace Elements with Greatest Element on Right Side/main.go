/*
https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
Replace Elements with Greatest Element on Right Side

Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation:
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.

Example 2:
Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.

Constraints:
1 <= arr.length <= 104
1 <= arr[i] <= 105

Hint #1
Loop through the array starting from the end.

Hint #2
Keep the maximum value seen so far.
*/

package main

// 2
func replaceElements(arr []int) []int {
	n := len(arr)
	output := make([]int, n)

	for i := 0; i < n; i++ {
		p := -1
		for j := i + 1; j < n; j++ {
			if j == i+1 || p < arr[j] {
				p = arr[j]
			}
		}
		output[i] = p
	}
	return output
}

// 1
func replaceElements1(arr []int) []int {
	temp := 0
	maxRight := arr[len(arr)-1]
	for i := len(arr) - 2; i >= 0; i-- {
		temp = arr[i]
		arr[i] = maxRight
		if temp > maxRight {
			maxRight = temp
		}
	}
	arr[len(arr)-1] = -1
	return arr
}

//15 / 15 test cases passed.
// Status: Accepted
// Runtime: 16 ms
// Memory Usage: 6.1 MB
// ==>
// 15 / 15 test cases passed.
// Status: Accepted
// Runtime: 220 ms
// Memory Usage: 5.9 MB
