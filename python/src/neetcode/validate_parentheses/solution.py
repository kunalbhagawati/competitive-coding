#!/usr/bin/env python3
from collections import deque


# https://neetcode.io/problems/validate-parentheses


class Solution:
    def isValid(self, s: str) -> bool:
        m = {
            ")": "(",
            "}": "{",
            "]": "[",
        }

        dq = deque()
        for c in s:
            if c in ["(", "{", "["]:
                dq.append(c)
            else:
                try:
                    el = dq.pop()
                    if m[c] != el:
                        return False
                except IndexError:
                    return False

        return len(dq) == 0


if __name__ == "__main__":
    from python.src.neetcode.validate_parentheses.input import S

    res = Solution().isValid(S)

    print(res)
