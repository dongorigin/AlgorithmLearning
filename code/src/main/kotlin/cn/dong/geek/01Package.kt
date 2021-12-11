package cn.dong.geek

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.IsStableType
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import java.lang.Integer.max

/**
 * 我们有一个背包，背包总的承载重量是 [maxWeight] kg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。[itemWeights] 为 n 个物品的重量
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 *
 * @author dong on 2021/12/11.
 */
class Package(
    private val itemWeights: IntArray,
    private val maxWeight: Int,
) {
    fun findMax(): Int {
        return innerFindMax(maxWeight, 0)
    }

    /** [remainingWeight] 背包剩余负重，[index] 待装物品下标，返回物品总重量 */
    private fun innerFindMax(remainingWeight: Int, index: Int): Int {
        if (remainingWeight < 0) return 0
        if (index >= itemWeights.size) return maxWeight - remainingWeight
        return max(
            innerFindMax(remainingWeight - itemWeights[index], index + 1), // 装
            innerFindMax(remainingWeight, index + 1) // 不装
        )
    }
}

private class PackageTests : FunSpec({
    @IsStableType
    data class Case(
        val itemWeights: IntArray,
        val maxWeight: Int,
        val expectedMax: Int,
    )

    context("test find max") {
        withData(
            Case(intArrayOf(8, 4, 2), 1, 0),
            Case(intArrayOf(8, 4, 2), 3, 2),
            Case(intArrayOf(8, 4, 2), 10, 10),
            Case(intArrayOf(2, 4, 8), 10, 10)
        ) { (itemWeights, maxWeight, expectedMax) ->
            Package(itemWeights, maxWeight).findMax() shouldBe expectedMax
        }
    }
})
