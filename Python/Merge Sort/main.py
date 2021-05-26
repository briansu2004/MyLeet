"""
https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2868/

Merge Sort
"""


def merge_sort(nums):
    # bottom cases: empty or list of a single element.
    if len(nums) <= 1:
        return nums

    pivot = int(len(nums) / 2)
    left_list = merge_sort(nums[0:pivot])
    right_list = merge_sort(nums[pivot:])
    return merge(left_list, right_list)


def merge(left_list, right_list):
    left_cursor = right_cursor = 0
    ret = []
    while left_cursor < len(left_list) and right_cursor < len(right_list):
        if left_list[left_cursor] < right_list[right_cursor]:
            ret.append(left_list[left_cursor])
            left_cursor += 1
        else:
            ret.append(right_list[right_cursor])
            right_cursor += 1

    # append what is remained in either of the lists
    ret.extend(left_list[left_cursor:])
    ret.extend(right_list[right_cursor:])

    return ret


if __name__ == "__main__":
    l1 = [1, 4, 8, 9]
    l2 = [-1, 0, 1, 2, 7, 9]
    print("merge({0} and {1}) is: {2}".format(l1, l2, merge(l1, l2)))
