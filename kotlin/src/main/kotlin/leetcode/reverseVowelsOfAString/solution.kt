/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * ---
 *
 * 345. Reverse Vowels of a String
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * > Input: s = "IceCreAm"
 * > Output: "AceCreIm"
 */
package me.kunalbhagawati.leetcode.reverseVowelsOfAString

class Solution {
    companion object {
        val VOWELS =
            listOf('a', 'e', 'i', 'o', 'u').fold(mutableListOf()) { acc: MutableList<Char>, c: Char ->
                acc.add(c)
                acc.add(c.uppercaseChar())
                acc
            }
    }

    fun reverseVowels(s: String): String {
        val vowels = mutableListOf<Char>()
        val indexes = mutableListOf<Int>()

        s.forEachIndexed { index, c ->
            if (c in VOWELS) {
                vowels.add(0, c)
                indexes.add(index)
            }
        }

        if (indexes.isEmpty()) return s

        return s
            .mapIndexed { index, c ->
                if (indexes.isEmpty()) {
                    return@mapIndexed c
                }
                val idxToCheck = indexes.first()
                if (index == idxToCheck) {
                    vowels.removeFirst().also { indexes.removeFirst() }
                } else {
                    c
                }
            }.joinToString("")
    }
}

fun main(args: Array<String>) {
    val n = readlnOrNull()?.trim() ?: throw RuntimeException("Must pass a input")

    Solution().reverseVowels(n).also(::println)
}
