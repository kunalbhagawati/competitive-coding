#!/usr/bin/env python3
# https://neetcode.io/problems/is-palindrome
from input import inp


class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = "".join([i.lower() for i in s if i.isalnum()])

        if not s:
            return True

        l_ptr = 0
        r_ptr = len(s) - 1
        while l_ptr <= r_ptr:
            if s[l_ptr] != s[r_ptr]:
                return False
            l_ptr += 1
            r_ptr -= 1
        return True


if __name__ == "__main__":
    res = Solution().isPalindrome(inp)
    print(res)
    print(inp)
