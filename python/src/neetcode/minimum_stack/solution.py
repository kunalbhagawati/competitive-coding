#!/usr/bin/env python3
# https://neetcode.io/problems/minimum-stack


class MinStack:

    def __init__(self):
        self._stack = []
        self._min_stack = []

    def push(self, val: int) -> None:
        self._stack.append(val)
        try:
            m = min(val, self._min_stack[-1])
        except IndexError:
            m = val
        self._min_stack.append(m)

    def pop(self) -> None:
        self._stack.pop()
        self._min_stack.pop()

    def top(self) -> int:
        return self._stack[-1]

    def getMin(self) -> int:
        return self._min_stack[-1]

    def __repr__(self):
        return f"""
STACK: {self._stack}
MIN: {self._min_stack}
"""
