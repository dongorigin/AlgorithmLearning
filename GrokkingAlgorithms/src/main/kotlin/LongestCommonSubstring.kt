/**
 * @author dong on 2018/09/09.
 */

/**
 * a=hish b=fish
 *
 *   h i s h
 * f 0 0 0 0
 * i 0 1 0 0
 * s 0 0 2 0
 * h 0 0 0 3
 *
 * @return longest common substring length
 */
fun longestCommonSubstring(wordA: String, wordB: String): Int {
    val grid: Array<Array<Int>> = Array(wordA.length) { Array(wordB.length) { 0 } }

    var longestLength = 0
    for (i in 0 until wordA.length) {
        for (j in 0 until wordB.length) {
            if (wordA[i] == wordB[j]) {
                val previousLength = if (i > 0 && j > 0) {
                    grid[i - 1][j - 1]
                } else {
                    0
                }
                val newLength = previousLength + 1
                grid[i][j] = newLength
                if (longestLength < newLength) {
                    longestLength = newLength
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
