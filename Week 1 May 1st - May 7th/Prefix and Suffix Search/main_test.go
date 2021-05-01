package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestFlatten(t *testing.T) {
	var n *Node

	assert.Nil(t, flatten(n))

	// n = &Node{1, nil, nil, nil}
	// n.Next = &Node{2, nil, nil, nil}
	// n.Next.Prev = n
	// n.Next.Next = &Node{3, nil, nil, nil}
	// assert.Equal(t, flatten(n), &Node{1, nil, &Node{3, nil, &Node{2, nil, nil, nil}, nil}, nil})
}
