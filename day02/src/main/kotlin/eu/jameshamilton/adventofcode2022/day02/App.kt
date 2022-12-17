package eu.jameshamilton.adventofcode2022.day02

import eu.jameshamilton.adventofcode2022.day02.Outcome.*
import eu.jameshamilton.adventofcode2022.day02.Shape.*

enum class Outcome { WIN, LOSE, DRAW }

enum class Shape(val value: Int) {
    ROCK(1), PAPER(2), SCISSORS(3);

    infix fun play(other: Shape): Outcome = when {
        this == other -> DRAW
        this == ROCK && other == SCISSORS -> WIN
        this == SCISSORS && other == PAPER -> WIN
        this == PAPER && other == ROCK -> WIN
        else -> LOSE
    }

}

data class Strategy(val opponent: Shape, val you: Shape) {
    val score = you.value + when (you play opponent) {
        LOSE -> 0
        WIN -> 6
        DRAW -> 3
    }
}


fun main() {
    val input = object {}.javaClass.getResource("/input.txt").readText()
    println(part1(input))
    println(part2(input))
}


fun parseInput(input: String, bParser: (Shape, String) -> Shape): List<Strategy> = input
    .split("\n")
    .map {
        val (a, b) = it.split(" ")
        val opponent = a.asStrategy()
        Strategy(opponent, bParser(opponent, b))
    }

fun part1(input: String): Int =
    parts(input) { _, b -> b.asStrategy() }

fun part2(input: String): Int =
    parts(input) { opponent, b ->
        when (b.asRequiredOutcome()) {
            WIN -> when (opponent) {
                ROCK -> PAPER
                PAPER -> SCISSORS
                SCISSORS -> ROCK
            }

            LOSE -> when (opponent) {
                ROCK -> SCISSORS
                PAPER -> ROCK
                SCISSORS -> PAPER
            }

            DRAW -> opponent
        }
    }

fun parts(input: String, youParser: (Shape, String) -> Shape): Int =
    parseInput(input, youParser).sumOf { it.score }

fun String.asRequiredOutcome(): Outcome = when (this) {
    "X" -> LOSE
    "Y" -> DRAW
    "Z" -> WIN
    else -> throw RuntimeException("Invalid string $this")
}

fun String.asStrategy(): Shape = when (this) {
    "A", "X" -> ROCK
    "B", "Y" -> PAPER
    "C", "Z" -> SCISSORS
    else -> throw RuntimeException("Invalid string $this")
}