/**
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * ---
 *
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 * > Input: nums = [0,1,0,3,12]
 * > Output: [1,3,12,0,0]
 */
package me.kunalbhagawati.leetcode.moveZeroes

class Solution {
    fun moveZeroes(nums: IntArray) {
        if (nums.size <= 1) return

        var idxLeft = 0
        var idxRight = 0

        while (idxRight <= nums.size - 1) {
            if (idxLeft == idxRight) {
                idxRight++
                continue
            }

            when {
                nums[idxLeft] == 0 -> {
                    if (nums[idxRight] != 0) {
                        nums[idxLeft] = nums[idxRight]
                        nums[idxRight] = 0

                        idxLeft++
                    }
                    idxRight++
                }

                else -> idxLeft++
            }
        }
    }
}

fun main(args: Array<String>) {
    val inputs =
        listOf(
            arrayOf(0, 0, 1, 3, 12),
            arrayOf(0),
            arrayOf(2, 1),
            arrayOf(2, 1, 3),
            arrayOf(1, 0, 1),
            arrayOf(4, 2, 4, 0, 0, 3, 0, 5, 1, 0),
        ).map { it.toIntArray() }

    inputs.forEach { a ->
        Solution().moveZeroes(a).also { println(a.toList()) }
    }
}
