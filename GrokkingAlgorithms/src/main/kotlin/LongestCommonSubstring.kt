/**
 * @author dong on 2018/09/09.
 */

/**
 *   0 h i s h
 * 0 0 0 0 0 0
 * f 0 0 0 0 0
 * i 0 0 1 0 0
 * s 0 0 0 2 0
 * h 0 0 0 0 3
 *
 * @return longest common substring length
 */
fun longestCommonSubstring(wordA: String, wordB: String): Int {
    val grid: Array<Array<Int>> = Array(wordA.length + 1) { Array(wordB.length + 1) { 0 } }

    var longestLength = 0
    for (i in 1..wordA.length) {
        for (j in 1..wordB.length) {
            if (wordA[i - 1] == wordB[j - 1]) {
                grid[i][j] = grid[i - 1][j - 1] + 1
                if (longestLength < grid[i][j]) {
                    longestLength = grid[i][j]
                }
            } else {
                grid[i][j] = 0
            }
        }
    }
    return longestLength
}

fun main(args: Array<String>) {
    println(longestCommonSubstring("hish", "fish"))
    println(longestCommonSubstring("hish", "vista"))
}
