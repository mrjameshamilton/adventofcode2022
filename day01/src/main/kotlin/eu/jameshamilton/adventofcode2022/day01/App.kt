package eu.jameshamilton.adventofcode2022.day01

import eu.jameshamilton.adventofcode2022.utilities.Elf
import eu.jameshamilton.adventofcode2022.utilities.split


fun main() {
    val input = object {}.javaClass.getResource("/input.txt").readText()
    val elfs = parseInput(input)
    println(part1(elfs))
    println(part2(elfs))
}

fun parseInput(input: String): List<Elf> = input
    .split("\n")
    .split { it.isBlank() }
    .map { Elf(it.sumOf { it.toInt() }) }

fun part1(elfs: List<Elf>): Int = elfs.maxBy { it.calories }.calories
fun part2(elfs: List<Elf>): Int = elfs.sortedByDescending { it.calories }.take(3).sumOf { it.calories }
