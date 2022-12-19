package eu.jameshamilton.adventofcode2022.day08


fun main() {
    val input = parseInput(object {}.javaClass.getResource("/input.txt").readText())
    println(part1(input))
    println(part2(input))
}

fun parseInput(input: String): Grid {
    lateinit var grid: Grid
    input.lines().forEachIndexed { x, line ->
        if (x == 0) grid = Grid(line.length)

        line.forEachIndexed { y, c -> grid.set(x, y, c.digitToInt()) }
    }
    return grid
}

fun part1(input: Grid): Int = input.countVisible()
fun part2(input: Grid): Int = input.highestScore()

data class Grid(val size: Int, private val grid: Array<Array<Int>> = Array(size) { Array(size) { 0 } }) {

    fun set(x: Int, y: Int, value: Int) = grid[x].set(y, value)
    fun get(x: Int, y: Int) = grid[x][y]

    private fun visible(x: Int, y: Int): Boolean {
        val height = grid[x][y]
        var visible = true
        for (i in x - 1 downTo 0) {
            visible = visible && (height > grid[i][y])
        }
        if (visible) return true
        visible = true
        for (i in x + 1 until size) {
            visible = visible && (height > grid[i][y])
        }
        if (visible) return true
        visible = true
        for (i in y - 1 downTo 0) {
            visible = visible && (height > grid[x][i])
        }
        if (visible) return true
        visible = true
        for (i in y + 1 until size) {
            visible = visible && (height > grid[x][i])
        }
        return visible
    }

    private fun score(x: Int, y: Int): Int {
        if (x == 0 || y == 0 || x == size - 1 || y == size - 1) return 0

        var score = 1
        val height = grid[x][y]

        for ((index, i) in (x - 1 downTo 0).withIndex()) {
            if (grid[i][y] >= height || i == 0) {
                score *= (index + 1)
                break
            }
        }

        for ((index, i) in (x + 1 until size).withIndex()) {
            if (grid[i][y] >= height || i == size - 1) {
                score *= (index + 1)
                break
            }
        }

        for ((index, i) in (y - 1 downTo 0).withIndex()) {
            if (grid[x][i] >= height || i == 0) {
                score *= (index + 1)
                break
            }
        }

        for ((index, i) in (y + 1 until size).withIndex()) {
            if (grid[x][i] >= height || i == size - 1) {
                score *= (index + 1)
                break
            }
        }

        return score
    }

    fun countVisible(): Int {
        var count = 0
        for (x in 0 until size) {
            for (y in 0 until size) {
                if (visible(x, y)) count++
            }
        }
        return count
    }

    fun highestScore(): Int {
        var score = 0
        for (x in 0 until size) {
            for (y in 0 until size) {
                score = score.coerceAtLeast(score(x, y))
            }
        }
        return score
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Grid

        if (size != other.size) return false
        if (!grid.contentDeepEquals(other.grid)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = size
        result = 31 * result + grid.contentDeepHashCode()
        return result
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        for (x in 0 until size) {
            for (y in 0 until size) {
                stringBuilder.append(get(x, y)).append("[${visible(x, y)}]")
            }
            stringBuilder.appendLine()
        }
        return stringBuilder.toString()
    }
}