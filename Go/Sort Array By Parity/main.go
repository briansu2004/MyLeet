/*
https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
Sort Array By Parity

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
You may return any answer array that satisfies this condition.

Example 1:
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Note:
1 <= A.length <= 5000
0 <= A[i] <= 5000
*/

package main

// 1
func sortArrayByParity(A []int) []int {
	var n, m []int
	for i := 0; i < len(A); i++ {
		if A[i]%2 == 0 {
			m = append(m, A[i])
		} else {
			n = append(n, A[i])
		}
	}
	m = append(m, n...)
	return m
}

// 285 / 285 test cases passed.
// Status: Accepted
// Runtime: 8 ms
// Memory Usage: 5.8 MB
