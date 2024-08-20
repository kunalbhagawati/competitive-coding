#!/usr/bin/env python3
from functools import reduce


class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        def p(x: int, y: int):
            return x * y

        prefix_arr = reduce(lambda acc, x: acc + [(acc[-1] * x)], nums, [1])
        del prefix_arr[-1]
        
        suffix_arr = reduce(lambda acc, x: acc + [(acc[-1] * x)], nums[::-1], [1])
        del suffix_arr[-1]
        suffix_arr = suffix_arr[::-1]

        print(prefix_arr, suffix_arr)

        def s(idx: int):
            return prefix_arr[idx] * suffix_arr[idx]

        return [s(idx) for idx, _ in enumerate(nums)]


if __name__ == "__main__":
    from .inputs import input
    res = Solution().productExceptSelf(nums=input)
    print(res)
