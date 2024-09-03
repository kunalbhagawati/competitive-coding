#!/usr/bin/env python3

"""
https://adventofcode.com/2015/day/3/

--- Day 3: Perfectly Spherical Houses in a Vacuum ---
Santa is delivering presents to an infinite two-dimensional grid of houses.

He begins by delivering a present to the house at his starting location,
and then an elf at the North Pole calls him via radio and tells him where to move next.
Moves are always exactly one house to the north (^), south (v), east (>), or west (<).
After each move, he delivers another present to the house at his new location.

However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off,
and Santa ends up visiting some houses more than once. How many houses receive at least one present?

For example:

> delivers presents to 2 houses: one at the starting location, and one to the east.
^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
"""

from collections import Counter
from os.path import dirname, abspath
from pathlib import Path


def solve_pt_1(input: str):
    pos = [0, 0]

    visit_counter = Counter()
    visit_counter[tuple(pos)] += 1

    for idx, c in enumerate(input):
        if c == "^":  # north
            pos = (pos[0], pos[1] + 1)  # increase y
        elif c == "v":  # south
            pos = (pos[0], pos[1] - 1)  # decrease y
        elif c == ">":  # east
            pos = (pos[0] + 1, pos[1])  # increase x
        elif c == "<":  # west
            pos = (pos[0] - 1, pos[1])  # decrease x
        else:
            raise RuntimeError(f"Illegal direction `{c}` at position `{idx}`.")

        visit_counter[tuple(pos)] += 1

    return len(visit_counter.keys())


def solve_pt_2(input: str):
    positions = [
        [0, 0],
        [0, 0],
    ]

    visit_counter = Counter()
    visit_counter[tuple(positions[0])] += 1  # set santa
    visit_counter[tuple(positions[1])] += 1  # set robosanta

    for idx, c in enumerate(input):
        pos_idx = idx % 2

        if c == "^":  # north
            positions[pos_idx] = (positions[pos_idx][0], positions[pos_idx][1] + 1)  # increase y
        elif c == "v":  # south
            positions[pos_idx] = (positions[pos_idx][0], positions[pos_idx][1] - 1)  # decrease y
        elif c == ">":  # east
            positions[pos_idx] = (positions[pos_idx][0] + 1, positions[pos_idx][1])  # increase x
        elif c == "<":  # west
            positions[pos_idx] = (positions[pos_idx][0] - 1, positions[pos_idx][1])  # decrease x
        else:
            raise RuntimeError(f"Illegal direction `{c}` at position `{idx}`.")

        visit_counter[tuple(positions[pos_idx])] += 1

    return len(visit_counter.keys())


if __name__ == "__main__":
    dir_name = Path(dirname(abspath(__file__)))
    filename = dir_name / "input.txt"

    with open(filename.absolute(), "r") as f:
        data = f.read()
    input = data.strip()

    res_1 = solve_pt_1(input)
    res_2 = solve_pt_2(input)
    print(res_1)
    print(res_2)
