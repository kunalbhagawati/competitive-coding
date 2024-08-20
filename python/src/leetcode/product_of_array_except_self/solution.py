#!/usr/bin/env python3
# https://leetcode.com/problems/product-of-array-except-self/description/

from functools import reduce
from inputs import inp


class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        len_arr = len(nums)

        prefix_arr = reduce(lambda acc, x: acc + [(acc[-1] * x)], nums, [1])
        del prefix_arr[-1]

        suffix_arr = reduce(lambda acc, x: acc + [(acc[-1] * x)], nums[::-1], [1])
        del suffix_arr[-1]
        suffix_arr = suffix_arr[::-1]

        return [prefix_arr[idx] * suffix_arr[idx] for idx in range(len_arr)]


if __name__ == "__main__":
    res = Solution().productExceptSelf(nums=inp)
    print(res)
