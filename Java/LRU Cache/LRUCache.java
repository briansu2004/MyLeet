import java.util.HashMap;
import java.util.Map;

class LRUCache {
    int size;
    LinkedListt ll;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.ll = new LinkedListt();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ll.moveToHead(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            ll.moveToHead(map.get(key));
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            ll.addToHead(node);

            if (map.size() > size) {
                map.remove(ll.removeFromTail().key);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedListt getLl() {
        return ll;
    }

    public void setLl(LinkedListt ll) {
        this.ll = ll;
    }

    public Map<Integer, Node> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Node> map) {
        this.map = map;
    }

    public String toString() {
        return "size: " + size + "; ll: " + ll + "; map: " + map;
    }

}

class LinkedListt {
    Node head;
    Node tail;

    public LinkedListt() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.right = tail;
        tail.left = head;
    }

    public void addToHead(Node node) {
        head.right.left = node;
        node.right = head.right;
        node.left = head;
        head.right = node;
    }

    public Node removeFromTail() {
        Node node = tail.left;
        tail.left = node.left;
        node.left.right = tail;
        node.right = null;
        node.left = null;
        return node;
    }

    public void moveToHead(Node node) {
        if (node.left != head) {
            node.left.right = node.right;
            node.right.left = node.left;
            node.right = null;
            node.left = null;

            addToHead(node);
        }
    }
}

class Node {
    int key;
    int val;
    Node left;
    Node right;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/*
02
21 / 21 test cases passed.
Status: Accepted
Runtime: 50 ms
Memory Usage: 112.6 MB
*/
