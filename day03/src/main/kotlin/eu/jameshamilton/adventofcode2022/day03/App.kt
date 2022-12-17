package eu.jameshamilton.adventofcode2022.day03


fun main() {
    val input = parseInput(object {}.javaClass.getResource("/input.txt").readText())

    println(part1(input))
    println(part2(input))
}

typealias Compartment = List<Char>
data class Rucksack(val compartment1: Compartment, val compartment2: Compartment) {
    val contents = compartment1 + compartment2
}

data class Group(val rucksacks: List<Rucksack>) {
    val badge = rucksacks
        .map { it.contents.toSet() }
        .reduce { acc, chars ->  acc.intersect(chars) }
        .single()
}

fun parseInput(input: String): List<Rucksack> = input
    .split("\n")
    .map {
        val half = it.length / 2
        val left = it.substring(0, half)
        val right = it.substring(half, it.length)
        Rucksack(left.toList(), right.toList())
    }

fun part1(rucksacks: List<Rucksack>): Int = rucksacks
    .map { it.compartment1.toSet().intersect(it.compartment2.toSet()) }
    .map { it.single() }
    .sumOf { it.priority }

fun part2(rucksacks: List<Rucksack>): Int = rucksacks
    .windowed(3, 3)
    .map { Group(it) }
    .sumOf { it.badge.priority }

val Char.priority: Int
    get() = when (this) {
        in 'A'..'Z' -> this - 'A' + 27
        in 'a'..'z' -> this - 'a' + 1
        else -> 0
    }