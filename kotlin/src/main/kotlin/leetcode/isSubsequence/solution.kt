/**
 * https://leetcode.com/problems/is-subsequence/description/
 *
 * ---
 * 392. Is Subsequence
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * > Input: s = "abc", t = "ahbgdc"
 * > Output: true
 */
package me.kunalbhagawati.leetcode.isSubsequence

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true

        var idxMatcher = 0
        var idxSubsStr = 0

        while ((idxMatcher < t.length) && (idxSubsStr < s.length)) {
            if (t[idxMatcher] == s[idxSubsStr]) {
                idxSubsStr++
            }
            idxMatcher++
        }

        return idxSubsStr == s.length
    }
}

fun main(args: Array<String>) {
    val inputs =
        listOf(
            Triple("abc", "ahbgdc", true),
            Triple("abc", "pahbgdce", true),
            Triple("axc", "ahbgdc", false),
            Triple("", "ahbgdc", true),
            Triple("b", "c", false),
            Triple("b", "cx", false),
            Triple("bd", "cx", false),
            Triple("acb", "ahbgdc", false),
        )

    inputs.forEach { inp ->
        Solution().isSubsequence(inp.first, inp.second).also {
            val exp = if (it == inp.third) "+" else "x"
            println("Res: $it  | $exp")
        }
    }
}
