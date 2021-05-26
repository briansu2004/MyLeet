"""
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/
Minimum Index Sum of Two Lists

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Example 3:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger King","Tapioca Express","Shogun"]
Output: ["KFC","Burger King","Tapioca Express","Shogun"]
Example 4:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
Output: ["KFC","Burger King","Tapioca Express","Shogun"]
Example 5:
Input: list1 = ["KFC"], list2 = ["KFC"]
Output: ["KFC"]

Constraints:
1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] and list2[i] consist of spaces ' ' and English letters.
All the stings of list1 are unique.
All the stings of list2 are unique.
"""


class Solution(object):
    def findRestaurant(self, A, B):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        Aindex = {u: i for i, u in enumerate(A)}
        best, ans = 1e9, []

        for j, v in enumerate(B):
            i = Aindex.get(v, 1e9)
            if i + j < best:
                best = i + j
                ans = [v]
            elif i + j == best:
                ans.append(v)
        return ans

if __name__ == "__main__":
    sol = Solution()

    list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    list2 = ["Piatti", "The Grill at Torrey Pines",
             "Hungry Hunter Steakhouse", "Shogun"]
    print(f"list1:", list1)
    print(f"list2:", list2)
    print(f"findRestaurant(list1, list2):", sol.findRestaurant(list1, list2))


# 01
# 136 / 136 test cases passed.
# Status: Accepted
# Runtime: 216 ms
# Memory Usage: 14.1 MB
