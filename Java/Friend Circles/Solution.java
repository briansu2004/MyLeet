/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/846/
 * Friend Circles

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.

Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

Constraints:
1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 * 
 * 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
   // 03
   public int findCircleNum(int[][] isConnected) {
      int n = isConnected.length;
      int[] arr = new int[n + 1];
      for (int i = 1; i <= n; i++) {
         arr[i] = i;
      }

      for (int i = 0; i < n; i++) {
         for (int j = i + 1; j < n; j++) {
            if (isConnected[i][j] == 1) {
               union(arr, i + 1, j + 1);
            }
         }
      }

      HashSet<Integer> roots = new HashSet<>();

      for (int i = 1; i <= n; i++) {
         roots.add(root(arr, i));
      }

      return roots.size();
   }

   private int root(int[] arr, int ind) {
      ArrayList<Integer> indices = new ArrayList<>();
      indices.add(ind);
      while (arr[ind] != ind) {
         indices.add(arr[ind]);
         arr[ind] = arr[arr[ind]];
         ind = arr[ind];
      }

      for (int index : indices) {
         arr[index] = ind;
      }

      return ind;
   }

   private void union(int[] arr, int a, int b) {
      int root1 = root(arr, a);
      int root2 = root(arr, b);
      arr[root1] = root2;
   }
   
   //02
   public void dfs(int[][] M, int[] visited, int i) {
      for (int j = 0; j < M.length; j++) {
         if (M[i][j] == 1 && visited[j] == 0) {
            visited[j] = 1;
            dfs(M, visited, j);
         }
      }
   }

   public int findCircleNum2(int[][] M) {
      int[] visited = new int[M.length];
      int count = 0;
      for (int i = 0; i < M.length; i++) {
         if (visited[i] == 0) {
            dfs(M, visited, i);
            count++;
         }
      }
      return count;
   }

   // 01
   class UnionFind {
      private int count = 0;
      private int[] parent, rank;

      public UnionFind(int n) {
         count = n;
         parent = new int[n];
         rank = new int[n];
         for (int i = 0; i < n; i++) {
            parent[i] = i;
         }
      }

      public int find(int p) {
         while (p != parent[p]) {
            parent[p] = parent[parent[p]]; // path compression by halving
            p = parent[p];
         }
         return p;
      }

      public void union(int p, int q) {
         int rootP = find(p);
         int rootQ = find(q);
         if (rootP == rootQ)
            return;
         if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
         } else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
               rank[rootP]++;
            }
         }
         count--;
      }

      public int count() {
         return count;
      }
   }

   public int findCircleNum1(int[][] M) {
      int n = M.length;
      UnionFind uf = new UnionFind(n);
      for (int i = 0; i < n - 1; i++) {
         for (int j = i + 1; j < n; j++) {
            if (M[i][j] == 1)
               uf.union(i, j);
         }
      }
      return uf.count();
   }

   public void test(int[][] isConnected, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(
            String.format("findCircleNum(%s): %s", Arrays.deepToString(isConnected), findCircleNum(isConnected)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
      int expect = 2;
      sol.test(isConnected, expect);

      isConnected = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
      expect = 3;
      sol.test(isConnected, expect);

   }
}

/*
01
113 / 113 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 51.5 MB
*/

/*
02
113 / 113 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 51.6 MB
*/

/*
03
113 / 113 test cases passed.
Status: Accepted
Runtime: 8 ms
Memory Usage: 52.2 MB
*/
