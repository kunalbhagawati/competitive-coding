# https://leetcode.com/problems/kth-largest-element-in-an-array/
import heapq


class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        _heap = []
        for num in nums:
            if len(_heap) < k:
                heapq.heappush(_heap, num)
            elif num > _heap[0]:
                heapq.heappushpop(_heap, num)
        return _heap[0]

if __name__ == "__main__":
    from .inputs import inp
    r = Solution().findKthLargest(inp[0], inp[1])
    print(r)
