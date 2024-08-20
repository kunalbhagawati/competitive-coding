#!/usr/bin/env python3
# https://leetcode.com/problems/string-compression/

from inputs import inp


class Solution:
    def compress(self, chars: list[str]) -> int:
        len_chars = len(chars)
        new_chars = [chars[0]]
        count = 1

        def append_count(c: int):
            new_chars.extend(list(str(c)))

        for idx_minus_one, c in enumerate(chars[1:]):
            if c == chars[idx_minus_one]:
                count += 1
            else:
                if count > 1:
                    append_count(count)
                count = 1
                new_chars.append(c)

            if idx_minus_one + 2 == len_chars:  # end of iteration
                if count > 1:
                    append_count(count)

                count = 1

        # Replace char array
        final_idx = 0
        for idx, c in enumerate(new_chars):
            chars[idx] = c
            final_idx = idx

        # del chars[final_idx + 1:]

        return final_idx + 1


if __name__ == "__main__":
    res = Solution().compress(inp)
    print(res)
    print(inp)
