/*
https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
Design Linked List

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:
MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

Example 1:
Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3

Constraints:
0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
*/

package main

type MyNode struct {
	Val  int
	Next *MyNode
}

type MyLinkedList struct {
	head *MyNode
	tail *MyNode
	len  int
}

/** Initialize your data structure here. */
func Constructor() MyLinkedList {
	list := MyLinkedList{len: 0, head: &MyNode{}, tail: nil}
	return list
}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
func (this *MyLinkedList) Get(index int) int {
	if index >= this.len {
		return -1
	}

	cur := this.head
	for i := 0; i < index+1; i++ {
		cur = cur.Next
	}

	return cur.Val
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
func (this *MyLinkedList) AddAtHead(val int) {
	this.head.Next = &MyNode{Val: val, Next: this.head.Next}

	if this.tail == nil {
		this.tail = this.head.Next
	}

	this.len++
}

/** Append a node of value val to the last element of the linked list. */
func (this *MyLinkedList) AddAtTail(val int) {
	if this.tail == nil {
		this.AddAtHead(val)
		return
	}
	this.tail.Next = &MyNode{Val: val, Next: nil}
	this.tail = this.tail.Next
	this.len++
}

/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index >= this.len+1 {
		return
	}

	if index == this.len {
		this.AddAtTail(val)
		return
	}

	cur := this.head
	for i := 0; i < index; i++ {
		cur = cur.Next
	}

	cur.Next = &MyNode{Val: val, Next: cur.Next}

	this.len++
}

/** Delete the index-th node in the linked list, if the index is valid. */
func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index >= this.len {
		return
	}

	cur := this.head
	for i := 0; i < index; i++ {
		cur = cur.Next
	}

	cur.Next = cur.Next.Next

	if index == this.len-1 {
		this.tail = cur
	}

	this.len--
}

//59 / 59 test cases passed.
// Status: Accepted
// Runtime: 24 ms
// Memory Usage: 6.5 MB
