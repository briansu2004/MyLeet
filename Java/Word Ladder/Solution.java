
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/842/
 * Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

Constraints:
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
   //03
   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Queue<String> q = new LinkedList<String>();

      q.add(beginWord);
      int elemsInLastLevel = 1;
      int elemsInCurrLevel = 0;
      int level = 0;
      boolean[] visited = new boolean[wordList.size()];
      for (int i = 0; i < wordList.size(); i++) {
         visited[i] = false;
      }
      // boolean didLastWordHit = false;
      while (q.size() != 0) {
         elemsInCurrLevel = 0;
         level++;
         for (int i = 0; i < elemsInLastLevel; i++) {
            String s = q.poll();
            int lp = 0;
            for (String j : wordList) {

               if (is1Diff(s, j) && !visited[lp]) {
                  if (j.equals(endWord)) {
                     return level + 1;
                  }
                  q.add(j);
                  visited[lp] = true;
                  // wordList.remove(j);
                  elemsInCurrLevel++;
               }
               lp++;
            }
         }

         elemsInLastLevel = elemsInCurrLevel;

      }
      return 0;

   }

   public boolean is1Diff(String a, String b) {
      int l = a.length();
      int diff = 0;
      for (int i = 0; i < l; i++) {
         if (a.charAt(i) != b.charAt(i))
            diff++;
      }
      return diff == 1;
   }

   //02
   public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
      Set<String> dicts = new HashSet<>(wordList);

      if (!dicts.contains(beginWord) && !dicts.contains(endWord))
         return 0;

      Queue<String> begin = new LinkedList<>();
      Queue<String> end = new LinkedList<>();

      Map<String, Integer> beginVisted = new HashMap<>();
      Map<String, Integer> endVisted = new HashMap<>();

      begin.add(beginWord);
      end.add(endWord);
      beginVisted.put(beginWord, 1);
      endVisted.put(endWord, 1);

      while (!begin.isEmpty() && !end.isEmpty()) {

         String beginCurr = begin.poll();
         String endCurr = end.poll();

         List<String> beginAdjacent = getAdjacent(beginCurr, dicts);
         List<String> endAdjacent = getAdjacent(endCurr, dicts);

         for (String beginString : beginAdjacent) {
            if (!beginVisted.containsKey(beginString)) {
               int beginDistance = beginVisted.get(beginCurr) + 1;
               if (endVisted.containsKey(beginString)) {
                  return endVisted.get(beginString) + beginDistance - 1;
               }
               beginVisted.put(beginString, beginDistance);
               begin.add(beginString);
            }
         }

         for (String endString : endAdjacent) {
            if (!endVisted.containsKey(endString)) {
               int endDistance = endVisted.get(endCurr) + 1;
               if (beginVisted.containsKey(endString)) {
                  return beginVisted.get(endString) + endDistance - 1;
               }
               endVisted.put(endString, endDistance);
               end.add(endString);
            }
         }

      }

      return 0;

   }

   private List<String> getAdjacent(String word, Set<String> dicts) {

      char[] chars = word.toCharArray();
      List<String> result = new ArrayList<>();

      for (int i = 0; i < chars.length; i++) {
         char origin = chars[i];
         for (char c = 'a'; c <= 'z'; c++) {
            if (c != origin) {
               chars[i] = c;
               String newWord = new String(chars);
               if (dicts.contains(newWord)) {
                  result.add(newWord);
               }
            }
         }
         chars[i] = origin;
      }

      return result;
   }

   // 01
   public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
      Map<String, String> nodeToParent = new HashMap<>(); // key: node, value: its parent(the node it is transformed
                                                          // from); Also acts like visited set for BFS.

      Set<String> wordSet = new HashSet<>(wordList);

      // Corner cases.
      if (!wordSet.contains(endWord)) {
         return 0;
      }

      Queue<String> queue = new LinkedList<>(); // Queue for BFS.
      queue.offer(beginWord);
      nodeToParent.put(beginWord, beginWord);
      int level = 1;
      while (!queue.isEmpty()) {
         int size = queue.size();
         for (int k = 0; k < size; k++) {
            String node = queue.poll();
            for (int i = 0; i < node.length(); i++) {
               char[] charArray = node.toCharArray();
               char curCh = charArray[i];
               for (char ch = 'a'; ch <= 'z'; ch++) {
                  if (ch != curCh) {
                     charArray[i] = ch;
                     String neighbour = new String(charArray);
                     if (neighbour.equals(endWord)) {
                        // To print path.
                        nodeToParent.put(neighbour, node);
                        printPath(endWord, nodeToParent);

                        return level + 1;
                     }
                     if (!nodeToParent.containsKey(neighbour) && wordSet.contains(neighbour)) {
                        nodeToParent.put(neighbour, node);
                        queue.offer(neighbour);
                     }
                  }
               }
            }
         }
         level++;
      }

      return 0;
   }

   public void printPath(String endWord, Map<String, String> nodeToParent) {
      Deque<String> deque = new ArrayDeque<>();
      String curWord = endWord;
      deque.push(curWord);
      while (!nodeToParent.get(curWord).equals(curWord)) {
         curWord = nodeToParent.get(curWord);
         deque.push(curWord);
      }
      while (!deque.isEmpty()) {
         System.out.print(deque.pop() + " ");
      }
   }

   public void test(String beginWord, String endWord, List<String> wordList, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("ladderLength(%s, %s, %s): %s", beginWord, endWord, wordList,
            ladderLength(beginWord, endWord, wordList)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      String beginWord = "hit";
      String endWord = "cog";
      List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
      // Set<String> wordList = new HashSet<String>();
      // wordList.add("hot");
      // wordList.add("dot");
      // wordList.add("dog");
      // wordList.add("lot");
      // wordList.add("log");
      // wordList.add("cog");
      int expect = 5;
      sol.test(beginWord, endWord, wordList, expect);

      beginWord = "hit";
      endWord = "cog";
      wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
      // wordList = new HashSet<String>();
      // wordList.add("hot");
      // wordList.add("dot");
      // wordList.add("dog");
      // wordList.add("lot");
      // wordList.add("log");
      expect = 0;
      sol.test(beginWord, endWord, wordList, expect);

   }
}

/*
01
49 / 49 test cases passed.
Status: Accepted
Runtime: 168 ms
Memory Usage: 109 MB
*/

/*
02
49 / 49 test cases passed.
Status: Accepted
Runtime: 27 ms
Memory Usage: 49.8 MB
Your runtime beats 91.19 % of java submissions.
*/

/*
03
49 / 49 test cases passed.
Status: Accepted
Runtime: 1215 ms
Memory Usage: 39 MB
Your memory usage beats 98.01 % of java submissions.
*/


