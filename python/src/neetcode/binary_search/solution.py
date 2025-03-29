#!/usr/bin/env python3
# https://neetcode.io/problems/binary-search


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        l = len(nums)
        if l == 0:
            return -1

        idx_mid = l // 2
        left, mid, right = nums[:idx_mid], nums[idx_mid], nums[idx_mid + 1:]
        if target == mid:
            return idx_mid
        elif target < mid:
            return self.search(left, target)
        else:
            res = self.search(right, target)
            if res == -1:
                return -1
            else:
                return idx_mid + 1 + res


if __name__ == "__main__":
    from input import NUMS, TARGET

    res = Solution().search(NUMS, TARGET)
    print(res)
