/**
 * https://adventofcode.com/2015/day/1
 *
 * ---
 *
 * Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0)
 * and then follows the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ),
 * means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 *
 * (()) and ()() both result in floor 0.
 * ((( and (()(()( both result in floor 3.
 * ))((((( also results in floor 3.
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3.
 *
 * To what floor do the instructions take Santa?
 *
 * ---
 *
 * --- Part Two ---
 * Now, given the same instructions, find the position of the first character that causes him to enter the basement (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.
 *
 * For example:
 *
 * ) causes him to enter the basement at character position 1.
 * ()()) causes him to enter the basement at character position 5.
 * What is the position of the character that causes Santa to first enter the basement?
 */
package me.kunalbhagawati.adventOfCode.day1

import java.io.File


fun solve_pt_1(input: String): Int =
    input.fold(0) { acc: Int, c: Char ->
        c.toString().let {
            if (it == "(") {
                acc + 1
            } else if (it == ")") {
                acc - 1
            } else throw IllegalArgumentException("Character must be `(` or `)`. Found $it")
        }
    }

fun solve_pt_2(input: String): Int? {
    var flr = 0

    input.forEachIndexed { idx: Int, c: Char ->
        c.toString().let {
            if (it == "(") {
                flr += 1
            } else if (it == ")") {
                flr -= 1
            } else throw IllegalArgumentException("Character must be `(` or `)`. Found $it")
        }

        if (flr == -1) return idx + 1
    }

    return null
}


fun main(args: Array<String>) {
    val fileName = "src/main/resources/adventOfCode/day1/input.txt"

    val reader = File(fileName).absoluteFile.bufferedReader()

    val input = reader.use { it.readText().trim() }

    solve_pt_1(input).also(::println)
    solve_pt_2(input).also(::println)
}
