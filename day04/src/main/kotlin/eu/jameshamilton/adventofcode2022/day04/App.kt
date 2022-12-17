package eu.jameshamilton.adventofcode2022.day04


fun main() {
    val input = parseInput(object {}.javaClass.getResource("/input.txt").readText())

    println(part1(input))
    println(part2(input))
}

fun parseInput(string: String): List<Pair<IntRange, IntRange>> {
    return string.split("\n")
        .map {
            val (ab, cd) = it.split(",")
            val (a, b) = ab.split("-")
            val (c, d) = cd.split("-")
            Pair(IntRange(a.toInt(), b.toInt()), IntRange(c.toInt(), d.toInt()))
        }
}

fun part1(pairs: List<Pair<IntRange, IntRange>>): Int =
    pairs.count { it.second in it.first || it.first in it.second }

fun part2(pairs: List<Pair<IntRange, IntRange>>): Int =
    pairs.count { it.first overlaps it.second }

operator fun IntRange.contains(other: IntRange): Boolean =
    this.first >= other.first && this.last <= other.last
infix fun IntRange.overlaps(other: IntRange): Boolean =
    this.intersect(other).isNotEmpty()
