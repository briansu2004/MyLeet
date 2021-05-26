import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

class MyHashSet {

    BSTNode[] elements; // my elements are stored in binary trees!
    int size;
    final static double LOAD_FACTOR = 0.7;
    final static int INITIAL_SIZE = 1; // 100 was picked totally random! No thoughts behind it.

    public MyHashSet() {
        elements = (BSTNode[]) new BSTNode[INITIAL_SIZE];
        size = 0;
    }

    public void add(int key) {
        int h = hash(key);
        BSTNode newNode = new BSTNode(key);
        if (elements[h] == null) {
            elements[h] = newNode;
        } else {
            elements[h].add(newNode);
        }
        size++;
        if (size > (int) (LOAD_FACTOR * elements.length)) {
            rehash();
        }
    }

    public void remove(int key) {
        // for more efficiency it does not call contains() before removing an item
        // it rather checks if it exists while removing
        int h = hash(key);
        if (elements[h] != null)
            elements[h] = elements[h].remove(key);
        size--;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        if (elements[h] != null)
            return elements[h].contains(key);
        return false;
    }

    private int hash(int key) {
        return key % elements.length;
    }

    private void rehash() {
        BSTNode[] newElements = new BSTNode[elements.length * 2];
        BSTNode[] old = elements;
        elements = newElements;
        for (BSTNode n : old) {
            if (n != null) {
                LinkedList<BSTNode> list = n.allTreeNodes();
                ListIterator it = list.listIterator();
                while (it.hasNext()) {
                    BSTNode node = (BSTNode) it.next();
                    add(node.data);
                }
            }
        }
    }

    // Build in binary search tree node to take care of collisions, even long ones
    // with ologn()
    private class BSTNode {
        public int data;
        private BSTNode right;
        private BSTNode left;

        protected BSTNode(int data) {
            this.data = data;
        }

        protected void add(BSTNode node) {
            // The add function is recursive, since there are as many as log(n) function
            // calls
            if (node.data > this.data) {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            } else if (node.data < this.data) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            }
        }

        protected LinkedList<BSTNode> allTreeNodes() {
            // This function is iterative since there is n function calls,
            // although the size of the stack can get as big as h~log(n)
            // The reason linkedList is used here is that we just
            // need to iterate over it once for rehashing!
            Queue<BSTNode> q = new LinkedList<>();
            q.add(this);
            LinkedList<BSTNode> list = new LinkedList<>();
            while (!q.isEmpty()) {
                BSTNode node = q.poll();
                list.add(node);
                if (node.right != null)
                    q.add(node.right);
                if (node.left != null)
                    q.add(node.left);
            }
            return list;
        }

        protected boolean contains(int data) {
            if (this.data == data)
                return true;
            if (this.data > data && this.left != null)
                return this.left.contains(data);
            if (this.data < data && this.right != null)
                return this.right.contains(data);
            return false;
        }

        protected BSTNode remove(int d) {
            if (this.data == d) { // what we wanna remove is found

                if (this.right == null && this.left == null) // if leaf remove
                    return null;

                if (this.right == null || this.left == null) // if one child return that one child!
                    return (this.left != null) ? this.left : this.right;

                this.data = this.left.findMax().data; // substitude with the rightmost left successor
                this.left.remove(this.data);
            }

            if (this.data > d && this.left != null)
                this.left = this.left.remove(d);

            if (this.data < d && this.right != null)
                this.right = this.right.remove(d);

            return this;
        }

        private BSTNode findMax() {
            BSTNode node = this;
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

    }

}
