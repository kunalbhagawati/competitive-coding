#!/usr/bin/env python3
# https://leetcode.com/problems/increasing-triplet-subsequence/
from inputs import inp


class Solution:
    def increasing_triplet(self, nums: list[int]) -> bool:
        _len = len(nums)
        if _len < 3:
            return False
    
        first = int("inf")
        second = int("inf")
        
        for n in nums:
            if n <= first:
                first = n
            elif n <= second:
                second = n
            else:
                return True
        
        return False


if __name__ == "__main__":
    res = Solution().increasing_triplet(nums=inp)
