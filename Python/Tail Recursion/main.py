"""
https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2374/
Tail Recursion

Tail recursion is a recursion where the recursive call is the final instruction in the recursion function. And there should be only one recursive call in the function.
"""

from typing import List


def sum_non_tail_recursion(ls):
    """
    :type ls: List[int]
    :rtype: int, the sum of the input list.
    """
    if len(ls) == 0:
        return 0
    
    # not a tail recursion because it does some computation after the recursive call returned.
    return ls[0] + sum_non_tail_recursion(ls[1:])


def sum_tail_recursion(ls):
    """
    :type ls: List[int]
    :rtype: int, the sum of the input list.
    """
    def helper(ls, acc):
        if len(ls) == 0:
            return acc
        # this is a tail recursion because the final instruction is a recursive call.
        return helper(ls[1:], ls[0] + acc)
    
    return helper(ls, 0)

if __name__ == "__main__":
    ls = [1, 2, 3, 4, 5]
    print("sum_tail_recursion({0}): {1}".format(ls, int(sum_tail_recursion(ls))))
