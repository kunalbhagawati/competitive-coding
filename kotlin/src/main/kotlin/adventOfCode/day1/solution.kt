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
 */
package me.kunalbhagawati.adventOfCode.day1

import java.io.File


fun compute(input: String): Int =
    input.fold(0) { acc: Int, c: Char ->
        c.toString().let {
            if (it == "(") {
                acc + 1
            } else if (it == ")") {
                acc - 1
            } else throw IllegalArgumentException("Character must be `(` or `)`. Found $it")
        }
    }


fun main(args: Array<String>) {
    val fileName = "src/main/resources/adventOfCode/day1/input.txt"

    val reader = File(fileName).absoluteFile.bufferedReader()

    val input = reader.use { it.readText() }

    compute(input.trim()).also { println(it) }
}
