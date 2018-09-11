import kotlin.math.max

/**
 * @author dong on 2018/09/10.
 */

/**
 *   0 A G C A T C
 * 0 0 0 0 0 0 0 0
 * G 0 0 1 1 1 1 1
 * A 0 1 1 1 2 2 2
 * C 0 1 1 2 2 2 3
 *
 * @return longest common subsequence length
 */
fun longestCommonSubsequence(wordA: String, wordB: String): Int {
    val grid: Array<IntArray> = Array(wordA.length + 1, { IntArray(wordB.length + 1, { 0 }) })

    var longestLength = 0
    for (i in 1..wordA.length) {
        for (j in 1..wordB.length) {
            if (wordA[i - 1] == wordB[j - 1]) {
                grid[i][j] = grid[i - 1][j - 1] + 1
                if (longestLength < grid[i][j]) {
                    longestLength = grid[i][j]
                }
            } else {
                grid[i][j] = max(grid[i - 1][j], grid[i][j - 1])
            }
        }
    }
    return longestLength
}

fun main(args: Array<String>) {
    println(longestCommonSubsequence("AGCATC", "GAC"))
}
