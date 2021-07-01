import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    private Queue<Integer> larger = new PriorityQueue<Integer>();
    private Queue<Integer> smaller = new PriorityQueue<Integer>((a, b) -> (b - a));

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    // Always keeping larger.size() >= smaller.size()
    public void addNum(int num) {
        // Insert into larger queue at the first time.
        if (larger.size() == 0) {
            larger.add(num);
        } else if (larger.size() == smaller.size()) {
            smaller.add(num);
            larger.add(smaller.poll());
        } else {
            larger.add(num);
            smaller.add(larger.poll());
        }
    }

    public double findMedian() {
        return this.larger.size() > this.smaller.size() ? this.larger.peek()
                : (double) (this.larger.peek() + this.smaller.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

 /*
01
18 / 18 test cases passed.
Status: Accepted
Runtime: 50 ms
Memory Usage: 50.4 MB
 */

