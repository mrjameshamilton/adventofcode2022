package eu.jameshamilton.adventofcode2022.day06


fun main() {
    val input = parseInput(object {}.javaClass.getResource("/input.txt").readText())
    println(part1(input))
    println(part2(input))
}

fun parseInput(string: String): String = string

fun part1(input: String): Int = calculate(input, windowSize = 4)
fun part2(input: String): Int = calculate(input, windowSize = 14)

private fun calculate(input: String, windowSize: Int): Int {
    input.toList().windowed(windowSize).withIndex().forEach { (index, chars) ->
        if (chars.distinct().count() == windowSize) return index + windowSize
    }
    return 0
}
