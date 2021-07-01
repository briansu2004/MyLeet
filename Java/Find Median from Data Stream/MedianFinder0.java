import java.util.ArrayList;
import java.util.List;

class MedianFinder0 {
    private double median;
    private List<Integer> lst;
    private int cnt;

    /** initialize your data structure here. */
    public MedianFinder0() {
        lst = new ArrayList<Integer>();
        cnt = 0;
        median = 0;
    }
    
    public void addNum(int num) {
        median = (median * cnt + num) / (cnt + 1);
        cnt++;
        lst.add(num);
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

 /*
 Mine

 Wrong Answer 
 Input:
["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
[[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
Output:
[null,null,6.00000,null,8.00000,null,6.00000,null,6.00000,null,5.80000,null,4.83333,null,5.00000,null,4.75000,null,4.33333,null,3.90000,null,3.54545]
Expected:
[null,null,6.00000,null,8.00000,null,6.00000,null,6.00000,null,6.00000,null,5.50000,null,6.00000,nul
 */

